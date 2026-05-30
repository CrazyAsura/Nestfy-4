"use client";

import React, { useState } from 'react';
import { useAppSelector, useAppDispatch } from '@/lib/store/hooks';
import { Product } from '@/lib/store/productSlice';
import { addToCart } from '@/lib/store/cartSlice';
import { GlassCard } from '../ui/GlassCard';
import { CyberButton } from '../ui/CyberButton';
import { Star, Cpu } from 'lucide-react';
import { useLanguage } from '@/lib/languageContext';
import { translations } from '@/lib/i18n/translations';
import Link from 'next/link';

export const ProductGrid: React.FC = () => {
  const products = useAppSelector((state) => state.products.items);
  const dispatch = useAppDispatch();
  const { t, formatPrice, language } = useLanguage();
  
  const [selectedCategory, setSelectedCategory] = useState<string>('All');
  
  const categories = ['All', ...Array.from(new Set(products.map((p) => p.category)))];

  const filteredProducts = selectedCategory === 'All'
    ? products
    : products.filter((p) => p.category === selectedCategory);

  const handleAddToCart = (product: any) => {
    dispatch(addToCart({ product }));
  };

  const getLocalizedProduct = (prod: Product) => {
    const id = prod.id;
    const name = t(`products.${id}.name`);
    const tagline = t(`products.${id}.tagline`);
    const description = t(`products.${id}.description`);
    
    // Localized specs check
    let specs = prod.specs;
    const langDict: any = translations[language];
    if (langDict && langDict.products && langDict.products[id] && Array.isArray(langDict.products[id].specs)) {
      specs = langDict.products[id].specs;
    }

    return {
      ...prod,
      name: name !== `products.${id}.name` ? name : prod.name,
      tagline: tagline !== `products.${id}.tagline` ? tagline : prod.tagline,
      description: description !== `products.${id}.description` ? description : prod.description,
      specs,
    } as Product;
  };

  return (
    <div className="flex flex-col gap-10">
      
      {/* Category Tabs */}
      <div className="flex flex-wrap items-center justify-center gap-3">
        {categories.map((category) => (
          <button
            key={category}
            onClick={() => setSelectedCategory(category)}
            className={`px-5 py-2 text-xs uppercase tracking-widest transition-all duration-300 rounded border cursor-pointer ${
              selectedCategory === category
                ? 'bg-primary/10 border-primary text-primary shadow-[0_0_12px_rgba(0,102,204,0.15)] dark:bg-neon-blue/15 dark:border-neon-blue dark:text-neon-blue dark:shadow-[0_0_12px_rgba(0,240,255,0.25)]'
                : 'bg-secondary/40 border-border text-zinc-500 hover:text-foreground dark:hover:text-white hover:border-zinc-400 dark:hover:border-zinc-700'
            }`}
          >
            {category === 'All' ? t('products.categoryAll') : category}
          </button>
        ))}
      </div>

      {/* Grid Layout */}
      <div className="grid grid-cols-1 md:grid-cols-2 gap-8 max-w-7xl mx-auto w-full px-4">
        {filteredProducts.map((product, idx) => {
          const lProd = getLocalizedProduct(product);
          return (
            <GlassCard
              key={product.id}
              delay={idx * 0.1}
              className="flex flex-col h-full justify-between"
            >
              {/* Header info */}
              <div>
                <div className="flex items-center justify-between gap-4 mb-4">
                  <span className="text-[10px] tracking-widest text-primary dark:text-neon-blue uppercase border border-border dark:border-neon-blue/20 bg-primary/5 dark:bg-neon-blue/5 px-2.5 py-0.5 rounded font-black">
                    {lProd.category}
                  </span>
                  
                  <div className="flex items-center gap-1.5 text-zinc-500 text-xs">
                    <Star size={12} className="text-yellow-500 fill-yellow-500" />
                    <span>{lProd.rating}</span>
                  </div>
                </div>

                {/* Product Visual Mockup */}
                <div className="relative w-full h-48 bg-secondary/20 rounded border border-border overflow-hidden flex items-center justify-center mb-6 group">
                  <div className="absolute inset-0 cyber-grid-dense opacity-20 group-hover:opacity-35 transition-opacity" />
                  <div className="absolute top-0 left-0 w-full h-full bg-gradient-to-t from-background via-transparent to-transparent z-10" />
                  
                  {/* Tech HUD decorative overlay */}
                  <div className="absolute top-2 right-2 border-t border-r border-border w-4 h-4" />
                  <div className="absolute bottom-2 left-2 border-b border-l border-border w-4 h-4" />
                  
                  {/* Product details indicator */}
                  <div className="absolute top-3 left-3 text-[8px] text-zinc-500 font-mono tracking-wider">
                    SYS_MODEL: {lProd.id.toUpperCase()}_v9.42
                  </div>
                  
                  <div className="relative w-36 h-36 flex items-center justify-center transition-transform duration-500 group-hover:scale-110">
                    <Cpu className="w-16 h-16 text-zinc-400 dark:text-zinc-800 group-hover:text-primary/30 transition-colors duration-500" />
                    <div className="absolute inset-0 flex items-center justify-center">
                      <span className="text-[10px] tracking-widest text-zinc-500 uppercase font-mono group-hover:text-primary transition-colors duration-300">
                        [ {lProd.tagline} ]
                      </span>
                    </div>
                  </div>
                </div>

                {/* Title & Description */}
                <Link href={`/product/${lProd.id}`} className="group/title">
                  <h3 className="text-xl font-bold tracking-wider text-foreground mb-2 uppercase group-hover/title:text-primary transition-colors duration-300">
                    {lProd.name}
                  </h3>
                </Link>
                <p className="text-sm text-zinc-500 dark:text-zinc-400 mb-6 leading-relaxed font-light">
                  {lProd.description}
                </p>

                {/* Product Specifications list */}
                <div className="grid grid-cols-2 gap-3 mb-6 bg-secondary/35 p-4 rounded border border-border">
                  {lProd.specs.map((spec, sidx) => (
                    <div key={sidx} className="flex flex-col">
                      <span className="text-[9px] uppercase tracking-wider text-zinc-500 font-bold">{spec.label}</span>
                      <span className="text-xs text-zinc-700 dark:text-zinc-300 truncate font-mono">{spec.value}</span>
                    </div>
                  ))}
                </div>
              </div>

              {/* Bottom Actions */}
              <div className="flex items-center justify-between mt-auto pt-4 border-t border-border gap-4">
                <div className="flex flex-col">
                  <span className="text-[9px] uppercase tracking-wider text-zinc-500 font-bold">
                    {t('promotions.specialValue')}
                  </span>
                  <span className="text-lg font-mono font-black text-foreground">
                    {formatPrice(lProd.price)}
                  </span>
                </div>
                
                <CyberButton
                  onClick={() => handleAddToCart(product)}
                  variant="outline"
                  className="w-40"
                >
                  {t('products.addToCart')}
                </CyberButton>
              </div>
            </GlassCard>
          );
        })}
      </div>
    </div>
  );
};
