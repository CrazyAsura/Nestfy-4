"use client";

import React, { useState } from 'react';
import Link from 'next/link';
import { motion, AnimatePresence } from 'framer-motion';
import { useTheme } from '@/lib/themeContext';
import { authService } from '@/lib/services/authService';
import { useForm } from 'react-hook-form';
import { Anchor, ArrowLeft, Mail, CheckCircle2 } from 'lucide-react';

interface ForgotFormValues {
  email: string;
}

export default function SailorForgotPasswordPage() {
  const { theme } = useTheme();
  const [loading, setLoading] = useState(false);
  const [sent, setSent] = useState(false);
  const [error, setError] = useState('');

  const { register, handleSubmit, formState: { errors } } = useForm<ForgotFormValues>();

  const onSubmit = async (data: ForgotFormValues) => {
    setLoading(true);
    setError('');
    try {
      await authService.forgotPassword({ email: data.email });
      setSent(true);
    } catch {
      setError('Failed to send reset link. Please check your email.');
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="relative min-h-screen bg-background text-foreground flex items-center justify-center overflow-hidden transition-colors duration-300">
      <div className="absolute inset-0 sailor-grid opacity-40" />
      <div className="absolute top-[-30%] left-[-20%] w-[70%] h-[70%] bg-[radial-gradient(ellipse_at_center,rgba(255,184,0,0.06),transparent_60%)] pointer-events-none" />

      <motion.div
        initial={{ opacity: 0, y: 30 }}
        animate={{ opacity: 1, y: 0 }}
        transition={{ duration: 0.7, ease: [0.16, 1, 0.3, 1] }}
        className="relative z-10 w-full max-w-md px-6"
      >
        <Link href="/auth/sailor/login" className="inline-flex items-center gap-2 text-xs uppercase font-mono tracking-widest text-muted-foreground hover:text-sailor-amber transition-colors mb-8">
          <ArrowLeft size={12} /> Back to Login
        </Link>

        <div className="auth-card-sailor rounded-2xl p-8 md:p-10 relative overflow-hidden">
          <div className="absolute top-3 left-3 border-t border-l border-sailor-amber/30 w-5 h-5" />
          <div className="absolute top-3 right-3 border-t border-r border-sailor-amber/30 w-5 h-5" />
          <div className="absolute bottom-3 left-3 border-b border-l border-sailor-amber/30 w-5 h-5" />
          <div className="absolute bottom-3 right-3 border-b border-r border-sailor-amber/30 w-5 h-5" />
          <div className="absolute inset-0 opacity-[0.03] pointer-events-none" style={{ backgroundImage: `repeating-linear-gradient(45deg, transparent, transparent 20px, rgba(255,184,0,0.3) 20px, rgba(255,184,0,0.3) 21px)` }} />

          <div className="relative z-10">
            <div className="flex flex-col items-center gap-3 mb-8">
              <div className="flex items-center gap-2">
                <Anchor size={16} className="text-sailor-amber" />
                <span className="text-[10px] font-mono font-black tracking-[0.3em] uppercase text-sailor-amber">Nestfy Sailor</span>
              </div>
              <h1 className="text-xl font-black uppercase tracking-wider text-foreground">Reset Password</h1>
              <p className="text-[10px] text-muted-foreground font-mono tracking-wider text-center">
                Enter your merchant email to receive a secure reset link
              </p>
            </div>

            <AnimatePresence mode="wait">
              {!sent ? (
                <motion.div key="form" initial={{ opacity: 1 }} exit={{ opacity: 0 }}>
                  {error && (
                    <div className="mb-4 p-3 rounded-lg border border-red-500/30 bg-red-500/5 text-red-500 text-xs font-mono">{error}</div>
                  )}
                  <form onSubmit={handleSubmit(onSubmit)} className="flex flex-col gap-5">
                    <div className="flex flex-col gap-1.5">
                      <label className="text-[10px] uppercase tracking-widest text-muted-foreground font-bold font-mono">Business Email</label>
                      <input
                        type="email"
                        placeholder="merchant@nestfy.com"
                        {...register('email', { required: 'Email is required', pattern: { value: /^\S+@\S+\.\S+$/, message: 'Invalid email format' } })}
                        className={`w-full bg-secondary/40 border rounded-lg px-4 py-3 text-sm font-mono text-foreground placeholder:text-muted-foreground/50 outline-none focus:ring-2 focus:ring-sailor-amber/30 ${errors.email ? 'border-red-500' : 'border-border'}`}
                      />
                      {errors.email && <span className="text-[10px] text-red-500 font-mono">{errors.email.message}</span>}
                    </div>
                    <button type="submit" disabled={loading} className="w-full py-3 rounded-lg text-xs font-black uppercase tracking-widest transition-all flex items-center justify-center gap-2 disabled:opacity-50 bg-sailor-amber text-black hover:shadow-[0_0_30px_rgba(255,184,0,0.4)]">
                      {loading ? <div className="h-4 w-4 animate-spin rounded-full border-2 border-black border-t-transparent" /> : <><Mail size={14} /> Send Reset Link</>}
                    </button>
                  </form>
                </motion.div>
              ) : (
                <motion.div key="success" initial={{ opacity: 0, scale: 0.95 }} animate={{ opacity: 1, scale: 1 }} className="flex flex-col items-center gap-5 py-6">
                  <motion.div initial={{ scale: 0 }} animate={{ scale: 1 }} transition={{ delay: 0.2, type: 'spring', stiffness: 200 }}>
                    <CheckCircle2 size={48} className="text-sailor-amber" />
                  </motion.div>
                  <div className="text-center">
                    <h2 className="text-sm font-black uppercase tracking-wider text-foreground mb-2">Link Dispatched</h2>
                    <p className="text-xs text-muted-foreground font-mono leading-relaxed">
                      A secure password reset link has been sent to your merchant email via Google SMTP.
                    </p>
                  </div>
                  <Link href="/auth/sailor/login" className="px-6 py-2.5 rounded-lg text-xs font-bold uppercase tracking-wider transition-all border border-sailor-amber/30 text-sailor-amber hover:bg-sailor-amber-dim">
                    Return to Login
                  </Link>
                </motion.div>
              )}
            </AnimatePresence>
          </div>
        </div>
      </motion.div>
    </div>
  );
}
