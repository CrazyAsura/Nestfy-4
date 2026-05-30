"use client";

import React from 'react';
import { Header } from '@/components/web/Header';
import { GlassCard } from '@/components/ui/GlassCard';
import { ArrowLeft, Terminal, Cpu } from 'lucide-react';
import Link from 'next/link';

export default function TermsPage() {
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
            SYS_LICENSE_TERMS
          </span>
          <h1 className="text-3xl md:text-4xl font-black uppercase tracking-tight">
            Terms of <span className="text-transparent bg-clip-text bg-gradient-to-r from-white via-neon-blue to-white neon-text-glow">Use</span>
          </h1>
          <p className="text-sm text-zinc-400 font-light leading-relaxed max-w-xl">
            System terms, license boundaries, and local network agreements.
          </p>
        </div>

        {/* Content terms */}
        <div className="flex flex-col gap-6 text-xs text-zinc-400 leading-relaxed font-light">
          
          <GlassCard animate={false} className="border border-zinc-900 bg-zinc-950/20">
            <div className="flex items-center gap-2 mb-3">
              <Cpu size={16} className="text-neon-blue" />
              <h3 className="text-sm font-bold uppercase tracking-wider text-white font-mono">1. Smart Hub Licenses</h3>
            </div>
            <p>
              Nestfy grants you a personal, non-transferable firmware license to operate the Dome Hub command code in your home. Any reverse engineering of the local mesh encryption blocks or dry voice translation engines is prohibited under license terms.
            </p>
          </GlassCard>

          <GlassCard animate={false} className="border border-zinc-900 bg-zinc-950/20">
            <div className="flex items-center gap-2 mb-3">
              <Terminal size={16} className="text-neon-blue" />
              <h3 className="text-sm font-bold uppercase tracking-wider text-white font-mono">2. Local Perimeter Responsibility</h3>
            </div>
            <p>
              The operation of local biometric systems, including the LockGate Pro face scanner, is entirely under your supervision. Nestfy holds no access keys, backups, or overrides to your local enclaves. If physical keys and backup USB-C passwords are lost, physical intervention is required.
            </p>
          </GlassCard>

          <GlassCard animate={false} className="border border-zinc-900 bg-zinc-950/20">
            <div className="flex items-center gap-2 mb-3">
              <Cpu size={16} className="text-neon-blue" />
              <h3 className="text-sm font-bold uppercase tracking-wider text-white font-mono">3. Matter Protocol Integrations</h3>
            </div>
            <p>
              Users are responsible for ensuring that third-party smart bulbs, cameras, and switches added to the Nestfy network comply with official Matter security profiles. Nestfy is not liable for data leaks originating from uncertified IoT devices.
            </p>
          </GlassCard>

        </div>

      </main>

      {/* Footer */}
      <footer className="border-t border-zinc-950 py-8 text-center text-[10px] tracking-widest text-zinc-700 uppercase font-mono mt-16">
        NESTFY SYSTEMS © 2026. UPLINK_TERMS_CONFIRMED.
      </footer>
    </div>
  );
}
