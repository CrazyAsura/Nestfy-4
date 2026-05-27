import axios, { AxiosError, AxiosInstance, InternalAxiosRequestConfig } from 'axios';

// ─── Configuration ───────────────────────────────────────────
const PRIMARY_URL = process.env.NEXT_PUBLIC_API_URL || 'http://localhost:8080';
const BACKUP_URL = process.env.NEXT_PUBLIC_BACKUP_API_URL || '';

// Track the current active backend URL and status
let activeBaseUrl = PRIMARY_URL;
let isBackupActive = false;
let checkPrimaryInterval: NodeJS.Timeout | null = null;

// Create the Axios client instance
export const api: AxiosInstance = axios.create({
  baseURL: activeBaseUrl,
  timeout: 10000, // 10s timeout to detect offline cloud backend quickly
  headers: {
    'Content-Type': 'application/json',
  },
});

// Request Interceptor: Ensure it always uses the current active URL
api.interceptors.request.use(
  (config: InternalAxiosRequestConfig) => {
    config.baseURL = activeBaseUrl;
    return config;
  },
  (error) => Promise.reject(error)
);

// Response Interceptor: Handle failures and trigger failover
api.interceptors.response.use(
  (response) => response,
  async (error: AxiosError) => {
    const originalRequest = error.config;
    
    // Check if the error is due to a network connection failure or timeout
    const isNetworkError = !error.response;
    const isTimeout = error.code === 'ECONNABORTED';

    if ((isNetworkError || isTimeout) && originalRequest && !originalRequest.headers.get('x-failover-retry')) {
      // If we have a backup URL and we are not already on the backup
      if (BACKUP_URL && !isBackupActive) {
        console.warn(`[API Failover] Primary backend (${PRIMARY_URL}) is down. Swapping to backup (${BACKUP_URL})...`);
        
        // Swapping environment state
        activeBaseUrl = BACKUP_URL;
        isBackupActive = true;
        
        // Mark the request to prevent infinite loops if backup is also down
        originalRequest.headers.set('x-failover-retry', 'true');
        originalRequest.baseURL = BACKUP_URL;

        // Start background health-checking to revert back to primary once restored
        startPrimaryHealthCheck();

        // Retry the original request with the new baseURL
        return api(originalRequest);
      }
    }

    return Promise.reject(error);
  }
);

// ─── Health Checker ──────────────────────────────────────────
function startPrimaryHealthCheck() {
  if (checkPrimaryInterval) return;

  console.info('[API Failover] Health checker started for primary backend.');
  checkPrimaryInterval = setInterval(async () => {
    try {
      // Direct lightweight ping to the primary backend health endpoint
      await axios.get(`${PRIMARY_URL}/actuator/health`, { timeout: 3000 });
      
      // If successful, switch back to primary
      console.info(`[API Failover] Primary backend (${PRIMARY_URL}) recovered! Swapping back...`);
      activeBaseUrl = PRIMARY_URL;
      isBackupActive = false;
      
      // Stop checking
      if (checkPrimaryInterval) {
        clearInterval(checkPrimaryInterval);
        checkPrimaryInterval = null;
      }
    } catch {
      console.debug('[API Failover] Primary backend still down. Retrying health check later...');
    }
  }, 30000); // Check every 30 seconds
}
