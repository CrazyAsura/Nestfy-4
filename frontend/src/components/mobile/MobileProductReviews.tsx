"use client";

import React, { useState, useEffect, useCallback } from 'react';
import { useTheme } from '@/lib/themeContext';
import { useAppSelector } from '@/lib/store/hooks';
import { commentService } from '@/lib/services/commentService';
import type { Comment } from '@/lib/store/authSlice';
import {
  Box, Typography, Button, TextField, IconButton, Card, CardContent,
  Rating, Collapse, LinearProgress, Stack, Chip, Avatar,
} from '@mui/material';
import SendIcon from '@mui/icons-material/Send';
import ReplyIcon from '@mui/icons-material/Reply';
import ExpandMoreIcon from '@mui/icons-material/ExpandMore';
import ExpandLessIcon from '@mui/icons-material/ExpandLess';
import PersonIcon from '@mui/icons-material/Person';
import Link from 'next/link';

interface MobileProductReviewsProps {
  productId: string;
}

/* ══════════════════════════════════════════════
 * Mobile Comment Item (MUI-based, recursive)
 * ══════════════════════════════════════════════ */
function MobileCommentItem({
  comment,
  depth,
  onReply,
  isAuthenticated,
  themeMode,
}: {
  comment: Comment;
  depth: number;
  onReply: (parentId: string, body: string) => void;
  isAuthenticated: boolean;
  themeMode: string;
}) {
  const [showReplies, setShowReplies] = useState(depth < 1);
  const [replyOpen, setReplyOpen] = useState(false);
  const [replyText, setReplyText] = useState('');

  const handleSubmitReply = () => {
    if (replyText.trim()) {
      onReply(comment.id, replyText.trim());
      setReplyText('');
      setReplyOpen(false);
    }
  };

  const timeAgo = (dateStr: string) => {
    const diff = Date.now() - new Date(dateStr).getTime();
    const days = Math.floor(diff / 86400000);
    if (days > 0) return `${days}d ago`;
    const hours = Math.floor(diff / 3600000);
    if (hours > 0) return `${hours}h ago`;
    return 'just now';
  };

  const isDark = themeMode === 'dark';
  const accentColor = isDark ? '#00f0ff' : '#0066cc';

  return (
    <Box sx={{ ml: depth > 0 ? 3 : 0, pl: depth > 0 ? 2 : 0, borderLeft: depth > 0 ? `2px solid ${isDark ? 'rgba(0,240,255,0.1)' : 'rgba(0,0,0,0.06)'}` : 'none' }}>
      <Box sx={{ display: 'flex', gap: 1.5, py: 1.5 }}>
        <Avatar sx={{ width: 28, height: 28, fontSize: '0.7rem', fontWeight: 800, bgcolor: isDark ? 'rgba(0,240,255,0.1)' : 'rgba(0,102,204,0.1)', color: accentColor, border: `1px solid ${isDark ? 'rgba(0,240,255,0.2)' : 'rgba(0,102,204,0.2)'}` }}>
          {comment.userName.charAt(0).toUpperCase()}
        </Avatar>
        <Box sx={{ flex: 1, minWidth: 0 }}>
          <Box sx={{ display: 'flex', alignItems: 'center', gap: 1, flexWrap: 'wrap' }}>
            <Typography variant="caption" sx={{ fontWeight: 700 }}>{comment.userName}</Typography>
            <Typography variant="caption" sx={{ fontSize: '0.6rem', color: 'text.secondary', fontFamily: 'monospace' }}>{timeAgo(comment.createdAt)}</Typography>
            {comment.rating && <Rating value={comment.rating} size="small" readOnly sx={{ fontSize: '0.7rem' }} />}
          </Box>
          <Typography variant="caption" sx={{ color: 'text.secondary', display: 'block', mt: 0.5, lineHeight: 1.5 }}>{comment.body}</Typography>

          <Box sx={{ display: 'flex', gap: 2, mt: 1 }}>
            {depth < 2 && isAuthenticated && (
              <Chip label="Reply" size="small" icon={<ReplyIcon sx={{ fontSize: 12 }} />} variant="outlined" onClick={() => setReplyOpen(!replyOpen)} sx={{ height: 22, fontSize: '0.6rem', borderColor: isDark ? 'rgba(0,240,255,0.2)' : 'rgba(0,0,0,0.1)' }} />
            )}
            {comment.children.length > 0 && (
              <Chip
                label={`${comment.children.length} ${comment.children.length === 1 ? 'reply' : 'replies'}`}
                size="small"
                icon={showReplies ? <ExpandLessIcon sx={{ fontSize: 12 }} /> : <ExpandMoreIcon sx={{ fontSize: 12 }} />}
                variant="outlined"
                onClick={() => setShowReplies(!showReplies)}
                sx={{ height: 22, fontSize: '0.6rem', borderColor: isDark ? 'rgba(0,240,255,0.2)' : 'rgba(0,0,0,0.1)' }}
              />
            )}
          </Box>

          <Collapse in={replyOpen}>
            <Box sx={{ display: 'flex', gap: 1, mt: 1.5 }}>
              <TextField
                value={replyText}
                onChange={(e) => setReplyText(e.target.value)}
                placeholder="Write a reply..."
                size="small"
                fullWidth
                sx={{ '& .MuiInputBase-root': { fontSize: '0.75rem', fontFamily: 'monospace' } }}
                onKeyDown={(e) => e.key === 'Enter' && handleSubmitReply()}
              />
              <IconButton size="small" onClick={handleSubmitReply} disabled={!replyText.trim()} sx={{ color: accentColor }}>
                <SendIcon sx={{ fontSize: 16 }} />
              </IconButton>
            </Box>
          </Collapse>
        </Box>
      </Box>

      <Collapse in={showReplies}>
        {comment.children.map((child) => (
          <MobileCommentItem key={child.id} comment={child} depth={depth + 1} onReply={onReply} isAuthenticated={isAuthenticated} themeMode={themeMode} />
        ))}
      </Collapse>
    </Box>
  );
}

/* ══════════════════════════════════════════════
 * Main Mobile Reviews Component
 * ══════════════════════════════════════════════ */
export function MobileProductReviews({ productId }: MobileProductReviewsProps) {
  const { theme } = useTheme();
  const { isAuthenticated } = useAppSelector((s) => s.auth);
  const [comments, setComments] = useState<Comment[]>([]);
  const [newRating, setNewRating] = useState<number | null>(0);
  const [newBody, setNewBody] = useState('');
  const [submitting, setSubmitting] = useState(false);
  const isDark = theme === 'dark';
  const accentColor = isDark ? '#00f0ff' : '#0066cc';

  const loadComments = useCallback(async () => {
    const data = await commentService.getComments(productId);
    setComments(data);
  }, [productId]);

  useEffect(() => {
    loadComments();
  }, [loadComments]);

  const allRatings = comments.filter((c) => c.rating).map((c) => c.rating!);
  const avgRating = allRatings.length > 0 ? allRatings.reduce((a, b) => a + b, 0) / allRatings.length : 0;
  const totalReviews = allRatings.length;

  const handleSubmitComment = async () => {
    if (!newBody.trim() || !newRating) return;
    setSubmitting(true);
    const created = await commentService.postComment(productId, { body: newBody.trim(), rating: newRating });
    setComments((prev) => [created, ...prev]);
    setNewBody('');
    setNewRating(0);
    setSubmitting(false);
  };

  const handleReply = async (parentId: string, body: string) => {
    const created = await commentService.postComment(productId, { body, parentId });
    setComments((prev) => {
      const addReply = (list: Comment[]): Comment[] =>
        list.map((c) =>
          c.id === parentId ? { ...c, children: [...c.children, created] } : { ...c, children: addReply(c.children) }
        );
      return addReply(prev);
    });
  };

  return (
    <Box sx={{ mt: 4 }}>
      <Typography variant="subtitle2" sx={{ fontWeight: 'bold', mb: 2, textTransform: 'uppercase', letterSpacing: '0.05em' }}>
        Customer Reviews
      </Typography>

      {/* Rating Summary Card */}
      <Card sx={{ mb: 3, bgcolor: 'background.paper', backgroundImage: 'none' }}>
        <CardContent sx={{ p: '16px !important' }}>
          <Box sx={{ display: 'flex', alignItems: 'center', gap: 3 }}>
            <Box sx={{ textAlign: 'center' }}>
              <Typography variant="h4" sx={{ fontWeight: 900, fontFamily: 'monospace' }}>{avgRating.toFixed(1)}</Typography>
              <Rating value={avgRating} precision={0.5} readOnly size="small" />
              <Typography variant="caption" sx={{ display: 'block', color: 'text.secondary', fontFamily: 'monospace', fontSize: '0.6rem', mt: 0.5 }}>
                {totalReviews} reviews
              </Typography>
            </Box>
            <Box sx={{ flex: 1 }}>
              {[5, 4, 3, 2, 1].map((star) => {
                const count = allRatings.filter((r) => r === star).length;
                const pct = allRatings.length > 0 ? (count / allRatings.length) * 100 : 0;
                return (
                  <Stack key={star} direction="row" spacing={1} sx={{ alignItems: 'center', mb: 0.5 }}>
                    <Typography variant="caption" sx={{ fontSize: '0.6rem', fontFamily: 'monospace', width: 12 }}>{star}</Typography>
                    <LinearProgress variant="determinate" value={pct} sx={{ flex: 1, height: 6, borderRadius: 3, bgcolor: isDark ? 'rgba(255,255,255,0.05)' : 'rgba(0,0,0,0.05)', '& .MuiLinearProgress-bar': { bgcolor: '#facc15', borderRadius: 3 } }} />
                    <Typography variant="caption" sx={{ fontSize: '0.6rem', fontFamily: 'monospace', width: 12, textAlign: 'right' }}>{count}</Typography>
                  </Stack>
                );
              })}
            </Box>
          </Box>
        </CardContent>
      </Card>

      {/* New Review */}
      {isAuthenticated ? (
        <Card sx={{ mb: 3, bgcolor: 'background.paper', backgroundImage: 'none' }}>
          <CardContent sx={{ p: '16px !important' }}>
            <Box sx={{ display: 'flex', alignItems: 'center', gap: 1, mb: 2 }}>
              <Typography variant="caption" sx={{ fontWeight: 700, textTransform: 'uppercase', letterSpacing: '0.08em', fontSize: '0.6rem' }}>Rating</Typography>
              <Rating value={newRating} onChange={(_, v) => setNewRating(v)} size="small" />
            </Box>
            <TextField
              value={newBody}
              onChange={(e) => setNewBody(e.target.value)}
              placeholder="Share your experience..."
              multiline
              rows={2}
              fullWidth
              size="small"
              sx={{ mb: 2, '& .MuiInputBase-root': { fontSize: '0.8rem', fontFamily: 'monospace' } }}
            />
            <Box sx={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center' }}>
              <Typography variant="caption" sx={{ color: 'text.secondary', fontFamily: 'monospace', fontSize: '0.6rem' }}>{newBody.length}/500</Typography>
              <Button variant="contained" size="small" onClick={handleSubmitComment} disabled={submitting || !newBody.trim() || !newRating} startIcon={<SendIcon sx={{ fontSize: 14 }} />} sx={{ fontSize: '0.65rem', fontWeight: 700, textTransform: 'uppercase', letterSpacing: '0.05em' }}>
                Post
              </Button>
            </Box>
          </CardContent>
        </Card>
      ) : (
        <Card sx={{ mb: 3, bgcolor: 'background.paper', backgroundImage: 'none', textAlign: 'center' }}>
          <CardContent sx={{ p: '20px !important' }}>
            <PersonIcon sx={{ fontSize: 24, color: 'text.secondary', mb: 1 }} />
            <Typography variant="caption" sx={{ display: 'block', color: 'text.secondary', fontFamily: 'monospace', mb: 1.5 }}>Sign in to leave a review</Typography>
            <Link href="/auth" style={{ textDecoration: 'none' }}>
              <Button variant="outlined" size="small" sx={{ fontSize: '0.65rem', fontWeight: 700, borderColor: accentColor, color: accentColor }}>
                Sign In
              </Button>
            </Link>
          </CardContent>
        </Card>
      )}

      {/* Comments list */}
      {comments.length === 0 ? (
        <Typography variant="caption" sx={{ display: 'block', textAlign: 'center', color: 'text.secondary', fontFamily: 'monospace', py: 4 }}>
          No reviews yet. Be the first!
        </Typography>
      ) : (
        comments.map((comment) => (
          <MobileCommentItem key={comment.id} comment={comment} depth={0} onReply={handleReply} isAuthenticated={isAuthenticated} themeMode={theme} />
        ))
      )}
    </Box>
  );
}
