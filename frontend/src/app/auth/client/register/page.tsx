"use client";

import React, { useState } from 'react';
import Link from 'next/link';
import { motion, AnimatePresence } from 'framer-motion';
import { useTheme } from '@/lib/themeContext';
import { useAppDispatch, useAppSelector } from '@/lib/store/hooks';
import { loginSuccess, setLoading, setError } from '@/lib/store/authSlice';
import { authService } from '@/lib/services/authService';
import { useForm } from 'react-hook-form';
import { Cpu, Eye, EyeOff, ArrowLeft, ArrowRight, UserPlus, Check } from 'lucide-react';

interface RegisterFormValues {
  name: string;
  email: string;
  cpf: string;
  phone: string;
  password: string;
  confirmPassword: string;
}

const STEPS = ['Identity', 'Contact', 'Security'];

export default function ClientRegisterPage() {
  const { theme } = useTheme();
  const dispatch = useAppDispatch();
  const { loading, error } = useAppSelector((s) => s.auth);
  const [step, setStep] = useState(0);
  const [showPassword, setShowPassword] = useState(false);
  const [showConfirm, setShowConfirm] = useState(false);

  const { register, handleSubmit, formState: { errors }, watch, trigger } = useForm<RegisterFormValues>();
  const isDark = theme === 'dark';

  const nextStep = async () => {
    let fieldsToValidate: (keyof RegisterFormValues)[] = [];
    if (step === 0) fieldsToValidate = ['name', 'email'];
    if (step === 1) fieldsToValidate = ['cpf', 'phone'];
    const isValid = await trigger(fieldsToValidate);
    if (isValid) setStep((s) => Math.min(s + 1, STEPS.length - 1));
  };

  const prevStep = () => setStep((s) => Math.max(s - 1, 0));

  const onSubmit = async (data: RegisterFormValues) => {
    if (data.password !== data.confirmPassword) {
      dispatch(setError('Passwords do not match'));
      return;
    }
    dispatch(setLoading(true));
    try {
      const res = await authService.registerClient({
        name: data.name,
        email: data.email,
        cpf: data.cpf,
        phone: data.phone,
        password: data.password,
      });
      dispatch(loginSuccess({ user: { ...res.user, role: 'CLIENT' }, token: res.token }));
      window.location.href = '/';
    } catch {
      dispatch(setError('Registration failed. Email may already be in use.'));
    }
  };

  const handleGoogleLogin = () => {
    authService.googleOAuthRedirect();
  };

  return (
    <div className="relative min-h-screen bg-background text-foreground flex items-center justify-center overflow-hidden transition-colors duration-300">
      <div className="absolute inset-0 cyber-grid opacity-40" />
      <div className="absolute top-[-30%] left-[-20%] w-[70%] h-[70%] bg-[radial-gradient(ellipse_at_center,rgba(0,240,255,0.05),transparent_60%)] pointer-events-none" />

      <motion.div
        initial={{ opacity: 0, y: 30 }}
        animate={{ opacity: 1, y: 0 }}
        transition={{ duration: 0.7, ease: [0.16, 1, 0.3, 1] }}
        className="relative z-10 w-full max-w-md px-6"
      >
        <Link href="/auth/client/login" className="inline-flex items-center gap-2 text-xs uppercase font-mono tracking-widest text-muted-foreground hover:text-primary transition-colors mb-8">
          <ArrowLeft size={12} />
          Back to Login
        </Link>

        <div className="auth-card-client rounded-2xl p-8 md:p-10 relative overflow-hidden">
          <div className="absolute top-3 left-3 border-t border-l border-primary/30 w-5 h-5" />
          <div className="absolute top-3 right-3 border-t border-r border-primary/30 w-5 h-5" />
          <div className="absolute bottom-3 left-3 border-b border-l border-primary/30 w-5 h-5" />
          <div className="absolute bottom-3 right-3 border-b border-r border-primary/30 w-5 h-5" />
          <div className="absolute inset-0 cyber-grid-dense opacity-10 pointer-events-none" />

          <div className="relative z-10">
            {/* Header */}
            <div className="flex flex-col items-center gap-3 mb-6">
              <div className="flex items-center gap-2">
                <Cpu size={16} className="text-primary" />
                <span className="text-[10px] font-mono font-black tracking-[0.3em] uppercase text-primary">Nestfy Client</span>
              </div>
              <h1 className="text-xl font-black uppercase tracking-wider text-foreground">Create Account</h1>
            </div>

            {/* Step Indicator */}
            <div className="step-indicator mb-8 px-4">
              {STEPS.map((label, idx) => (
                <React.Fragment key={label}>
                  <div className={`step-dot ${idx === step ? 'active' : idx < step ? 'completed' : ''}`}>
                    {idx < step ? <Check size={12} /> : idx + 1}
                  </div>
                  {idx < STEPS.length - 1 && (
                    <div className={`step-line ${idx < step ? 'completed' : ''}`} />
                  )}
                </React.Fragment>
              ))}
            </div>

            {/* Step Labels */}
            <div className="flex justify-between px-2 mb-6">
              {STEPS.map((label, idx) => (
                <span key={label} className={`text-[9px] font-mono uppercase tracking-wider ${idx === step ? 'text-primary font-bold' : 'text-muted-foreground'}`}>
                  {label}
                </span>
              ))}
            </div>

            {error && (
              <motion.div initial={{ opacity: 0 }} animate={{ opacity: 1 }} className="mb-4 p-3 rounded-lg border border-red-500/30 bg-red-500/5 text-red-500 text-xs font-mono">
                {error}
              </motion.div>
            )}

            <form onSubmit={handleSubmit(onSubmit)} className="flex flex-col gap-5">
              <AnimatePresence mode="wait">
                {/* Step 0: Identity */}
                {step === 0 && (
                  <motion.div key="step-0" initial={{ opacity: 0, x: 20 }} animate={{ opacity: 1, x: 0 }} exit={{ opacity: 0, x: -20 }} className="flex flex-col gap-4">
                    <div className="flex flex-col gap-1.5">
                      <label className="text-[10px] uppercase tracking-widest text-muted-foreground font-bold font-mono">Full Name</label>
                      <input
                        type="text"
                        placeholder="John Connor"
                        {...register('name', { required: 'Name is required' })}
                        className={`w-full bg-secondary/40 border rounded-lg px-4 py-3 text-sm font-mono text-foreground placeholder:text-muted-foreground/50 outline-none focus:ring-2 focus:ring-primary/30 ${errors.name ? 'border-red-500' : 'border-border'}`}
                      />
                      {errors.name && <span className="text-[10px] text-red-500 font-mono">{errors.name.message}</span>}
                    </div>
                    <div className="flex flex-col gap-1.5">
                      <label className="text-[10px] uppercase tracking-widest text-muted-foreground font-bold font-mono">Email Address</label>
                      <input
                        type="email"
                        placeholder="operator@nestfy.com"
                        {...register('email', { required: 'Email is required', pattern: { value: /^\S+@\S+\.\S+$/, message: 'Invalid email' } })}
                        className={`w-full bg-secondary/40 border rounded-lg px-4 py-3 text-sm font-mono text-foreground placeholder:text-muted-foreground/50 outline-none focus:ring-2 focus:ring-primary/30 ${errors.email ? 'border-red-500' : 'border-border'}`}
                      />
                      {errors.email && <span className="text-[10px] text-red-500 font-mono">{errors.email.message}</span>}
                    </div>
                  </motion.div>
                )}

                {/* Step 1: Contact */}
                {step === 1 && (
                  <motion.div key="step-1" initial={{ opacity: 0, x: 20 }} animate={{ opacity: 1, x: 0 }} exit={{ opacity: 0, x: -20 }} className="flex flex-col gap-4">
                    <div className="flex flex-col gap-1.5">
                      <label className="text-[10px] uppercase tracking-widest text-muted-foreground font-bold font-mono">CPF</label>
                      <input
                        type="text"
                        placeholder="000.000.000-00"
                        {...register('cpf', { required: 'CPF is required' })}
                        className={`w-full bg-secondary/40 border rounded-lg px-4 py-3 text-sm font-mono text-foreground placeholder:text-muted-foreground/50 outline-none focus:ring-2 focus:ring-primary/30 ${errors.cpf ? 'border-red-500' : 'border-border'}`}
                      />
                      {errors.cpf && <span className="text-[10px] text-red-500 font-mono">{errors.cpf.message}</span>}
                    </div>
                    <div className="flex flex-col gap-1.5">
                      <label className="text-[10px] uppercase tracking-widest text-muted-foreground font-bold font-mono">Phone</label>
                      <input
                        type="tel"
                        placeholder="+55 (00) 00000-0000"
                        {...register('phone', { required: 'Phone is required' })}
                        className={`w-full bg-secondary/40 border rounded-lg px-4 py-3 text-sm font-mono text-foreground placeholder:text-muted-foreground/50 outline-none focus:ring-2 focus:ring-primary/30 ${errors.phone ? 'border-red-500' : 'border-border'}`}
                      />
                      {errors.phone && <span className="text-[10px] text-red-500 font-mono">{errors.phone.message}</span>}
                    </div>
                  </motion.div>
                )}

                {/* Step 2: Security */}
                {step === 2 && (
                  <motion.div key="step-2" initial={{ opacity: 0, x: 20 }} animate={{ opacity: 1, x: 0 }} exit={{ opacity: 0, x: -20 }} className="flex flex-col gap-4">
                    <div className="flex flex-col gap-1.5">
                      <label className="text-[10px] uppercase tracking-widest text-muted-foreground font-bold font-mono">Password</label>
                      <div className="relative">
                        <input
                          type={showPassword ? 'text' : 'password'}
                          placeholder="Min 8 chars, 1 uppercase, 1 number"
                          {...register('password', {
                            required: 'Password is required',
                            minLength: { value: 8, message: 'Min 8 characters' },
                            pattern: { value: /^(?=.*[A-Z])(?=.*\d)/, message: '1 uppercase + 1 number required' }
                          })}
                          className={`w-full bg-secondary/40 border rounded-lg px-4 py-3 pr-10 text-sm font-mono text-foreground placeholder:text-muted-foreground/50 outline-none focus:ring-2 focus:ring-primary/30 ${errors.password ? 'border-red-500' : 'border-border'}`}
                        />
                        <button type="button" onClick={() => setShowPassword(!showPassword)} className="absolute right-3 top-1/2 -translate-y-1/2 text-muted-foreground hover:text-primary transition-colors">
                          {showPassword ? <EyeOff size={16} /> : <Eye size={16} />}
                        </button>
                      </div>
                      {errors.password && <span className="text-[10px] text-red-500 font-mono">{errors.password.message}</span>}
                    </div>
                    <div className="flex flex-col gap-1.5">
                      <label className="text-[10px] uppercase tracking-widest text-muted-foreground font-bold font-mono">Confirm Password</label>
                      <div className="relative">
                        <input
                          type={showConfirm ? 'text' : 'password'}
                          placeholder="Re-enter password"
                          {...register('confirmPassword', {
                            required: 'Please confirm your password',
                            validate: (val) => val === watch('password') || 'Passwords do not match'
                          })}
                          className={`w-full bg-secondary/40 border rounded-lg px-4 py-3 pr-10 text-sm font-mono text-foreground placeholder:text-muted-foreground/50 outline-none focus:ring-2 focus:ring-primary/30 ${errors.confirmPassword ? 'border-red-500' : 'border-border'}`}
                        />
                        <button type="button" onClick={() => setShowConfirm(!showConfirm)} className="absolute right-3 top-1/2 -translate-y-1/2 text-muted-foreground hover:text-primary transition-colors">
                          {showConfirm ? <EyeOff size={16} /> : <Eye size={16} />}
                        </button>
                      </div>
                      {errors.confirmPassword && <span className="text-[10px] text-red-500 font-mono">{errors.confirmPassword.message}</span>}
                    </div>
                  </motion.div>
                )}
              </AnimatePresence>

              {/* Navigation buttons */}
              <div className="flex gap-3 mt-2">
                {step > 0 && (
                  <button type="button" onClick={prevStep} className="flex-1 py-3 rounded-lg border border-border text-xs font-bold uppercase tracking-wider text-muted-foreground hover:text-foreground transition-all flex items-center justify-center gap-2">
                    <ArrowLeft size={12} /> Back
                  </button>
                )}
                {step < STEPS.length - 1 ? (
                  <button type="button" onClick={nextStep} className={`flex-1 py-3 rounded-lg text-xs font-black uppercase tracking-widest transition-all flex items-center justify-center gap-2 ${
                    isDark ? 'bg-neon-blue text-black hover:shadow-[0_0_30px_rgba(0,240,255,0.4)]' : 'bg-primary text-white hover:bg-primary/90'
                  }`}>
                    Next <ArrowRight size={12} />
                  </button>
                ) : (
                  <button type="submit" disabled={loading} className={`flex-1 py-3 rounded-lg text-xs font-black uppercase tracking-widest transition-all flex items-center justify-center gap-2 disabled:opacity-50 ${
                    isDark ? 'bg-neon-blue text-black hover:shadow-[0_0_30px_rgba(0,240,255,0.4)]' : 'bg-primary text-white hover:bg-primary/90'
                  }`}>
                    {loading ? <div className="h-4 w-4 animate-spin rounded-full border-2 border-black border-t-transparent" /> : <><UserPlus size={14} /> Create Account</>}
                  </button>
                )}
              </div>
            </form>

            {/* Divider */}
            <div className="flex items-center gap-3 my-6">
              <div className="flex-1 h-px bg-border" />
              <span className="text-[9px] font-mono text-muted-foreground uppercase tracking-widest">or</span>
              <div className="flex-1 h-px bg-border" />
            </div>

            {/* Google OAuth */}
            <button onClick={handleGoogleLogin} className="w-full py-3 rounded-lg border border-border bg-secondary/20 text-foreground text-xs font-bold uppercase tracking-wider hover:bg-secondary/40 transition-all flex items-center justify-center gap-3">
              <svg width="18" height="18" viewBox="0 0 24 24" fill="none">
                <path d="M22.56 12.25c0-.78-.07-1.53-.2-2.25H12v4.26h5.92a5.06 5.06 0 0 1-2.2 3.32v2.77h3.57c2.08-1.92 3.28-4.74 3.28-8.1Z" fill="#4285F4"/>
                <path d="M12 23c2.97 0 5.46-.98 7.28-2.66l-3.57-2.77c-.98.66-2.23 1.06-3.71 1.06-2.86 0-5.29-1.93-6.16-4.53H2.18v2.84C3.99 20.53 7.7 23 12 23Z" fill="#34A853"/>
                <path d="M5.84 14.09c-.22-.66-.35-1.36-.35-2.09s.13-1.43.35-2.09V7.07H2.18A10.96 10.96 0 0 0 1 12c0 1.77.42 3.45 1.18 4.93l3.66-2.84Z" fill="#FBBC05"/>
                <path d="M12 5.38c1.62 0 3.06.56 4.21 1.64l3.15-3.15C17.45 2.09 14.97 1 12 1 7.7 1 3.99 3.47 2.18 7.07l3.66 2.84c.87-2.6 3.3-4.53 6.16-4.53Z" fill="#EA4335"/>
              </svg>
              Sign up with Google
            </button>

            <p className="mt-6 text-center text-xs text-muted-foreground font-mono">
              Already have an account?{' '}
              <Link href="/auth/client/login" className="text-primary hover:underline font-bold">Sign in</Link>
            </p>
          </div>
        </div>
      </motion.div>
    </div>
  );
}
