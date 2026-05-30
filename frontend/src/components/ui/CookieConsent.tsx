"use client";

import React, { useState, useEffect } from 'react';
import { motion, AnimatePresence } from 'framer-motion';
import { Cookie, X, Shield, Info } from 'lucide-react';
import { CyberButton } from './CyberButton';
import { useLanguage } from '@/lib/languageContext';

export const CookieConsent: React.FC = () => {
  const { t } = useLanguage();
  const [showBanner, setShowBanner] = useState(false);
  const [showModal, setShowModal] = useState(false);
  const [showDpoInfo, setShowDpoInfo] = useState(false);
  
  // Consent states matching LGPD principles
  const [consent, setConsent] = useState({
    required: true,
    performance: true,
    analytics: false // Denied by default under strict LGPD compliance
  });

  useEffect(() => {
    // Custom event listener to open consent modal from anywhere (e.g. from promotions badge)
    const handleOpenConsent = () => {
      setShowModal(true);
    };
    window.addEventListener('open-privacy-consent', handleOpenConsent);

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

    return () => {
      window.removeEventListener('open-privacy-consent', handleOpenConsent);
    };
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

  const handleRejectAll = () => {
    const allRejected = { required: true, performance: false, analytics: false };
    handleSave(allRejected);
  };

  return (
    <>
      {/* Floating Launcher Button (Apple standard dynamic interaction) */}
      <motion.button
        initial={{ scale: 0, opacity: 0 }}
        animate={{ scale: 1, opacity: 1 }}
        transition={{ delay: 1.5, type: 'spring' }}
        onClick={() => setShowModal(true)}
        className="fixed bottom-6 right-6 z-40 flex h-12 w-12 items-center justify-center rounded-full border border-zinc-200 dark:border-neon-blue/30 bg-white/90 dark:bg-black/80 text-zinc-700 dark:text-neon-blue shadow-[0_4px_16px_rgba(0,0,0,0.08)] dark:shadow-[0_0_15px_rgba(0,240,255,0.2)] hover:text-zinc-950 dark:hover:text-white backdrop-blur-md cursor-pointer transition-all hover:scale-105"
        title={t('cookie.title')}
      >
        <Cookie size={20} className="animate-[pulse_4s_infinite]" />
      </motion.button>

      {/* Slide-in Notification Banner (LGPD Compliant Option) */}
      <AnimatePresence>
        {showBanner && (
          <motion.div
            initial={{ y: 100, opacity: 0 }}
            animate={{ y: 0, opacity: 1 }}
            exit={{ y: 100, opacity: 0 }}
            className="fixed bottom-24 right-6 left-6 md:left-auto md:w-[460px] z-40 border border-zinc-200 dark:border-zinc-800 bg-white/95 dark:bg-zinc-950/95 p-5 rounded-xl shadow-xl backdrop-blur-lg"
          >
            <div className="flex gap-4">
              <div className="h-9 w-9 shrink-0 flex items-center justify-center rounded-lg bg-zinc-100 dark:bg-neon-blue/10 text-zinc-800 dark:text-neon-blue border border-zinc-200 dark:border-neon-blue/20">
                <Cookie size={18} />
              </div>
              <div className="flex-1">
                <h4 className="text-xs font-bold uppercase tracking-wider text-zinc-900 dark:text-white">
                  {t('cookie.title')}
                </h4>
                <p className="text-[11px] text-zinc-600 dark:text-zinc-400 mt-1.5 leading-relaxed font-light">
                  {t('cookie.desc')}
                </p>
                
                <div className="flex flex-wrap gap-2 mt-4">
                  <button
                    onClick={() => setShowModal(true)}
                    className="px-3 py-1.5 rounded-lg border border-zinc-200 dark:border-zinc-800 text-[10px] uppercase font-mono tracking-wider text-zinc-600 dark:text-zinc-400 hover:text-zinc-900 dark:hover:text-white transition-colors cursor-pointer"
                  >
                    {t('cookie.customize')}
                  </button>
                  <button
                    onClick={handleRejectAll}
                    className="px-3 py-1.5 rounded-lg border border-transparent bg-zinc-100 dark:bg-zinc-900 text-[10px] uppercase font-mono tracking-wider text-zinc-600 dark:text-zinc-400 hover:text-zinc-900 dark:hover:text-white transition-colors cursor-pointer"
                  >
                    {t('cookie.reject')}
                  </button>
                  <CyberButton
                    onClick={handleAcceptAll}
                    variant="primary"
                    className="text-[10px] py-1.5 px-4 h-auto min-h-0"
                  >
                    {t('cookie.acceptAll')}
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
              animate={{ opacity: 0.5 }}
              exit={{ opacity: 0 }}
              onClick={() => setShowModal(false)}
              className="fixed inset-0 z-50 bg-black/60 backdrop-blur-xs cursor-pointer"
            />

            {/* Modal Box */}
            <motion.div
              initial={{ scale: 0.95, opacity: 0 }}
              animate={{ scale: 1, opacity: 1 }}
              exit={{ scale: 0.95, opacity: 0 }}
              className="fixed top-1/2 left-1/2 -translate-x-1/2 -translate-y-1/2 z-50 w-full max-w-lg max-h-[85vh] overflow-y-auto border border-zinc-200 dark:border-zinc-800 bg-white dark:bg-zinc-950 p-6 rounded-2xl shadow-2xl backdrop-blur-xl"
            >
              {/* Header */}
              <div className="flex justify-between items-center pb-4 border-b border-zinc-100 dark:border-zinc-900 mb-5">
                <div className="flex items-center gap-2">
                  <Shield size={16} className="text-zinc-800 dark:text-neon-blue" />
                  <h3 className="text-xs md:text-sm font-bold uppercase tracking-wider text-zinc-900 dark:text-white">
                    {t('cookie.modalTitle')}
                  </h3>
                </div>
                <button 
                  onClick={() => setShowModal(false)}
                  className="text-zinc-400 hover:text-zinc-900 dark:hover:text-white transition-colors cursor-pointer"
                >
                  <X size={18} />
                </button>
              </div>

              {/* Legal Info Summary */}
              <div className="bg-zinc-50 dark:bg-zinc-900/40 border border-zinc-100 dark:border-zinc-900 p-4 rounded-xl mb-5 text-[11px] text-zinc-600 dark:text-zinc-400 leading-relaxed font-light">
                <p>{t('cookie.modalDesc')}</p>
              </div>

              {/* Toggles Container */}
              <div className="flex flex-col gap-4 mb-5">
                {/* 1. Required Cookies */}
                <div className="flex justify-between items-start gap-4 p-4 rounded-xl border border-zinc-100 dark:border-zinc-900 bg-zinc-50/50 dark:bg-zinc-900/20">
                  <div className="flex-1">
                    <div className="flex items-center gap-2">
                      <span className="text-xs font-bold text-zinc-900 dark:text-white">{t('cookie.reqTitle')}</span>
                      <span className="text-[8px] bg-zinc-200 dark:bg-zinc-800 text-zinc-600 dark:text-zinc-400 font-mono px-1.5 py-0.5 rounded-sm">
                        {t('cookie.reqStatus')}
                      </span>
                    </div>
                    <p className="text-[10px] text-zinc-500 dark:text-zinc-500 mt-1 leading-normal">
                      {t('cookie.reqDesc')}
                    </p>
                  </div>
                  <div className="relative inline-flex items-center cursor-not-allowed">
                    <input type="checkbox" checked disabled className="sr-only peer" />
                    <div className="w-9 h-5 bg-zinc-400 dark:bg-neon-blue rounded-full peer peer-checked:after:translate-x-full after:content-[''] after:absolute after:top-[2px] after:left-[2px] after:bg-white dark:after:bg-black after:rounded-full after:h-4 after:w-4 after:transition-all" />
                  </div>
                </div>

                {/* 2. Performance Cookies */}
                <div className="flex justify-between items-start gap-4 p-4 rounded-xl border border-zinc-100 dark:border-zinc-900 bg-zinc-50/50 dark:bg-zinc-900/20">
                  <div className="flex-1">
                    <span className="text-xs font-bold text-zinc-900 dark:text-white">{t('cookie.perfTitle')}</span>
                    <p className="text-[10px] text-zinc-500 dark:text-zinc-500 mt-1 leading-normal">
                      {t('cookie.perfDesc')}
                    </p>
                  </div>
                  <label className="relative inline-flex items-center cursor-pointer">
                    <input
                      type="checkbox"
                      checked={consent.performance}
                      onChange={(e) => setConsent({ ...consent, performance: e.target.checked })}
                      className="sr-only peer"
                    />
                    <div className="w-9 h-5 bg-zinc-200 dark:bg-zinc-800 rounded-full peer peer-checked:bg-zinc-950 dark:peer-checked:bg-neon-blue peer-checked:after:translate-x-full after:content-[''] after:absolute after:top-[2px] after:left-[2px] after:bg-white dark:after:bg-black after:rounded-full after:h-4 after:w-4 after:transition-all" />
                  </label>
                </div>

                {/* 3. Analytics Cookies */}
                <div className="flex justify-between items-start gap-4 p-4 rounded-xl border border-zinc-100 dark:border-zinc-900 bg-zinc-50/50 dark:bg-zinc-900/20">
                  <div className="flex-1">
                    <span className="text-xs font-bold text-zinc-900 dark:text-white">{t('cookie.analTitle')}</span>
                    <p className="text-[10px] text-zinc-500 dark:text-zinc-500 mt-1 leading-normal">
                      {t('cookie.analDesc')}
                    </p>
                  </div>
                  <label className="relative inline-flex items-center cursor-pointer">
                    <input
                      type="checkbox"
                      checked={consent.analytics}
                      onChange={(e) => setConsent({ ...consent, analytics: e.target.checked })}
                      className="sr-only peer"
                    />
                    <div className="w-9 h-5 bg-zinc-200 dark:bg-zinc-800 rounded-full peer peer-checked:bg-zinc-950 dark:peer-checked:bg-neon-blue peer-checked:after:translate-x-full after:content-[''] after:absolute after:top-[2px] after:left-[2px] after:bg-white dark:after:bg-black after:rounded-full after:h-4 after:w-4 after:transition-all" />
                  </label>
                </div>
              </div>

              {/* Rights & DPO Accordion */}
              <div className="border border-zinc-100 dark:border-zinc-900 rounded-xl mb-6 overflow-hidden">
                <button
                  onClick={() => setShowDpoInfo(!showDpoInfo)}
                  className="w-full flex justify-between items-center p-3 bg-zinc-50 dark:bg-zinc-900/20 text-left text-xs font-semibold text-zinc-700 dark:text-zinc-300 cursor-pointer"
                >
                  <div className="flex items-center gap-1.5">
                    <Info size={13} className="text-zinc-500" />
                    <span>{t('cookie.rightsTitle')}</span>
                  </div>
                  <span className="text-[10px] text-zinc-400">{showDpoInfo ? '▲' : '▼'}</span>
                </button>
                
                <AnimatePresence>
                  {showDpoInfo && (
                    <motion.div
                      initial={{ height: 0, opacity: 0 }}
                      animate={{ height: 'auto', opacity: 1 }}
                      exit={{ height: 0, opacity: 0 }}
                      className="p-4 border-t border-zinc-100 dark:border-zinc-900 text-[10px] text-zinc-600 dark:text-zinc-400 flex flex-col gap-3 font-light leading-relaxed"
                    >
                      <p>{t('cookie.rightsDesc')}</p>
                      <p className="bg-zinc-50 dark:bg-zinc-900/60 p-2.5 rounded-lg border border-zinc-100 dark:border-zinc-900 whitespace-pre-line">
                        {t('cookie.dpoInfo')}
                      </p>
                      <p>{t('cookie.dpoNotice')}</p>
                    </motion.div>
                  )}
                </AnimatePresence>
              </div>

              {/* Action Buttons */}
              <div className="flex flex-col sm:flex-row gap-3 pt-4 border-t border-zinc-100 dark:border-zinc-900">
                <button
                  onClick={handleRejectAll}
                  className="flex-1 px-4 py-2.5 rounded-lg border border-zinc-200 dark:border-zinc-800 text-xs font-mono uppercase tracking-wider text-zinc-600 dark:text-zinc-400 hover:text-zinc-950 dark:hover:text-white transition-colors cursor-pointer"
                >
                  {t('cookie.reject')}
                </button>
                <button
                  onClick={() => handleSave(consent)}
                  className="flex-1 px-4 py-2.5 rounded-lg border border-zinc-200 dark:border-zinc-800 bg-zinc-50 dark:bg-zinc-900 text-xs font-mono uppercase tracking-wider text-zinc-700 dark:text-zinc-300 hover:text-zinc-950 dark:hover:text-white transition-colors cursor-pointer"
                >
                  {t('cookie.save')}
                </button>
                <CyberButton
                  onClick={handleAcceptAll}
                  variant="primary"
                  className="flex-1 py-2.5 text-xs"
                >
                  {t('cookie.acceptAll')}
                </CyberButton>
              </div>
            </motion.div>
          </>
        )}
      </AnimatePresence>
    </>
  );
};
