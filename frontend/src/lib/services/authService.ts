import axios from 'axios';

/* ──────────────────────────────────────────────
 * Base API Configuration
 * Port-Adapter pattern: this module is the outbound adapter
 * for the authentication bounded context.
 * ────────────────────────────────────────────── */

const API_BASE = process.env.NEXT_PUBLIC_API_URL || 'http://localhost:8080/api';

const api = axios.create({
  baseURL: API_BASE,
  headers: { 'Content-Type': 'application/json' },
  timeout: 15_000,
});

// Attach JWT token to every request if available
api.interceptors.request.use((config) => {
  if (typeof window !== 'undefined') {
    const token = localStorage.getItem('nestfy-token');
    if (token) {
      config.headers.Authorization = `Bearer ${token}`;
    }
  }
  return config;
});

/* ──────────────────────────────────────────────
 * DTOs
 * ────────────────────────────────────────────── */

export interface LoginDTO {
  email: string;
  password: string;
}

export interface RegisterClientDTO {
  name: string;
  email: string;
  cpf: string;
  phone: string;
  password: string;
}

export interface RegisterSailorDTO {
  name: string;
  email: string;
  cnpj: string;
  companyName: string;
  businessDescription: string;
  phone: string;
  password: string;
}

export interface AuthResponseDTO {
  token: string;
  user: {
    id: string;
    name: string;
    email: string;
    role: 'CLIENT' | 'MERCHANT';
  };
}

export interface ForgotPasswordDTO {
  email: string;
}

export interface ResetPasswordDTO {
  token: string;
  newPassword: string;
}

/* ──────────────────────────────────────────────
 * Auth Service (Outbound Port Implementation)
 * ────────────────────────────────────────────── */

export const authService = {
  async login(data: LoginDTO): Promise<AuthResponseDTO> {
    const response = await api.post<AuthResponseDTO>('/auth/login', data);
    if (response.data.token) {
      localStorage.setItem('nestfy-token', response.data.token);
    }
    return response.data;
  },

  async registerClient(data: RegisterClientDTO): Promise<AuthResponseDTO> {
    const response = await api.post<AuthResponseDTO>('/auth/register/client', data);
    if (response.data.token) {
      localStorage.setItem('nestfy-token', response.data.token);
    }
    return response.data;
  },

  async registerSailor(data: RegisterSailorDTO): Promise<AuthResponseDTO> {
    const response = await api.post<AuthResponseDTO>('/auth/register/merchant', data);
    if (response.data.token) {
      localStorage.setItem('nestfy-token', response.data.token);
    }
    return response.data;
  },

  async forgotPassword(data: ForgotPasswordDTO): Promise<{ message: string }> {
    const response = await api.post<{ message: string }>('/auth/forgot-password', data);
    return response.data;
  },

  async resetPassword(data: ResetPasswordDTO): Promise<{ message: string }> {
    const response = await api.post<{ message: string }>('/auth/reset-password', data);
    return response.data;
  },

  googleOAuthRedirect(): void {
    const backendUrl = process.env.NEXT_PUBLIC_API_URL || 'http://localhost:8080';
    window.location.href = `${backendUrl}/oauth2/authorization/google`;
  },

  logout(): void {
    localStorage.removeItem('nestfy-token');
  },
};
