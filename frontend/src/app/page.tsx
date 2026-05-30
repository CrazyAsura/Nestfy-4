"use client";

import React, { useState, useEffect } from 'react';
import { Header } from '@/components/web/Header';
import { ProductGrid } from '@/components/web/ProductGrid';
import { CartDrawer } from '@/components/web/CartDrawer';
import { MobileApp } from '@/components/mobile/MobileApp';
import { SmartHubPromotions } from '@/components/web/SmartHubPromotions';
import { useLanguage } from '@/lib/languageContext';
import { motion } from 'framer-motion';
import { Terminal, Cpu, Shield, HelpCircle } from 'lucide-react';
import Link from 'next/link';

export default function Home() {
  const [isMounted, setIsMounted] = useState(false);
  const [isCartOpen, setIsCartOpen] = useState(false);
  const [isMobileViewport, setIsMobileViewport] = useState(false);
  const { t } = useLanguage();
  
  // Handle hydration check & responsive viewport detection
  useEffect(() => {
    setIsMounted(true);
    
    const checkViewport = () => {
      setIsMobileViewport(window.innerWidth <= 768);
    };

    checkViewport();
    window.addEventListener('resize', checkViewport);
    return () => window.removeEventListener('resize', checkViewport);
  }, []);

  if (!isMounted) {
    return (
      <div className="flex h-screen w-screen items-center justify-center bg-black text-neon-blue font-mono text-xs tracking-widest uppercase">
        <div className="flex flex-col items-center gap-3">
          <div className="h-6 w-6 animate-spin rounded-full border-2 border-neon-blue border-t-transparent" />
          <span>Booting Nestfy Tech Home...</span>
        </div>
      </div>
    );
  }

  // Render pure Mobile MUI PWA layout if user is on a mobile viewport size
  if (isMobileViewport) {
    return <MobileApp />;
  }

  return (
    <div className="relative min-h-screen bg-background text-foreground transition-colors duration-300 overflow-hidden cyber-grid">
      
      {/* Top ambient glowing gradients */}
      <div className="absolute top-[-20%] left-[-10%] w-[50%] h-[50%] rounded-full bg-[radial-gradient(ellipse_at_center,rgba(0,240,255,0.06),transparent_70%)] pointer-events-none" />
      <div className="absolute top-[-10%] right-[-10%] w-[50%] h-[50%] rounded-full bg-[radial-gradient(ellipse_at_center,rgba(255,255,255,0.02),transparent_70%)] pointer-events-none" />
      
      {/* Scanline overlay */}
      <div className="absolute inset-0 scanline-effect opacity-[0.02] pointer-events-none" />

      {/* Navigation Header */}
      <Header onToggleCart={() => setIsCartOpen(!isCartOpen)} />

      {/* Main Core Layout */}
      <main className="mx-auto max-w-7xl px-6 py-12 md:px-8 relative z-10">
        
        {/* Store Catalog & Info */}
        <div className="flex flex-col gap-12 w-full">
          
          {/* Smart Hub Promotions Campaign Carousel */}
          <SmartHubPromotions />

          {/* Product grid Catalog */}
          <ProductGrid />
          
          {/* Tech specs footer banner */}
          <div className="grid grid-cols-1 sm:grid-cols-3 gap-6 pt-6 border-t border-zinc-900">
            <div className="flex items-center gap-3.5 p-4 rounded border border-zinc-950 bg-zinc-950/20">
              <Cpu size={24} className="text-neon-blue" />
              <div>
                <h4 className="text-xs font-bold uppercase tracking-wider text-white">{t('footer.matterTitle')}</h4>
                <p className="text-[10px] text-zinc-500 mt-0.5">{t('footer.matterDesc')}</p>
              </div>
            </div>
            <div className="flex items-center gap-3.5 p-4 rounded border border-zinc-950 bg-zinc-950/20">
              <Shield size={24} className="text-neon-blue" />
              <div>
                <h4 className="text-xs font-bold uppercase tracking-wider text-white">{t('footer.offlineTitle')}</h4>
                <p className="text-[10px] text-zinc-500 mt-0.5">{t('footer.offlineDesc')}</p>
              </div>
            </div>
            <div className="flex items-center gap-3.5 p-4 rounded border border-zinc-950 bg-zinc-950/20">
              <HelpCircle size={24} className="text-neon-blue" />
              <div>
                <h4 className="text-xs font-bold uppercase tracking-wider text-white">{t('footer.developerTitle')}</h4>
                <p className="text-[10px] text-zinc-500 mt-0.5">{t('footer.developerDesc')}</p>
              </div>
            </div>
          </div>
        </div>
      </main>

      {/* Slide-out Sidebar Cart & Checkout */}
      <CartDrawer
        isOpen={isCartOpen}
        onClose={() => setIsCartOpen(false)}
      />

      {/* Desktop Footer */}
      <footer className="w-full border-t border-zinc-900 bg-black/40 py-12 relative z-10 text-center text-xs tracking-wider text-zinc-500 font-mono uppercase flex flex-col gap-4">
        <div className="flex justify-center gap-6 flex-wrap text-[10px]">
          <Link href="/about" className="hover:text-neon-blue transition-colors">{t('footer.aboutUs')}</Link>
          <Link href="/faq" className="hover:text-neon-blue transition-colors">{t('nav.faq')}</Link>
          <Link href="/privacy" className="hover:text-neon-blue transition-colors">{t('footer.privacyPolicy')}</Link>
          <Link href="/cookies" className="hover:text-neon-blue transition-colors">{t('footer.cookiesPolicy')}</Link>
          <Link href="/terms" className="hover:text-neon-blue transition-colors">{t('footer.termsOfUse')}</Link>
        </div>
        <p className="text-[10px] text-zinc-700">{t('footer.copyright')}</p>
      </footer>
    </div>
  );
}
