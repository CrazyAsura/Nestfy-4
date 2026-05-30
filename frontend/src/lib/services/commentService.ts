import axios from 'axios';
import type { Comment } from '@/lib/store/authSlice';

/* ──────────────────────────────────────────────
 * Comment Service — Outbound Adapter
 * Handles product reviews and nested replies.
 * ────────────────────────────────────────────── */

const API_BASE = process.env.NEXT_PUBLIC_API_URL || 'http://localhost:8080/api';

const api = axios.create({
  baseURL: API_BASE,
  headers: { 'Content-Type': 'application/json' },
  timeout: 15_000,
});

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

export interface CreateCommentDTO {
  body: string;
  rating?: number;
  parentId?: string | null;
}

/* ──────────────────────────────────────────────
 * Mock Data (used while backend is not connected)
 * ────────────────────────────────────────────── */

const MOCK_COMMENTS: Record<string, Comment[]> = {
  p1: [
    {
      id: 'c1',
      productId: 'p1',
      userId: 'u1',
      userName: 'Kira Tanaka',
      rating: 5,
      body: 'Absolutely phenomenal hub. The offline voice processing is instant and the Matter protocol bridging works flawlessly with my Zigbee sensors.',
      parentId: null,
      createdAt: '2026-05-28T14:30:00Z',
      children: [
        {
          id: 'c1-r1',
          productId: 'p1',
          userId: 'u2',
          userName: 'Marcus Veil',
          body: 'Same experience here. The local processing keeps everything snappy even without internet.',
          parentId: 'c1',
          createdAt: '2026-05-28T16:10:00Z',
          children: [],
        },
      ],
    },
    {
      id: 'c2',
      productId: 'p1',
      userId: 'u3',
      userName: 'Elara Frost',
      rating: 4,
      body: 'Great hub overall. Only docked one star because the initial setup wizard could be more intuitive. Once configured, it runs like a dream.',
      parentId: null,
      createdAt: '2026-05-27T09:15:00Z',
      children: [],
    },
    {
      id: 'c3',
      productId: 'p1',
      userId: 'u4',
      userName: 'Dex Calloway',
      rating: 5,
      body: 'The quantum-safe encryption chip gives me peace of mind. This is exactly what a modern smart home needs.',
      parentId: null,
      createdAt: '2026-05-25T20:45:00Z',
      children: [
        {
          id: 'c3-r1',
          productId: 'p1',
          userId: 'u5',
          userName: 'Nova Chen',
          body: 'Agreed. The security architecture is enterprise-grade. Worth every cent.',
          parentId: 'c3',
          createdAt: '2026-05-26T08:00:00Z',
          children: [],
        },
        {
          id: 'c3-r2',
          productId: 'p1',
          userId: 'u1',
          userName: 'Kira Tanaka',
          body: 'The dual-band mesh coverage is also insane. Covers my entire 200m² apartment.',
          parentId: 'c3',
          createdAt: '2026-05-26T11:30:00Z',
          children: [],
        },
      ],
    },
  ],
  p2: [
    {
      id: 'c4',
      productId: 'p2',
      userId: 'u2',
      userName: 'Marcus Veil',
      rating: 5,
      body: 'The self-learning schedule is incredible. After just one week it perfectly matched my temperature preferences throughout the day.',
      parentId: null,
      createdAt: '2026-05-26T12:00:00Z',
      children: [],
    },
  ],
  p3: [
    {
      id: 'c5',
      productId: 'p3',
      userId: 'u5',
      userName: 'Nova Chen',
      rating: 4,
      body: 'LiDAR mapping is next level. It navigated around my furniture legs without a single bump. The self-cleaning dock is the real MVP though.',
      parentId: null,
      createdAt: '2026-05-24T18:20:00Z',
      children: [],
    },
  ],
};

/* ──────────────────────────────────────────────
 * Service Implementation
 * ────────────────────────────────────────────── */

export const commentService = {
  /**
   * Fetch comments for a product.
   * Falls back to mock data when backend is unreachable.
   */
  async getComments(productId: string): Promise<Comment[]> {
    try {
      const response = await api.get<Comment[]>(`/products/${productId}/comments`);
      return response.data;
    } catch {
      // Fallback to mock data during development
      return MOCK_COMMENTS[productId] || [];
    }
  },

  /**
   * Post a new comment or reply.
   */
  async postComment(productId: string, data: CreateCommentDTO): Promise<Comment> {
    try {
      const response = await api.post<Comment>(`/products/${productId}/comments`, data);
      return response.data;
    } catch {
      // Mock response for development
      const newComment: Comment = {
        id: `c-${Date.now()}`,
        productId,
        userId: 'mock-user',
        userName: 'You',
        rating: data.rating,
        body: data.body,
        parentId: data.parentId || null,
        createdAt: new Date().toISOString(),
        children: [],
      };
      return newComment;
    }
  },

  /**
   * Delete a comment.
   */
  async deleteComment(commentId: string): Promise<void> {
    try {
      await api.delete(`/comments/${commentId}`);
    } catch {
      // Silent fail in dev
    }
  },
};
