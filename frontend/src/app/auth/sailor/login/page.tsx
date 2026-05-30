"use client";

import React, { useState } from 'react';
import Link from 'next/link';
import { motion } from 'framer-motion';
import { useTheme } from '@/lib/themeContext';
import { useAppDispatch, useAppSelector } from '@/lib/store/hooks';
import { loginSuccess, setLoading, setError } from '@/lib/store/authSlice';
import { authService } from '@/lib/services/authService';
import { useForm } from 'react-hook-form';
import { Anchor, Eye, EyeOff, ArrowLeft, LogIn } from 'lucide-react';

interface LoginFormValues {
  email: string;
  password: string;
}

export default function SailorLoginPage() {
  const { theme } = useTheme();
  const dispatch = useAppDispatch();
  const { loading, error } = useAppSelector((s) => s.auth);
  const [showPassword, setShowPassword] = useState(false);
  const isDark = theme === 'dark';

  const { register, handleSubmit, formState: { errors } } = useForm<LoginFormValues>();

  const onSubmit = async (data: LoginFormValues) => {
    dispatch(setLoading(true));
    try {
      const res = await authService.login(data);
      dispatch(loginSuccess({ user: { ...res.user, role: 'MERCHANT' }, token: res.token }));
      window.location.href = '/';
    } catch {
      dispatch(setError('Invalid credentials. Check your merchant access.'));
    }
  };

  const handleGoogleLogin = () => {
    authService.googleOAuthRedirect();
  };

  return (
    <div className="relative min-h-screen bg-background text-foreground flex items-center justify-center overflow-hidden transition-colors duration-300">
      {/* Sailor background effects — warm amber radials */}
      <div className="absolute inset-0 sailor-grid opacity-40" />
      <div className="absolute top-[-30%] left-[-20%] w-[70%] h-[70%] bg-[radial-gradient(ellipse_at_center,rgba(255,184,0,0.06),transparent_60%)] pointer-events-none" />
      <div className="absolute bottom-[-20%] right-[-15%] w-[50%] h-[50%] bg-[radial-gradient(ellipse_at_center,rgba(255,184,0,0.04),transparent_60%)] pointer-events-none" />

      <motion.div
        initial={{ opacity: 0, y: 30 }}
        animate={{ opacity: 1, y: 0 }}
        transition={{ duration: 0.7, ease: [0.16, 1, 0.3, 1] }}
        className="relative z-10 w-full max-w-md px-6"
      >
        <Link href="/auth" className="inline-flex items-center gap-2 text-xs uppercase font-mono tracking-widest text-muted-foreground hover:text-sailor-amber transition-colors mb-8">
          <ArrowLeft size={12} />
          Back to Role Select
        </Link>

        <div className="auth-card-sailor rounded-2xl p-8 md:p-10 relative overflow-hidden">
          {/* Corner notches with amber borders */}
          <div className="absolute top-3 left-3 border-t border-l border-sailor-amber/30 w-5 h-5" />
          <div className="absolute top-3 right-3 border-t border-r border-sailor-amber/30 w-5 h-5" />
          <div className="absolute bottom-3 left-3 border-b border-l border-sailor-amber/30 w-5 h-5" />
          <div className="absolute bottom-3 right-3 border-b border-r border-sailor-amber/30 w-5 h-5" />

          {/* Geometric pattern overlay */}
          <div className="absolute inset-0 opacity-[0.03] pointer-events-none" style={{
            backgroundImage: `repeating-linear-gradient(45deg, transparent, transparent 20px, rgba(255,184,0,0.3) 20px, rgba(255,184,0,0.3) 21px)`,
          }} />

          <div className="relative z-10">
            {/* Header */}
            <div className="flex flex-col items-center gap-3 mb-8">
              <div className="flex items-center gap-2">
                <Anchor size={16} className="text-sailor-amber" />
                <span className="text-[10px] font-mono font-black tracking-[0.3em] uppercase text-sailor-amber">
                  Nestfy Sailor
                </span>
              </div>
              <h1 className="text-xl font-black uppercase tracking-wider text-foreground">
                Merchant Sign In
              </h1>
              <p className="text-[10px] text-muted-foreground font-mono tracking-wider">
                Authenticate with the Nestfy merchant network
              </p>
            </div>

            {error && (
              <motion.div initial={{ opacity: 0, height: 0 }} animate={{ opacity: 1, height: 'auto' }} className="mb-4 p-3 rounded-lg border border-red-500/30 bg-red-500/5 text-red-500 text-xs font-mono">
                {error}
              </motion.div>
            )}

            <form onSubmit={handleSubmit(onSubmit)} className="flex flex-col gap-5">
              <div className="flex flex-col gap-1.5">
                <label className="text-[10px] uppercase tracking-widest text-muted-foreground font-bold font-mono">Business Email</label>
                <input
                  type="email"
                  placeholder="merchant@nestfy.com"
                  {...register('email', { required: 'Email is required', pattern: { value: /^\S+@\S+\.\S+$/, message: 'Invalid email format' } })}
                  className={`w-full bg-secondary/40 border rounded-lg px-4 py-3 text-sm font-mono text-foreground placeholder:text-muted-foreground/50 outline-none transition-all focus:ring-2 focus:ring-sailor-amber/30 ${errors.email ? 'border-red-500' : 'border-border'}`}
                />
                {errors.email && <span className="text-[10px] text-red-500 font-mono">{errors.email.message}</span>}
              </div>

              <div className="flex flex-col gap-1.5">
                <div className="flex justify-between items-center">
                  <label className="text-[10px] uppercase tracking-widest text-muted-foreground font-bold font-mono">Password</label>
                  <Link href="/auth/sailor/forgot-password" className="text-[10px] text-sailor-amber font-mono hover:underline">Forgot password?</Link>
                </div>
                <div className="relative">
                  <input
                    type={showPassword ? 'text' : 'password'}
                    placeholder="••••••••"
                    {...register('password', { required: 'Password is required' })}
                    className={`w-full bg-secondary/40 border rounded-lg px-4 py-3 pr-10 text-sm font-mono text-foreground placeholder:text-muted-foreground/50 outline-none transition-all focus:ring-2 focus:ring-sailor-amber/30 ${errors.password ? 'border-red-500' : 'border-border'}`}
                  />
                  <button type="button" onClick={() => setShowPassword(!showPassword)} className="absolute right-3 top-1/2 -translate-y-1/2 text-muted-foreground hover:text-sailor-amber transition-colors">
                    {showPassword ? <EyeOff size={16} /> : <Eye size={16} />}
                  </button>
                </div>
                {errors.password && <span className="text-[10px] text-red-500 font-mono">{errors.password.message}</span>}
              </div>

              <button
                type="submit"
                disabled={loading}
                className="w-full py-3 rounded-lg text-xs font-black uppercase tracking-widest transition-all duration-300 bg-sailor-amber text-black hover:shadow-[0_0_30px_rgba(255,184,0,0.4)] disabled:opacity-50 disabled:cursor-not-allowed flex items-center justify-center gap-2"
              >
                {loading ? <div className="h-4 w-4 animate-spin rounded-full border-2 border-black border-t-transparent" /> : <><LogIn size={14} /> Access Bridge</>}
              </button>
            </form>

            <div className="flex items-center gap-3 my-6">
              <div className="flex-1 h-px bg-border" />
              <span className="text-[9px] font-mono text-muted-foreground uppercase tracking-widest">or</span>
              <div className="flex-1 h-px bg-border" />
            </div>

            <button onClick={handleGoogleLogin} className="w-full py-3 rounded-lg border border-sailor-border bg-sailor-amber-dim/30 text-foreground text-xs font-bold uppercase tracking-wider hover:bg-sailor-amber-dim/60 transition-all flex items-center justify-center gap-3">
              <svg width="18" height="18" viewBox="0 0 24 24" fill="none">
                <path d="M22.56 12.25c0-.78-.07-1.53-.2-2.25H12v4.26h5.92a5.06 5.06 0 0 1-2.2 3.32v2.77h3.57c2.08-1.92 3.28-4.74 3.28-8.1Z" fill="#4285F4"/>
                <path d="M12 23c2.97 0 5.46-.98 7.28-2.66l-3.57-2.77c-.98.66-2.23 1.06-3.71 1.06-2.86 0-5.29-1.93-6.16-4.53H2.18v2.84C3.99 20.53 7.7 23 12 23Z" fill="#34A853"/>
                <path d="M5.84 14.09c-.22-.66-.35-1.36-.35-2.09s.13-1.43.35-2.09V7.07H2.18A10.96 10.96 0 0 0 1 12c0 1.77.42 3.45 1.18 4.93l3.66-2.84Z" fill="#FBBC05"/>
                <path d="M12 5.38c1.62 0 3.06.56 4.21 1.64l3.15-3.15C17.45 2.09 14.97 1 12 1 7.7 1 3.99 3.47 2.18 7.07l3.66 2.84c.87-2.6 3.3-4.53 6.16-4.53Z" fill="#EA4335"/>
              </svg>
              Sign in with Google
            </button>

            <p className="mt-6 text-center text-xs text-muted-foreground font-mono">
              No merchant account?{' '}
              <Link href="/auth/sailor/register" className="text-sailor-amber hover:underline font-bold">Create your Sailor profile</Link>
            </p>
          </div>
        </div>
      </motion.div>
    </div>
  );
}
