"use client";

import React, { useState, useEffect, useCallback } from 'react';
import { motion, AnimatePresence } from 'framer-motion';
import { useTheme } from '@/lib/themeContext';
import { useAppSelector } from '@/lib/store/hooks';
import { commentService } from '@/lib/services/commentService';
import type { Comment } from '@/lib/store/authSlice';
import { Star, MessageSquare, Send, ChevronDown, ChevronUp, User } from 'lucide-react';
import Link from 'next/link';

interface ProductReviewsProps {
  productId: string;
}

/* ══════════════════════════════════════════════
 * Star Rating Input Component
 * ══════════════════════════════════════════════ */
function StarRatingInput({ value, onChange }: { value: number; onChange: (v: number) => void }) {
  const [hover, setHover] = useState(0);
  return (
    <div className="star-rating-input">
      {[1, 2, 3, 4, 5].map((s) => (
        <button
          key={s}
          type="button"
          onMouseEnter={() => setHover(s)}
          onMouseLeave={() => setHover(0)}
          onClick={() => onChange(s)}
        >
          <Star
            size={20}
            className={`star ${(hover || value) >= s ? 'filled' : ''}`}
            fill={(hover || value) >= s ? '#facc15' : 'none'}
          />
        </button>
      ))}
    </div>
  );
}

/* ══════════════════════════════════════════════
 * Star Display (read-only)
 * ══════════════════════════════════════════════ */
function StarDisplay({ rating, size = 12 }: { rating: number; size?: number }) {
  return (
    <div className="inline-flex gap-0.5">
      {[1, 2, 3, 4, 5].map((s) => (
        <Star
          key={s}
          size={size}
          className={s <= rating ? 'text-yellow-400' : 'text-zinc-600'}
          fill={s <= rating ? '#facc15' : 'none'}
        />
      ))}
    </div>
  );
}

/* ══════════════════════════════════════════════
 * Single Comment Component (recursive)
 * ══════════════════════════════════════════════ */
function CommentItem({
  comment,
  depth,
  onReply,
  isAuthenticated,
}: {
  comment: Comment;
  depth: number;
  onReply: (parentId: string, body: string) => void;
  isAuthenticated: boolean;
}) {
  const { theme } = useTheme();
  const [showReplies, setShowReplies] = useState(depth < 1);
  const [replyOpen, setReplyOpen] = useState(false);
  const [replyText, setReplyText] = useState('');
  const isDark = theme === 'dark';

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

  return (
    <div className={`${depth > 0 ? 'ml-6 pl-4 border-l-2' : ''} ${isDark ? 'border-neon-blue/10' : 'border-zinc-200'}`}>
      <div className="flex gap-3 py-3">
        {/* Avatar */}
        <div className={`w-8 h-8 rounded-full flex items-center justify-center text-xs font-black flex-shrink-0 ${
          isDark ? 'bg-neon-blue/10 text-neon-blue border border-neon-blue/20' : 'bg-primary/10 text-primary border border-primary/20'
        }`}>
          {comment.userName.charAt(0).toUpperCase()}
        </div>

        <div className="flex-1 min-w-0">
          {/* Name + time + rating */}
          <div className="flex items-center gap-2 flex-wrap">
            <span className="text-xs font-bold text-foreground">{comment.userName}</span>
            <span className="text-[10px] text-muted-foreground font-mono">{timeAgo(comment.createdAt)}</span>
            {comment.rating && <StarDisplay rating={comment.rating} size={10} />}
          </div>

          {/* Body */}
          <p className="text-xs text-zinc-600 dark:text-zinc-400 mt-1 leading-relaxed">{comment.body}</p>

          {/* Actions */}
          <div className="flex items-center gap-4 mt-2">
            {depth < 2 && isAuthenticated && (
              <button
                onClick={() => setReplyOpen(!replyOpen)}
                className="text-[10px] font-mono text-muted-foreground hover:text-primary transition-colors flex items-center gap-1 uppercase tracking-wider"
              >
                <MessageSquare size={10} /> Reply
              </button>
            )}
            {comment.children.length > 0 && (
              <button
                onClick={() => setShowReplies(!showReplies)}
                className="text-[10px] font-mono text-muted-foreground hover:text-primary transition-colors flex items-center gap-1"
              >
                {showReplies ? <ChevronUp size={10} /> : <ChevronDown size={10} />}
                {comment.children.length} {comment.children.length === 1 ? 'reply' : 'replies'}
              </button>
            )}
          </div>

          {/* Reply form */}
          <AnimatePresence>
            {replyOpen && (
              <motion.div
                initial={{ opacity: 0, height: 0 }}
                animate={{ opacity: 1, height: 'auto' }}
                exit={{ opacity: 0, height: 0 }}
                className="mt-3"
              >
                <div className="flex gap-2">
                  <input
                    value={replyText}
                    onChange={(e) => setReplyText(e.target.value)}
                    placeholder="Write a reply..."
                    className="flex-1 bg-secondary/40 border border-border rounded-lg px-3 py-2 text-xs font-mono text-foreground placeholder:text-muted-foreground/50 outline-none focus:ring-1 focus:ring-primary/30"
                    onKeyDown={(e) => e.key === 'Enter' && handleSubmitReply()}
                  />
                  <button
                    onClick={handleSubmitReply}
                    disabled={!replyText.trim()}
                    className="px-3 py-2 rounded-lg bg-primary/10 text-primary hover:bg-primary/20 transition-colors disabled:opacity-30"
                  >
                    <Send size={12} />
                  </button>
                </div>
              </motion.div>
            )}
          </AnimatePresence>
        </div>
      </div>

      {/* Children */}
      <AnimatePresence>
        {showReplies && comment.children.map((child) => (
          <motion.div
            key={child.id}
            initial={{ opacity: 0, y: -5 }}
            animate={{ opacity: 1, y: 0 }}
            exit={{ opacity: 0 }}
          >
            <CommentItem
              comment={child}
              depth={depth + 1}
              onReply={onReply}
              isAuthenticated={isAuthenticated}
            />
          </motion.div>
        ))}
      </AnimatePresence>
    </div>
  );
}

/* ══════════════════════════════════════════════
 * Main ProductReviews Component
 * ══════════════════════════════════════════════ */
export function ProductReviews({ productId }: ProductReviewsProps) {
  const { theme } = useTheme();
  const { isAuthenticated } = useAppSelector((s) => s.auth);
  const [comments, setComments] = useState<Comment[]>([]);
  const [newRating, setNewRating] = useState(0);
  const [newBody, setNewBody] = useState('');
  const [submitting, setSubmitting] = useState(false);
  const isDark = theme === 'dark';

  const loadComments = useCallback(async () => {
    const data = await commentService.getComments(productId);
    setComments(data);
  }, [productId]);

  useEffect(() => {
    loadComments();
  }, [loadComments]);

  // Rating stats
  const allRatings = comments.filter((c) => c.rating).map((c) => c.rating!);
  const avgRating = allRatings.length > 0 ? allRatings.reduce((a, b) => a + b, 0) / allRatings.length : 0;
  const totalReviews = allRatings.length;
  const ratingDistribution = [5, 4, 3, 2, 1].map((star) => ({
    star,
    count: allRatings.filter((r) => r === star).length,
    percent: allRatings.length > 0 ? (allRatings.filter((r) => r === star).length / allRatings.length) * 100 : 0,
  }));

  const handleSubmitComment = async () => {
    if (!newBody.trim() || newRating === 0) return;
    setSubmitting(true);
    const created = await commentService.postComment(productId, { body: newBody.trim(), rating: newRating });
    setComments((prev) => [created, ...prev]);
    setNewBody('');
    setNewRating(0);
    setSubmitting(false);
  };

  const handleReply = async (parentId: string, body: string) => {
    const created = await commentService.postComment(productId, { body, parentId });
    // Insert the reply into the tree
    setComments((prev) => {
      const addReply = (list: Comment[]): Comment[] =>
        list.map((c) =>
          c.id === parentId
            ? { ...c, children: [...c.children, created] }
            : { ...c, children: addReply(c.children) }
        );
      return addReply(prev);
    });
  };

  return (
    <div className="mt-12">
      <h3 className="text-xs font-bold uppercase tracking-widest text-zinc-500 font-mono mb-6">
        Customer Reviews & Feedback
      </h3>

      {/* Rating Summary */}
      <div className={`grid grid-cols-1 md:grid-cols-2 gap-6 p-6 rounded-xl border mb-8 ${
        isDark ? 'border-neon-blue/15 bg-secondary/20' : 'border-zinc-200 bg-zinc-50/50'
      }`}>
        {/* Left: Average */}
        <div className="flex flex-col items-center justify-center gap-2">
          <span className="text-4xl font-black font-mono text-foreground">{avgRating.toFixed(1)}</span>
          <StarDisplay rating={Math.round(avgRating)} size={16} />
          <span className="text-[10px] text-muted-foreground font-mono uppercase tracking-wider">
            {totalReviews} {totalReviews === 1 ? 'review' : 'reviews'}
          </span>
        </div>

        {/* Right: Distribution bars */}
        <div className="flex flex-col gap-1.5">
          {ratingDistribution.map((item) => (
            <div key={item.star} className="flex items-center gap-2">
              <span className="text-[10px] font-mono text-muted-foreground w-3">{item.star}</span>
              <Star size={10} className="text-yellow-400" fill="#facc15" />
              <div className={`flex-1 h-2 rounded-full overflow-hidden ${isDark ? 'bg-zinc-800' : 'bg-zinc-200'}`}>
                <motion.div
                  initial={{ width: 0 }}
                  animate={{ width: `${item.percent}%` }}
                  transition={{ duration: 0.5, delay: 0.1 * (5 - item.star) }}
                  className="h-full rounded-full bg-yellow-400"
                />
              </div>
              <span className="text-[10px] font-mono text-muted-foreground w-5 text-right">{item.count}</span>
            </div>
          ))}
        </div>
      </div>

      {/* New review form */}
      {isAuthenticated ? (
        <div className={`p-5 rounded-xl border mb-8 ${isDark ? 'border-neon-blue/15 bg-secondary/10' : 'border-zinc-200 bg-white'}`}>
          <div className="flex items-center gap-3 mb-4">
            <span className="text-[10px] font-mono uppercase tracking-widest text-muted-foreground font-bold">Your Rating</span>
            <StarRatingInput value={newRating} onChange={setNewRating} />
          </div>
          <textarea
            value={newBody}
            onChange={(e) => setNewBody(e.target.value)}
            placeholder="Share your experience with this product..."
            rows={3}
            className="w-full bg-secondary/40 border border-border rounded-lg px-4 py-3 text-xs font-mono text-foreground placeholder:text-muted-foreground/50 outline-none focus:ring-2 focus:ring-primary/30 resize-none mb-3"
          />
          <div className="flex justify-between items-center">
            <span className="text-[10px] text-muted-foreground font-mono">{newBody.length}/500</span>
            <button
              onClick={handleSubmitComment}
              disabled={submitting || !newBody.trim() || newRating === 0}
              className={`px-5 py-2 rounded-lg text-xs font-black uppercase tracking-widest transition-all flex items-center gap-2 disabled:opacity-30 ${
                isDark ? 'bg-neon-blue text-black hover:shadow-[0_0_20px_rgba(0,240,255,0.3)]' : 'bg-primary text-white hover:bg-primary/90'
              }`}
            >
              <Send size={12} /> Post Review
            </button>
          </div>
        </div>
      ) : (
        <div className={`p-5 rounded-xl border mb-8 text-center ${isDark ? 'border-neon-blue/15 bg-secondary/10' : 'border-zinc-200 bg-zinc-50'}`}>
          <User size={20} className="mx-auto text-muted-foreground mb-2" />
          <p className="text-xs text-muted-foreground font-mono mb-3">Sign in to leave a review</p>
          <Link
            href="/auth"
            className={`inline-block px-5 py-2 rounded-lg text-xs font-bold uppercase tracking-wider transition-all ${
              isDark ? 'border border-neon-blue/30 text-neon-blue hover:bg-neon-blue/10' : 'border border-primary/30 text-primary hover:bg-primary/10'
            }`}
          >
            Sign In
          </Link>
        </div>
      )}

      {/* Comments list */}
      <div className="flex flex-col">
        {comments.length === 0 ? (
          <p className="text-xs text-muted-foreground font-mono text-center py-8">No reviews yet. Be the first to share your experience.</p>
        ) : (
          comments.map((comment) => (
            <CommentItem
              key={comment.id}
              comment={comment}
              depth={0}
              onReply={handleReply}
              isAuthenticated={isAuthenticated}
            />
          ))
        )}
      </div>
    </div>
  );
}
