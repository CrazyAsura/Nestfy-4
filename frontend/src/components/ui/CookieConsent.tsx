"use client";

import React, { useState, useEffect } from 'react';
import { motion, AnimatePresence } from 'framer-motion';
import { Cookie, X, Shield, Settings, Info } from 'lucide-react';
import { CyberButton } from './CyberButton';

export const CookieConsent: React.FC = () => {
  const [showBanner, setShowBanner] = useState(false);
  const [showModal, setShowModal] = useState(false);
  
  // Consent states
  const [consent, setConsent] = useState({
    required: true,
    performance: true,
    analytics: true
  });

  useEffect(() => {
    const savedConsent = localStorage.getItem('nestfy-cookie-consent');
    if (!savedConsent) {
      setShowBanner(true);
    } else {
      try {
        setConsent(JSON.parse(savedConsent));
      } catch (e) {
        // Fallback if malformed
      }
    }
  }, []);

  const handleSave = (customConsent = consent) => {
    localStorage.setItem('nestfy-cookie-consent', JSON.stringify(customConsent));
    setConsent(customConsent);
    setShowBanner(false);
    setShowModal(false);
  };

  const handleAcceptAll = () => {
    const allAccepted = { required: true, performance: true, analytics: true };
    handleSave(allAccepted);
  };

  return (
    <>
      {/* Floating Launcher Button */}
      <motion.button
        initial={{ scale: 0, opacity: 0 }}
        animate={{ scale: 1, opacity: 1 }}
        transition={{ delay: 1, type: 'spring' }}
        onClick={() => setShowModal(true)}
        className="fixed bottom-6 right-6 z-50 flex h-12 w-12 items-center justify-center rounded-full border border-neon-blue/30 bg-black/80 text-neon-blue shadow-[0_0_15px_rgba(0,240,255,0.2)] hover:border-neon-blue hover:text-white backdrop-blur-md cursor-pointer hover:shadow-[0_0_20px_rgba(0,240,255,0.4)] transition-all"
        title="Cookie Settings"
      >
        <Cookie size={20} className="animate-[pulse_3s_infinite]" />
      </motion.button>

      {/* Slide-in Notification Banner */}
      <AnimatePresence>
        {showBanner && (
          <motion.div
            initial={{ y: 100, opacity: 0 }}
            animate={{ y: 0, opacity: 1 }}
            exit={{ y: 100, opacity: 0 }}
            className="fixed bottom-24 right-6 left-6 md:left-auto md:w-[420px] z-40 border border-neon-blue/20 bg-black/95 p-5 rounded-lg glassmorphism shadow-[0_0_30px_rgba(0,0,0,0.8)]"
          >
            <div className="flex gap-4">
              <div className="h-9 w-9 shrink-0 flex items-center justify-center rounded bg-neon-blue/10 text-neon-blue border border-neon-blue/20">
                <Cookie size={18} />
              </div>
              <div className="flex-1">
                <h4 className="text-xs font-bold font-mono uppercase tracking-widest text-white">Encryption & Cache Port</h4>
                <p className="text-[11px] text-zinc-400 mt-1 leading-relaxed font-light">
                  We use localized cache memory protocols to stabilize the interface performance, store your cart arrays, and analyze traffic telemetry.
                </p>
                
                <div className="flex gap-2.5 mt-4">
                  <button
                    onClick={() => setShowModal(true)}
                    className="px-3.5 py-1.5 rounded border border-zinc-800 text-[10px] uppercase font-mono tracking-widest text-zinc-400 hover:text-white hover:border-zinc-700 transition-colors cursor-pointer"
                  >
                    Configure
                  </button>
                  <CyberButton
                    onClick={handleAcceptAll}
                    variant="primary"
                    className="text-[10px] py-1.5 px-4 h-auto min-h-0"
                  >
                    Accept All
                  </CyberButton>
                </div>
              </div>
            </div>
          </motion.div>
        )}
      </AnimatePresence>

      {/* Configuration Settings Modal */}
      <AnimatePresence>
        {showModal && (
          <>
            {/* Backdrop */}
            <motion.div
              initial={{ opacity: 0 }}
              animate={{ opacity: 0.6 }}
              exit={{ opacity: 0 }}
              onClick={() => setShowModal(false)}
              className="fixed inset-0 z-50 bg-black/85 backdrop-blur-xs cursor-pointer"
            />

            {/* Modal Box */}
            <motion.div
              initial={{ scale: 0.95, opacity: 0 }}
              animate={{ scale: 1, opacity: 1 }}
              exit={{ scale: 0.95, opacity: 0 }}
              className="fixed top-1/2 left-1/2 -translate-x-1/2 -translate-y-1/2 z-50 w-full max-w-md border border-neon-blue/20 bg-black p-6 rounded-lg glassmorphism shadow-[0_0_40px_rgba(0,240,255,0.15)]"
            >
              {/* Header */}
              <div className="flex justify-between items-center pb-4 border-b border-zinc-900 mb-6">
                <div className="flex items-center gap-2">
                  <Shield size={16} className="text-neon-blue neon-text-glow" />
                  <h3 className="text-sm font-bold font-mono uppercase tracking-widest text-white">Cache & Encryption Deck</h3>
                </div>
                <button 
                  onClick={() => setShowModal(false)}
                  className="text-zinc-500 hover:text-white transition-colors cursor-pointer"
                >
                  <X size={18} />
                </button>
              </div>

              {/* Toggles Container */}
              <div className="flex flex-col gap-4 mb-6">
                {/* 1. Required Cache */}
                <div className="flex justify-between items-start gap-4 p-3.5 rounded border border-zinc-950 bg-zinc-950/40">
                  <div className="flex-1">
                    <div className="flex items-center gap-1.5">
                      <span className="text-xs font-bold uppercase tracking-wider text-white">Required Cache</span>
                      <span className="text-[8px] bg-zinc-800 text-zinc-400 font-mono px-1.5 py-0.5 rounded border border-zinc-700">Locked</span>
                    </div>
                    <p className="text-[10px] text-zinc-500 mt-1 leading-normal">
                      Essential local storage blocks used to preserve session hashes, interface variables, and cart state arrays. Cannot be disabled.
                    </p>
                  </div>
                  <div className="relative inline-flex items-center cursor-not-allowed">
                    <input type="checkbox" checked disabled className="sr-only peer" />
                    <div className="w-9 h-5 bg-neon-blue rounded-full peer peer-checked:after:translate-x-full after:content-[''] after:absolute after:top-[2px] after:left-[2px] after:bg-black after:rounded-full after:h-4 after:w-4 after:transition-all" />
                  </div>
                </div>

                {/* 2. Performance Cache */}
                <div className="flex justify-between items-start gap-4 p-3.5 rounded border border-zinc-950 bg-zinc-950/40">
                  <div className="flex-1">
                    <span className="text-xs font-bold uppercase tracking-wider text-white">Performance Cache</span>
                    <p className="text-[10px] text-zinc-500 mt-1 leading-normal">
                      Speeds up response triggers by holding media configurations, asset layouts, and font definitions in dynamic cache memory.
                    </p>
                  </div>
                  <label className="relative inline-flex items-center cursor-pointer">
                    <input
                      type="checkbox"
                      checked={consent.performance}
                      onChange={(e) => setConsent({ ...consent, performance: e.target.checked })}
                      className="sr-only peer"
                    />
                    <div className="w-9 h-5 bg-zinc-800 rounded-full peer peer-checked:bg-neon-blue peer-checked:after:translate-x-full after:content-[''] after:absolute after:top-[2px] after:left-[2px] after:bg-black after:rounded-full after:h-4 after:w-4 after:transition-all" />
                  </label>
                </div>

                {/* 3. Analytics Cache */}
                <div className="flex justify-between items-start gap-4 p-3.5 rounded border border-zinc-950 bg-zinc-950/40">
                  <div className="flex-1">
                    <span className="text-xs font-bold uppercase tracking-wider text-white">Analytics Tracking</span>
                    <p className="text-[10px] text-zinc-500 mt-1 leading-normal">
                      Collects anonymous visitor analytics telemetry (visits, clicks, catalog scrolls) to evaluate navigation and optimize load times.
                    </p>
                  </div>
                  <label className="relative inline-flex items-center cursor-pointer">
                    <input
                      type="checkbox"
                      checked={consent.analytics}
                      onChange={(e) => setConsent({ ...consent, analytics: e.target.checked })}
                      className="sr-only peer"
                    />
                    <div className="w-9 h-5 bg-zinc-800 rounded-full peer peer-checked:bg-neon-blue peer-checked:after:translate-x-full after:content-[''] after:absolute after:top-[2px] after:left-[2px] after:bg-black after:rounded-full after:h-4 after:w-4 after:transition-all" />
                  </label>
                </div>
              </div>

              {/* Action Buttons */}
              <div className="grid grid-cols-2 gap-3 pt-4 border-t border-zinc-900">
                <button
                  onClick={() => handleSave(consent)}
                  className="px-4 py-2.5 rounded border border-zinc-800 bg-zinc-900 text-xs font-mono uppercase tracking-widest text-zinc-400 hover:text-white hover:border-zinc-700 transition-colors cursor-pointer"
                >
                  Save Config
                </button>
                <CyberButton
                  onClick={handleAcceptAll}
                  variant="primary"
                >
                  Accept All
                </CyberButton>
              </div>
            </motion.div>
          </>
        )}
      </AnimatePresence>
    </>
  );
};
