"use client";

import React from 'react';
import { Provider } from 'react-redux';
import { store } from '@/lib/store/store';
import { ThemeProvider } from '@/lib/themeContext';
import { SearchProvider } from '@/lib/searchContext';
import { LanguageProvider } from '@/lib/languageContext';
import { SearchOverlay } from '@/components/web/SearchOverlay';

export function Providers({ children }: { children: React.ReactNode }) {
  return (
    <ThemeProvider>
      <LanguageProvider>
        <Provider store={store}>
          <SearchProvider>
            {children}
            <SearchOverlay />
          </SearchProvider>
        </Provider>
      </LanguageProvider>
    </ThemeProvider>
  );
}


