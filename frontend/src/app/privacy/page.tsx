"use client";

import React from 'react';
import { Header } from '@/components/web/Header';
import { GlassCard } from '@/components/ui/GlassCard';
import { ArrowLeft, Lock, Terminal } from 'lucide-react';
import Link from 'next/link';

export default function PrivacyPage() {
  return (
    <div className="relative min-h-screen bg-background text-foreground transition-colors duration-300 overflow-hidden cyber-grid">
      <div className="absolute top-[-20%] left-[-10%] w-[50%] h-[50%] bg-[radial-gradient(ellipse_at_center,rgba(0,240,255,0.05),transparent_70%)] pointer-events-none" />
      <div className="absolute inset-0 scanline-effect opacity-[0.01] pointer-events-none" />

      <Header onToggleCart={() => {}} />

      <main className="mx-auto max-w-3xl px-6 py-16 relative z-10">
        
        {/* Back Link */}
        <Link href="/" className="inline-flex items-center gap-2 text-xs uppercase font-mono tracking-widest text-zinc-500 hover:text-neon-blue transition-colors mb-8">
          <ArrowLeft size={12} />
          Back to Core
        </Link>

        {/* Title */}
        <div className="flex flex-col gap-4 mb-12 text-center md:text-left">
          <span className="text-[10px] tracking-widest text-neon-blue uppercase border border-neon-blue/20 bg-neon-blue/5 px-2.5 py-0.5 rounded font-black w-fit self-center md:self-start">
            SYS_SECURITY_BLOCK
          </span>
          <h1 className="text-3xl md:text-4xl font-black uppercase tracking-tight">
            Privacy <span className="text-transparent bg-clip-text bg-gradient-to-r from-white via-neon-blue to-white neon-text-glow">Policy</span>
          </h1>
          <p className="text-sm text-zinc-400 font-light leading-relaxed max-w-xl">
            System encryption indexes and localized data protection principles.
          </p>
        </div>

        {/* Policy Content */}
        <div className="flex flex-col gap-6 text-xs text-zinc-400 leading-relaxed font-light">
          
          <GlassCard animate={false} className="border border-zinc-900 bg-zinc-950/20">
            <div className="flex items-center gap-2 mb-3">
              <Lock size={16} className="text-neon-blue" />
              <h3 className="text-sm font-bold uppercase tracking-wider text-white font-mono">1. Localized Isolation</h3>
            </div>
            <p>
              Unlike conventional IoT platforms, Nestfy does not transmit your private smart home activity logs to centralized third-party servers. All voice processing files, smart camera schedules, and access logs reside strictly inside the physical storage device located in your residence.
            </p>
          </GlassCard>

          <GlassCard animate={false} className="border border-zinc-900 bg-zinc-950/20">
            <div className="flex items-center gap-2 mb-3">
              <Terminal size={16} className="text-neon-blue" />
              <h3 className="text-sm font-bold uppercase tracking-wider text-white font-mono">2. Biometric Datasets</h3>
            </div>
            <p>
              Perimeter security locks such as the LockGate Pro employ hardware-level cryptographic key matching to verify fingerprint and facial depth matrices. These math signatures are stored in hardware enclave chips and are inaccessible to outside networks or cloud requests.
            </p>
          </GlassCard>

          <GlassCard animate={false} className="border border-zinc-900 bg-zinc-950/20">
            <div className="flex items-center gap-2 mb-3">
              <Lock size={16} className="text-neon-blue" />
              <h3 className="text-sm font-bold uppercase tracking-wider text-white font-mono">3. Storefront Telemetry</h3>
            </div>
            <p>
              When you browse our storefront dashboard, anonymized metadata logs are collected locally on your browser. This includes items clicked and preferences selected, storing them within your browser's LocalStorage to maintain your cart and session layout values.
            </p>
          </GlassCard>
          
          <GlassCard animate={false} className="border border-zinc-900 bg-zinc-950/20">
            <div className="flex items-center gap-2 mb-3">
              <Terminal size={16} className="text-neon-blue" />
              <h3 className="text-sm font-bold uppercase tracking-wider text-white font-mono">4. Encryption Protocols</h3>
            </div>
            <p>
              All interactions between your mobile client app and your Dome Hub mesh system utilize end-to-end WireGuard tunnel encryption. Unauthorized external access is locked by default.
            </p>
          </GlassCard>

        </div>

      </main>

      {/* Footer */}
      <footer className="border-t border-zinc-950 py-8 text-center text-[10px] tracking-widest text-zinc-700 uppercase font-mono mt-16">
        NESTFY SYSTEMS © 2026. PRIVACY_ENVELOPE_SECURE.
      </footer>
    </div>
  );
}
