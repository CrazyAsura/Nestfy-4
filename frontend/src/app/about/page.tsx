"use client";

import React from 'react';
import { Header } from '@/components/web/Header';
import { GlassCard } from '@/components/ui/GlassCard';
import { CyberButton } from '@/components/ui/CyberButton';
import { Cpu, ShieldCheck, Zap, ArrowLeft } from 'lucide-react';
import Link from 'next/link';
import { useLanguage } from '@/lib/languageContext';

export default function AboutPage() {
  const { t } = useLanguage();

  return (
    <div className="relative min-h-screen bg-background text-foreground transition-colors duration-300 overflow-hidden cyber-grid">
      <div className="absolute top-[-20%] left-[-10%] w-[50%] h-[50%] bg-[radial-gradient(ellipse_at_center,rgba(0,240,255,0.05),transparent_70%)] pointer-events-none" />
      <div className="absolute inset-0 scanline-effect opacity-[0.01] pointer-events-none" />

      <Header onToggleCart={() => {}} />

      <main className="mx-auto max-w-4xl px-6 py-16 relative z-10">
        
        {/* Back Link */}
        <Link href="/" className="inline-flex items-center gap-2 text-xs uppercase font-mono tracking-widest text-zinc-500 hover:text-neon-blue transition-colors mb-8">
          <ArrowLeft size={12} />
          {t('nav.backToCore')}
        </Link>

        {/* Hero Section */}
        <div className="flex flex-col gap-4 mb-12 text-center md:text-left">
          <span className="text-[10px] tracking-widest text-neon-blue uppercase border border-neon-blue/20 bg-neon-blue/5 px-2.5 py-0.5 rounded font-black w-fit self-center md:self-start">
            {t('about.profileData')}
          </span>
          <h1 className="text-3xl md:text-4xl font-black uppercase tracking-tight">
            {t('nav.about')} <span className="text-transparent bg-clip-text bg-linear-to-r from-white via-neon-blue to-white neon-text-glow">Nestfy</span>
          </h1>
          <p className="text-sm text-zinc-400 font-light leading-relaxed max-w-2xl">
            {t('about.desc')}
          </p>
        </div>

        {/* Three Pillar Cards */}
        <div className="grid grid-cols-1 md:grid-cols-3 gap-6 mb-12">
          <GlassCard animate={false} className="flex flex-col gap-4 border border-zinc-900 bg-zinc-950/20">
            <Cpu size={24} className="text-neon-blue" />
            <h3 className="text-sm font-bold uppercase tracking-wider text-white">{t('about.pillar1Title')}</h3>
            <p className="text-xs text-zinc-500 leading-relaxed">
              {t('about.pillar1Desc')}
            </p>
          </GlassCard>

          <GlassCard animate={false} className="flex flex-col gap-4 border border-zinc-900 bg-zinc-950/20">
            <ShieldCheck size={24} className="text-neon-blue" />
            <h3 className="text-sm font-bold uppercase tracking-wider text-white">{t('about.pillar2Title')}</h3>
            <p className="text-xs text-zinc-500 leading-relaxed">
              {t('about.pillar2Desc')}
            </p>
          </GlassCard>

          <GlassCard animate={false} className="flex flex-col gap-4 border border-zinc-900 bg-zinc-950/20">
            <Zap size={24} className="text-neon-blue" />
            <h3 className="text-sm font-bold uppercase tracking-wider text-white">{t('about.pillar3Title')}</h3>
            <p className="text-xs text-zinc-500 leading-relaxed">
              {t('about.pillar3Desc')}
            </p>
          </GlassCard>
        </div>

        {/* Narrative Panel */}
        <GlassCard animate={false} className="border border-zinc-900 mb-12">
          <h2 className="text-lg font-bold font-mono uppercase tracking-widest text-white mb-4">{t('about.manifestTitle')}</h2>
          <div className="flex flex-col gap-4 text-xs text-zinc-400 leading-relaxed font-light font-mono">
            <p>
              {t('about.manifestP1')}
            </p>
            <p>
              {t('about.manifestP2')}
            </p>
          </div>
        </GlassCard>

        {/* Action Link */}
        <div className="text-center">
          <Link href="/">
            <CyberButton variant="primary">{t('about.accessCatalog')}</CyberButton>
          </Link>
        </div>

      </main>

      {/* Footer */}
      <footer className="border-t border-zinc-950 py-8 text-center text-[10px] tracking-widest text-zinc-700 uppercase font-mono mt-12">
        {t('about.uplinkOk')}
      </footer>
    </div>
  );
}
