import { createSlice, PayloadAction } from '@reduxjs/toolkit';

/* ──────────────────────────────────────────────
 * Domain Types
 * ────────────────────────────────────────────── */

export type UserRole = 'CLIENT' | 'MERCHANT';

export interface AuthUser {
  id: string;
  name: string;
  email: string;
  role: UserRole;
  avatarUrl?: string;
}

export interface Comment {
  id: string;
  productId: string;
  userId: string;
  userName: string;
  rating?: number; // 1-5 stars (only on root comments)
  body: string;
  parentId: string | null;
  createdAt: string;
  children: Comment[];
}

/* ──────────────────────────────────────────────
 * State Shape
 * ────────────────────────────────────────────── */

interface AuthState {
  user: AuthUser | null;
  token: string | null;
  isAuthenticated: boolean;
  loading: boolean;
  error: string | null;
}

const initialState: AuthState = {
  user: null,
  token: null,
  isAuthenticated: false,
  loading: false,
  error: null,
};

/* ──────────────────────────────────────────────
 * Slice
 * ────────────────────────────────────────────── */

const authSlice = createSlice({
  name: 'auth',
  initialState,
  reducers: {
    setLoading(state, action: PayloadAction<boolean>) {
      state.loading = action.payload;
      if (action.payload) state.error = null;
    },
    loginSuccess(state, action: PayloadAction<{ user: AuthUser; token: string }>) {
      state.user = action.payload.user;
      state.token = action.payload.token;
      state.isAuthenticated = true;
      state.loading = false;
      state.error = null;
    },
    setUser(state, action: PayloadAction<AuthUser>) {
      state.user = action.payload;
    },
    setError(state, action: PayloadAction<string>) {
      state.error = action.payload;
      state.loading = false;
    },
    logout(state) {
      state.user = null;
      state.token = null;
      state.isAuthenticated = false;
      state.loading = false;
      state.error = null;
      if (typeof window !== 'undefined') {
        localStorage.removeItem('nestfy-token');
      }
    },
  },
});

export const { setLoading, loginSuccess, setUser, setError, logout } = authSlice.actions;
export default authSlice.reducer;
