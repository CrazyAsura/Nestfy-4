"use client";

import React, { useState, useRef, useEffect } from 'react';
import { motion, AnimatePresence } from 'framer-motion';
import { useLanguage } from '@/lib/languageContext';
import { Language } from '@/lib/i18n/translations';
import { Globe, ChevronDown } from 'lucide-react';

export const LanguageSwitcher: React.FC = () => {
  const { language, setLanguage } = useLanguage();
  const [isOpen, setIsOpen] = useState(false);
  const containerRef = useRef<HTMLDivElement>(null);

  // Close dropdown when clicking outside
  useEffect(() => {
    const handleClickOutside = (event: MouseEvent) => {
      if (containerRef.current && !containerRef.current.contains(event.target as Node)) {
        setIsOpen(false);
      }
    };
    document.addEventListener('mousedown', handleClickOutside);
    return () => document.removeEventListener('mousedown', handleClickOutside);
  }, []);

  const languages = [
    { code: 'pt' as Language, label: 'Português', flag: '🇧🇷' },
    { code: 'en' as Language, label: 'English', flag: '🇺🇸' },
    { code: 'zh' as Language, label: '中文', flag: '🇨🇳' }
  ];

  const currentLang = languages.find(l => l.code === language) || languages[1];

  return (
    <div ref={containerRef} className="relative inline-block text-left z-50">
      {/* Trigger Button */}
      <motion.button
        whileTap={{ scale: 0.95 }}
        onClick={() => setIsOpen(!isOpen)}
        className="flex items-center gap-1.5 px-3 py-1.5 rounded-lg border border-zinc-200 dark:border-zinc-800 bg-white/40 dark:bg-black/40 text-zinc-700 dark:text-zinc-300 hover:text-zinc-950 dark:hover:text-white backdrop-blur-md cursor-pointer transition-colors text-xs font-mono select-none"
      >
        <Globe size={14} className="text-zinc-500 dark:text-zinc-400" />
        <span>{currentLang.flag} {currentLang.code.toUpperCase()}</span>
        <ChevronDown size={12} className={`transition-transform duration-300 ${isOpen ? 'rotate-180' : ''}`} />
      </motion.button>

      {/* Dropdown Menu */}
      <AnimatePresence>
        {isOpen && (
          <motion.div
            initial={{ opacity: 0, y: 8, scale: 0.95 }}
            animate={{ opacity: 1, y: 0, scale: 1 }}
            exit={{ opacity: 0, y: 8, scale: 0.95 }}
            transition={{ duration: 0.2, ease: [0.16, 1, 0.3, 1] }}
            className="absolute right-0 mt-2 w-40 rounded-xl border border-zinc-200 dark:border-zinc-800 bg-white/95 dark:bg-black/95 shadow-xl backdrop-blur-lg overflow-hidden p-1"
          >
            {languages.map((lang) => (
              <button
                key={lang.code}
                onClick={() => {
                  setLanguage(lang.code);
                  setIsOpen(false);
                }}
                className={`w-full flex items-center justify-between px-3 py-2 text-left rounded-lg text-xs font-medium transition-colors cursor-pointer select-none ${
                  language === lang.code
                    ? 'bg-zinc-100 dark:bg-zinc-900 text-zinc-950 dark:text-white'
                    : 'text-zinc-600 dark:text-zinc-400 hover:bg-zinc-50 dark:hover:bg-zinc-900/40 hover:text-zinc-900 dark:hover:text-white'
                }`}
              >
                <span className="flex items-center gap-2">
                  <span className="text-sm leading-none">{lang.flag}</span>
                  <span>{lang.label}</span>
                </span>
                
                {language === lang.code && (
                  <motion.span 
                    layoutId="active-indicator"
                    className="w-1.5 h-1.5 rounded-full bg-zinc-900 dark:bg-neon-blue shadow-[0_0_8px_rgba(0,240,255,0.4)]"
                  />
                )}
              </button>
            ))}
          </motion.div>
        )}
      </AnimatePresence>
    </div>
  );
};
