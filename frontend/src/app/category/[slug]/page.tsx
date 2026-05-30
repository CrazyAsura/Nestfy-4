"use client";

import React, { use, useState } from 'react';
import { Header } from '@/components/web/Header';
import { CartDrawer } from '@/components/web/CartDrawer';
import { GlassCard } from '@/components/ui/GlassCard';
import { CyberButton } from '@/components/ui/CyberButton';
import { useAppSelector, useAppDispatch } from '@/lib/store/hooks';
import { addToCart } from '@/lib/store/cartSlice';
import { ArrowLeft, Star, Cpu, Terminal } from 'lucide-react';
import Link from 'next/link';
import { useLanguage } from '@/lib/languageContext';
import { translations } from '@/lib/i18n/translations';

interface PageProps {
  params: Promise<{ slug: string }>;
}

const slugToCategory = (slug: string): string => {
  const map: Record<string, string> = {
    'central-hubs': 'Central Hubs',
    'climate-control': 'Climate Control',
    'robotics': 'Robotics',
    'security-systems': 'Security Systems',
    'ambient-lighting': 'Ambient Lighting',
  };
  return map[slug.toLowerCase()] || slug.replace('-', ' ');
};

export default function CategoryPage({ params }: PageProps) {
  const { slug } = use(params);
  const categoryName = slugToCategory(slug);
  
  const products = useAppSelector((state) => state.products.items);
  const dispatch = useAppDispatch();
  const [isCartOpen, setIsCartOpen] = useState(false);
  const { t, formatPrice, language } = useLanguage();

  // Filter products by category
  const filteredProducts = products.filter(
    (p) => p.category.toLowerCase() === categoryName.toLowerCase()
  );

  const handleAddToCart = (product: any) => {
    dispatch(addToCart({ product }));
  };

  const getLocalizedCategoryName = (s: string) => {
    const localized = t(`products.categories.${s.toLowerCase()}`);
    return localized !== `products.categories.${s.toLowerCase()}` 
      ? localized 
      : s.replace('-', ' ');
  };

  const localizedCategoryName = getLocalizedCategoryName(slug);

  const getLocalizedProduct = (prod: any) => {
    if (!prod) return prod;
    const pid = prod.id;
    const name = t(`products.${pid}.name`);
    const tagline = t(`products.${pid}.tagline`);
    const description = t(`products.${pid}.description`);
    return {
      ...prod,
      name: name !== `products.${pid}.name` ? name : prod.name,
      tagline: tagline !== `products.${pid}.tagline` ? tagline : prod.tagline,
      description: description !== `products.${pid}.description` ? description : prod.description,
    };
  };

  const getLocalizedSpecs = (prod: any) => {
    const pid = prod.id;
    const langDict: any = translations[language];
    if (langDict && langDict.products && langDict.products[pid] && Array.isArray(langDict.products[pid].specs)) {
      return langDict.products[pid].specs;
    }
    return prod.specs;
  };

  return (
    <div className="relative min-h-screen bg-background text-foreground transition-colors duration-300 overflow-hidden cyber-grid">
      <div className="absolute top-[-20%] left-[-10%] w-[50%] h-[50%] bg-[radial-gradient(ellipse_at_center,rgba(0,240,255,0.05),transparent_70%)] pointer-events-none" />
      <div className="absolute inset-0 scanline-effect opacity-[0.01] pointer-events-none" />

      {/* Navigation Header */}
      <Header onToggleCart={() => setIsCartOpen(!isCartOpen)} />

      <main className="mx-auto max-w-7xl px-6 py-16 relative z-10">
        
        {/* Back Link */}
        <Link href="/" className="inline-flex items-center gap-2 text-xs uppercase font-mono tracking-widest text-zinc-500 hover:text-neon-blue transition-colors mb-8">
          <ArrowLeft size={12} />
          {t('nav.backToCore')}
        </Link>

        {/* Dynamic Category Title */}
        <div className="flex flex-col gap-4 mb-12 text-center md:text-left">
          <div className="inline-flex items-center self-center md:self-start gap-2 bg-zinc-950/60 border border-neon-blue/15 px-3 py-1 rounded text-[10px] tracking-widest text-zinc-500 uppercase font-mono">
            <Terminal size={12} className="text-neon-blue neon-text-glow animate-pulse" />
            {t('products.catUplink')}: {slug.toUpperCase()}
          </div>
          
          <h1 className="text-3xl md:text-4xl font-black uppercase tracking-tight">
            {t('products.category')}: <span className="text-transparent bg-clip-text bg-linear-to-r from-white via-neon-blue to-white neon-text-glow">{localizedCategoryName}</span>
          </h1>
          <p className="text-sm text-zinc-400 font-light leading-relaxed max-w-xl">
            {t('products.acquireSpecialized')}
          </p>
        </div>

        {/* Product Grid */}
        {filteredProducts.length === 0 ? (
          <div className="flex flex-col items-center justify-center py-20 text-center border border-dashed border-zinc-800 rounded">
            <Cpu size={32} className="text-zinc-700 mb-4" />
            <p className="text-sm text-zinc-500 uppercase tracking-widest font-mono">{t('products.noHardwareCategory')}</p>
          </div>
        ) : (
          <div className="grid grid-cols-1 md:grid-cols-2 gap-8 w-full">
            {filteredProducts.map((product, idx) => {
              const lProd = getLocalizedProduct(product);
              const lSpecs = getLocalizedSpecs(product);
              return (
                <GlassCard
                  key={product.id}
                  delay={idx * 0.1}
                  className="flex flex-col h-full justify-between"
                >
                  <div>
                    <div className="flex items-center justify-between gap-4 mb-4">
                      <span className="text-[10px] tracking-widest text-neon-blue uppercase border border-neon-blue/20 bg-neon-blue/5 px-2.5 py-0.5 rounded font-black">
                        {localizedCategoryName}
                      </span>
                      <div className="flex items-center gap-1.5 text-zinc-500 text-xs">
                        <Star size={12} className="text-yellow-500 fill-yellow-500" />
                        <span>{lProd.rating}</span>
                      </div>
                    </div>

                    {/* Product Visual Area */}
                    <div className="relative w-full h-48 bg-zinc-950/80 rounded border border-zinc-900 overflow-hidden flex items-center justify-center mb-6 group">
                      <div className="absolute inset-0 cyber-grid-dense opacity-20 group-hover:opacity-35 transition-opacity" />
                      <div className="absolute top-0 left-0 w-full h-full bg-linear-to-t from-black via-transparent to-transparent z-10" />
                      <div className="absolute top-3 left-3 text-[8px] text-zinc-600 font-mono tracking-wider">
                        SYS_MODEL: {lProd.id.toUpperCase()}_v9.42
                      </div>
                      <div className="relative w-36 h-36 flex items-center justify-center transition-transform duration-500 group-hover:scale-110">
                        <Cpu className="w-16 h-16 text-zinc-800 group-hover:text-neon-blue/30 transition-colors duration-500" />
                        <div className="absolute inset-0 flex items-center justify-center">
                          <span className="text-[10px] tracking-widest text-zinc-500 uppercase font-mono group-hover:text-neon-blue transition-colors duration-300">
                            [ {lProd.tagline} ]
                          </span>
                        </div>
                      </div>
                    </div>

                    <Link href={`/product/${lProd.id}`} className="group/title">
                      <h3 className="text-xl font-bold tracking-wider text-foreground mb-2 uppercase group-hover/title:text-primary transition-colors duration-300">
                        {lProd.name}
                      </h3>
                    </Link>
                    <p className="text-sm text-zinc-400 mb-6 leading-relaxed font-light">
                      {lProd.description}
                    </p>

                    {/* Specs */}
                    <div className="grid grid-cols-2 gap-3 mb-6 bg-black/40 p-4 rounded border border-zinc-900">
                      {lSpecs.map((spec: any, sidx: number) => (
                        <div key={sidx} className="flex flex-col">
                          <span className="text-[9px] uppercase tracking-wider text-zinc-500 font-bold">{spec.label}</span>
                          <span className="text-xs text-zinc-300 truncate font-mono">{spec.value}</span>
                        </div>
                      ))}
                    </div>
                  </div>

                  <div className="flex items-center justify-between mt-auto pt-4 border-t border-zinc-900 gap-4">
                    <div className="flex flex-col">
                      <span className="text-[9px] uppercase tracking-wider text-zinc-500 font-bold">{t('products.syncCost')}</span>
                      <span className="text-lg font-mono font-black text-white">
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
        )}

      </main>

      {/* Cart Drawer */}
      <CartDrawer
        isOpen={isCartOpen}
        onClose={() => setIsCartOpen(false)}
      />

      {/* Footer */}
      <footer className="border-t border-zinc-950 py-8 text-center text-[10px] tracking-widest text-zinc-700 uppercase font-mono mt-16">
        NESTFY SYSTEMS © 2026. UPLINK_CAT_INDEX_OK.
      </footer>
    </div>
  );
}
