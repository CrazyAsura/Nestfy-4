"use client";

import React, { useState, useEffect, useRef } from 'react';
import { useSearch } from '@/lib/searchContext';
import { useAppSelector } from '@/lib/store/hooks';
import { Product } from '@/lib/store/productSlice';
import { Search, X, Cpu, ArrowRight } from 'lucide-react';
import { motion, AnimatePresence } from 'framer-motion';
import Link from 'next/link';
import { useLanguage } from '@/lib/languageContext';

export const SearchOverlay: React.FC = () => {
  const { isOpen, closeSearch } = useSearch();
  const products = useAppSelector((state) => state.products.items);
  const { t } = useLanguage();
  const [query, setQuery] = useState('');
  const inputRef = useRef<HTMLInputElement>(null);

  // Auto-focus input on open
  useEffect(() => {
    if (isOpen) {
      setTimeout(() => {
        inputRef.current?.focus();
      }, 100);
      // Prevent background scrolling
      document.body.style.overflow = 'hidden';
    } else {
      setQuery('');
      document.body.style.overflow = 'unset';
    }
    return () => {
      document.body.style.overflow = 'unset';
    };
  }, [isOpen]);

  // Localize product details for searching in translated properties
  const getLocalizedProduct = (prod: Product) => {
    const id = prod.id;
    const name = t(`products.${id}.name`);
    const tagline = t(`products.${id}.tagline`);
    const description = t(`products.${id}.description`);
    return {
      ...prod,
      name: name !== `products.${id}.name` ? name : prod.name,
      tagline: tagline !== `products.${id}.tagline` ? tagline : prod.tagline,
      description: description !== `products.${id}.description` ? description : prod.description,
    } as Product;
  };

  const localizedProducts = products.map(getLocalizedProduct);

  const filteredProducts = query.trim() === '' 
    ? [] 
    : localizedProducts.filter(product => 
        product.name.toLowerCase().includes(query.toLowerCase()) ||
        product.category.toLowerCase().includes(query.toLowerCase()) ||
        product.tagline.toLowerCase().includes(query.toLowerCase()) ||
        product.description.toLowerCase().includes(query.toLowerCase())
      );

  return (
    <AnimatePresence>
      {isOpen && (
        <div className="fixed inset-0 z-50 flex items-center justify-center p-4">
          {/* Transparent Backdrop with Blur */}
          <motion.div
            initial={{ opacity: 0 }}
            animate={{ opacity: 1 }}
            exit={{ opacity: 0 }}
            onClick={closeSearch}
            className="absolute inset-0 bg-black/40 dark:bg-black/60 backdrop-blur-xl transition-all duration-300"
          />

          {/* Centered Modal Container */}
          <motion.div
            initial={{ opacity: 0, scale: 0.95, y: -20 }}
            animate={{ opacity: 1, scale: 1, y: 0 }}
            exit={{ opacity: 0, scale: 0.95, y: 20 }}
            transition={{ type: "spring", stiffness: 350, damping: 25 }}
            className="relative w-full max-w-2xl bg-white/10 dark:bg-zinc-950/40 border border-zinc-200/20 dark:border-neon-blue/20 rounded-xl overflow-hidden shadow-2xl backdrop-blur-2xl p-6 flex flex-col gap-6"
            style={{
              boxShadow: '0 20px 50px rgba(0, 0, 0, 0.3), inset 0 1px 0 rgba(255, 255, 255, 0.1)'
            }}
          >
            {/* Search Input Box */}
            <div className="relative flex items-center w-full">
              <Search className="absolute left-4 text-zinc-400 dark:text-neon-blue/70 w-5 h-5" />
              <input
                ref={inputRef}
                type="text"
                value={query}
                onChange={(e) => setQuery(e.target.value)}
                placeholder={t('search.placeholder')}
                className="w-full bg-zinc-950/20 dark:bg-black/40 border border-zinc-300/30 dark:border-neon-blue/30 focus:border-neon-blue focus:dark:shadow-[0_0_15px_rgba(0,240,255,0.25)] rounded-lg pl-12 pr-12 py-4 text-base md:text-lg outline-none text-foreground font-mono placeholder-zinc-500 transition-all duration-200"
              />
              <button 
                onClick={closeSearch}
                className="absolute right-4 text-zinc-400 hover:text-foreground dark:hover:text-neon-blue p-1 rounded-md transition-colors"
              >
                <X className="w-5 h-5" />
              </button>
            </div>

            {/* Results Section */}
            <div className="max-h-[350px] overflow-y-auto pr-1 flex flex-col gap-3 custom-scrollbar">
              {query.trim() === '' ? (
                <div className="flex flex-col items-center justify-center py-10 text-center gap-2">
                  <Cpu className="w-8 h-8 text-zinc-500 dark:text-neon-blue/40 animate-pulse" />
                  <p className="text-xs uppercase tracking-widest text-zinc-500 font-mono">{t('search.typeToSearch')}</p>
                  <p className="text-[10px] text-zinc-600 dark:text-zinc-500 font-mono">{t('search.pressEsc')}</p>
                </div>
              ) : filteredProducts.length === 0 ? (
                <div className="text-center py-10">
                  <p className="text-sm text-zinc-400 font-mono">{t('search.noMatches')} &quot;{query}&quot;</p>
                </div>
              ) : (
                <div className="flex flex-col gap-2">
                  <p className="text-[10px] uppercase tracking-widest text-zinc-500 font-mono mb-2 px-2">
                    {t('search.resultsHeader')} ({filteredProducts.length})
                  </p>
                  {filteredProducts.map((product) => (
                    <Link
                      key={product.id}
                      href={`/product/${product.id}`}
                      onClick={closeSearch}
                      className="group flex items-center justify-between p-3.5 rounded-lg border border-transparent hover:border-zinc-200/10 hover:bg-white/5 dark:hover:bg-neon-blue/5 transition-all duration-200 cursor-pointer"
                    >
                      <div className="flex items-center gap-3">
                        <div className="flex h-10 w-10 items-center justify-center rounded border border-zinc-200/10 bg-zinc-150/10 dark:bg-neon-blue/10 text-zinc-600 dark:text-neon-blue">
                          <Cpu className="w-5 h-5 group-hover:scale-110 transition-transform duration-200" />
                        </div>
                        <div>
                          <h4 className="text-sm font-bold text-foreground group-hover:text-neon-blue transition-colors font-mono">
                            {product.name}
                          </h4>
                          <p className="text-xs text-zinc-500 font-light truncate max-w-[320px] sm:max-w-[450px]">
                            {product.tagline}
                          </p>
                        </div>
                      </div>
                      <ArrowRight className="w-4 h-4 text-zinc-500 group-hover:text-neon-blue group-hover:translate-x-1 transition-all duration-200" />
                    </Link>
                  ))}
                </div>
              )}
            </div>
          </motion.div>
        </div>
      )}
    </AnimatePresence>
  );
};
