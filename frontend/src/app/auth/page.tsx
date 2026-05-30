"use client";

import React from 'react';
import Link from 'next/link';
import { motion } from 'framer-motion';
import { useTheme } from '@/lib/themeContext';
import { ShoppingBag, Anchor, ArrowRight, Cpu } from 'lucide-react';

/* ══════════════════════════════════════════════
 * Auth Landing — Role Selection
 * Split-screen selector for Client vs Sailor
 * ══════════════════════════════════════════════ */

export default function AuthLandingPage() {
  const { theme } = useTheme();

  return (
    <div className="relative min-h-screen bg-background text-foreground flex flex-col items-center justify-center overflow-hidden transition-colors duration-300">
      {/* Background effects */}
      <div className="absolute inset-0 cyber-grid opacity-50" />
      <div className="absolute top-[-20%] left-[-10%] w-[60%] h-[60%] bg-[radial-gradient(ellipse_at_center,rgba(0,240,255,0.04),transparent_70%)] pointer-events-none" />
      <div className="absolute bottom-[-20%] right-[-10%] w-[60%] h-[60%] bg-[radial-gradient(ellipse_at_center,rgba(255,184,0,0.04),transparent_70%)] pointer-events-none" />

      {/* Logo / Header */}
      <motion.div 
        initial={{ opacity: 0, y: -20 }}
        animate={{ opacity: 1, y: 0 }}
        transition={{ duration: 0.6, ease: [0.16, 1, 0.3, 1] }}
        className="flex flex-col items-center gap-3 mb-12 z-10"
      >
        <div className="flex items-center gap-2">
          <Cpu size={20} className="text-primary" />
          <span className="text-xs font-mono font-black tracking-[0.3em] uppercase text-primary">
            Nestfy
          </span>
        </div>
        <h1 className="text-2xl md:text-3xl font-black uppercase tracking-tight text-foreground text-center">
          Choose Your Interface
        </h1>
        <p className="text-xs text-muted-foreground font-mono tracking-wider max-w-md text-center">
          Select your access profile to sync with the Nestfy network
        </p>
      </motion.div>

      {/* Role Selection Cards */}
      <div className="flex flex-col md:flex-row gap-6 md:gap-8 z-10 px-6 w-full max-w-3xl">

        {/* Client Card */}
        <motion.div
          initial={{ opacity: 0, x: -40 }}
          animate={{ opacity: 1, x: 0 }}
          transition={{ duration: 0.7, delay: 0.15, ease: [0.16, 1, 0.3, 1] }}
          className="flex-1"
        >
          <Link href="/auth/client/login" className="block group">
            <div className="auth-card-client rounded-xl p-8 md:p-10 relative overflow-hidden transition-all duration-300 group-hover:scale-[1.02] neon-glow-hover cursor-pointer">
              {/* Corner notch */}
              <div className="absolute top-3 left-3 border-t border-l border-primary/30 w-5 h-5" />
              <div className="absolute bottom-3 right-3 border-b border-r border-primary/30 w-5 h-5" />
              
              {/* Background pattern */}
              <div className="absolute inset-0 cyber-grid-dense opacity-20 pointer-events-none" />
              
              <div className="relative z-10 flex flex-col items-center text-center gap-5">
                <div className="w-16 h-16 rounded-full border-2 border-primary/30 flex items-center justify-center bg-primary/5 group-hover:bg-primary/10 transition-colors">
                  <ShoppingBag size={28} className="text-primary" />
                </div>
                
                <div>
                  <h2 className="text-lg font-black uppercase tracking-wider text-foreground mb-1">
                    I&apos;m a Client
                  </h2>
                  <p className="text-xs text-muted-foreground font-mono leading-relaxed">
                    Browse, purchase, and manage your smart home devices
                  </p>
                </div>

                <div className="flex items-center gap-2 text-primary text-xs font-mono font-bold uppercase tracking-widest group-hover:gap-3 transition-all">
                  <span>Access Terminal</span>
                  <ArrowRight size={14} className="group-hover:translate-x-1 transition-transform" />
                </div>
              </div>
            </div>
          </Link>
        </motion.div>

        {/* Divider */}
        <div className="hidden md:flex items-center">
          <div className="w-px h-32 bg-border" />
        </div>
        <div className="flex md:hidden items-center justify-center">
          <div className="h-px w-24 bg-border" />
          <span className="px-3 text-[9px] font-mono text-muted-foreground uppercase tracking-widest">or</span>
          <div className="h-px w-24 bg-border" />
        </div>

        {/* Sailor Card */}
        <motion.div
          initial={{ opacity: 0, x: 40 }}
          animate={{ opacity: 1, x: 0 }}
          transition={{ duration: 0.7, delay: 0.3, ease: [0.16, 1, 0.3, 1] }}
          className="flex-1"
        >
          <Link href="/auth/sailor/login" className="block group">
            <div className="auth-card-sailor rounded-xl p-8 md:p-10 relative overflow-hidden transition-all duration-300 group-hover:scale-[1.02] sailor-glow-hover cursor-pointer">
              {/* Corner notch */}
              <div className="absolute top-3 left-3 border-t border-l border-sailor-amber/30 w-5 h-5" />
              <div className="absolute bottom-3 right-3 border-b border-r border-sailor-amber/30 w-5 h-5" />
              
              {/* Background pattern */}
              <div className="absolute inset-0 sailor-grid opacity-20 pointer-events-none" />

              <div className="relative z-10 flex flex-col items-center text-center gap-5">
                <div className="w-16 h-16 rounded-full border-2 border-sailor-amber/30 flex items-center justify-center bg-sailor-amber-dim group-hover:bg-sailor-amber/15 transition-colors">
                  <Anchor size={28} className="text-sailor-amber" />
                </div>
                
                <div>
                  <h2 className="text-lg font-black uppercase tracking-wider text-foreground mb-1">
                    I&apos;m a Sailor
                  </h2>
                  <p className="text-xs text-muted-foreground font-mono leading-relaxed">
                    Sell, manage inventory, and grow your tech business
                  </p>
                </div>

                <div className="flex items-center gap-2 text-sailor-amber text-xs font-mono font-bold uppercase tracking-widest group-hover:gap-3 transition-all">
                  <span>Access Terminal</span>
                  <ArrowRight size={14} className="group-hover:translate-x-1 transition-transform" />
                </div>
              </div>
            </div>
          </Link>
        </motion.div>

      </div>

      {/* Footer */}
      <motion.p
        initial={{ opacity: 0 }}
        animate={{ opacity: 1 }}
        transition={{ delay: 0.8 }}
        className="mt-12 text-[10px] text-muted-foreground font-mono tracking-wider z-10"
      >
        © 2026 Nestfy Tech Home. role_auth_gateway_v2.
      </motion.p>
    </div>
  );
}
