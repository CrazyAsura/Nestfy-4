"use client";

import React, { createContext, useContext, useState, useEffect } from 'react';
import { translations, Language } from './i18n/translations';

interface LanguageContextType {
  language: Language;
  setLanguage: (lang: Language) => void;
  t: (keyPath: string) => string;
  formatPrice: (price: number) => string;
}

const LanguageContext = createContext<LanguageContextType | undefined>(undefined);

export const LanguageProvider: React.FC<{ children: React.ReactNode }> = ({ children }) => {
  const [language, setLanguageState] = useState<Language>('en');

  useEffect(() => {
    // 1. Check local storage preference
    const savedLang = localStorage.getItem('nestfy-lang') as Language | null;
    if (savedLang === 'en' || savedLang === 'pt' || savedLang === 'zh') {
      setLanguageState(savedLang);
      document.documentElement.lang = savedLang;
    } else {
      // 2. Perform automatic browser language detection
      const browserLang = navigator.language.toLowerCase();
      let defaultLang: Language = 'en';

      if (browserLang.startsWith('pt')) {
        defaultLang = 'pt';
      } else if (browserLang.startsWith('zh')) {
        defaultLang = 'zh';
      }

      setLanguageState(defaultLang);
      localStorage.setItem('nestfy-lang', defaultLang);
      document.documentElement.lang = defaultLang;
    }
  }, []);

  const setLanguage = (lang: Language) => {
    setLanguageState(lang);
    localStorage.setItem('nestfy-lang', lang);
    document.documentElement.lang = lang;
  };

  // Traverses dictionary keys, e.g. t('nav.smartHub')
  const t = (keyPath: string): string => {
    const keys = keyPath.split('.');
    let currentObj: any = translations[language];

    for (const key of keys) {
      if (currentObj && typeof currentObj === 'object' && key in currentObj) {
        currentObj = currentObj[key];
      } else {
        // Fallback to English dictionary if key missing in current language
        let fallbackObj: any = translations['en'];
        for (const fKey of keys) {
          if (fallbackObj && typeof fallbackObj === 'object' && fKey in fallbackObj) {
            fallbackObj = fallbackObj[fKey];
          } else {
            return keyPath; // Ultimate fallback: return the key string
          }
        }
        return typeof fallbackObj === 'string' ? fallbackObj : keyPath;
      }
    }

    return typeof currentObj === 'string' ? currentObj : keyPath;
  };

  // Localized price formatter based on language
  const formatPrice = (price: number): string => {
    switch (language) {
      case 'pt':
        // Brazilian Portuguese format (R$ 349,00)
        return `R$ ${price.toLocaleString('pt-BR', { minimumFractionDigits: 2, maximumFractionDigits: 2 })}`;
      case 'zh':
        // Chinese Renminbi format (¥349.00)
        return `¥ ${price.toLocaleString('zh-CN', { minimumFractionDigits: 2, maximumFractionDigits: 2 })}`;
      case 'en':
      default:
        // US Dollar format ($349.00)
        return `$ ${price.toLocaleString('en-US', { minimumFractionDigits: 2, maximumFractionDigits: 2 })}`;
    }
  };

  return (
    <LanguageContext.Provider value={{ language, setLanguage, t, formatPrice }}>
      {children}
    </LanguageContext.Provider>
  );
};

export const useLanguage = () => {
  const context = useContext(LanguageContext);
  if (context === undefined) {
    throw new Error('useLanguage must be used within a LanguageProvider');
  }
  return context;
};
