"use client";

import React, { useState, useEffect, useRef } from 'react';
import { motion, AnimatePresence } from 'framer-motion';
import { 
  ArrowLeft, 
  ArrowRight, 
  Star, 
  ShieldCheck, 
  Sparkles, 
  Clock, 
  Heart,
  ChevronRight
} from 'lucide-react';
import { useTheme } from '@/lib/themeContext';
import { useLanguage } from '@/lib/languageContext';
import Image from 'next/image';

export interface PromoSlide {
  id: string;
  title: string;
  highlight: string;
  description: string;
  ctaText: string;
  priceText: string;
  image: string;
  rating: number;
  testimonial: string;
  urgencyNote: string;
  glowColor: string;
  textColor: string;
}

export const SmartHubPromotions: React.FC = () => {
  const { theme } = useTheme();
  const { t } = useLanguage();
  const [current, setCurrent] = useState(0);
  const [direction, setDirection] = useState(0);
  const [isHovered, setIsHovered] = useState(false);
  const timerRef = useRef<NodeJS.Timeout | null>(null);

  const slides: PromoSlide[] = [
    {
      id: 'dome-hub',
      title: t('promotions.slides.dome-hub.title'),
      highlight: t('promotions.slides.dome-hub.highlight'),
      description: t('promotions.slides.dome-hub.description'),
      ctaText: t('promotions.slides.dome-hub.cta'),
      priceText: t('promotions.slides.dome-hub.price'),
      image: '/products/promo_dome_hub.png',
      rating: 4.9,
      testimonial: t('promotions.slides.dome-hub.testimonial'),
      urgencyNote: t('promotions.weeksFree'),
      glowColor: 'from-amber-500/20 via-orange-500/5 to-transparent',
      textColor: 'text-amber-500 dark:text-amber-400'
    },
    {
      id: 'climate-pro',
      title: t('promotions.slides.climate-pro.title'),
      highlight: t('promotions.slides.climate-pro.highlight'),
      description: t('promotions.slides.climate-pro.description'),
      ctaText: t('promotions.slides.climate-pro.cta'),
      priceText: t('promotions.slides.climate-pro.price'),
      image: '/products/promo_climate_pro.png',
      rating: 4.8,
      testimonial: t('promotions.slides.climate-pro.testimonial'),
      urgencyNote: t('promotions.warrantySpecial'),
      glowColor: 'from-yellow-500/20 via-amber-500/5 to-transparent',
      textColor: 'text-yellow-500 dark:text-yellow-400'
    },
    {
      id: 'cleanbot',
      title: t('promotions.slides.cleanbot.title'),
      highlight: t('promotions.slides.cleanbot.highlight'),
      description: t('promotions.slides.cleanbot.description'),
      ctaText: t('promotions.slides.cleanbot.cta'),
      priceText: t('promotions.slides.cleanbot.price'),
      image: '/products/promo_cleanbot.png',
      rating: 4.7,
      testimonial: t('promotions.slides.cleanbot.testimonial'),
      urgencyNote: t('promotions.limitedStock'),
      glowColor: 'from-emerald-500/20 via-teal-500/5 to-transparent',
      textColor: 'text-emerald-500 dark:text-emerald-400'
    },
    {
      id: 'lockgate',
      title: t('promotions.slides.lockgate.title'),
      highlight: t('promotions.slides.lockgate.highlight'),
      description: t('promotions.slides.lockgate.description'),
      ctaText: t('promotions.slides.lockgate.cta'),
      priceText: t('promotions.slides.lockgate.price'),
      image: '/products/promo_lockgate.png',
      rating: 4.9,
      testimonial: t('promotions.slides.lockgate.testimonial'),
      urgencyNote: t('promotions.discountToday'),
      glowColor: 'from-blue-500/20 via-indigo-500/5 to-transparent',
      textColor: 'text-blue-500 dark:text-blue-400'
    }
  ];

  const slideCount = slides.length;

  useEffect(() => {
    if (!isHovered) {
      timerRef.current = setInterval(() => {
        setDirection(1);
        setCurrent((prev) => (prev + 1) % slideCount);
      }, 6500);
    }
    return () => {
      if (timerRef.current) clearInterval(timerRef.current);
    };
  }, [isHovered, slideCount]);

  const handleNext = () => {
    setDirection(1);
    setCurrent((prev) => (prev + 1) % slideCount);
  };

  const handlePrev = () => {
    setDirection(-1);
    setCurrent((prev) => (prev - 1 + slideCount) % slideCount);
  };

  const handleDotClick = (index: number) => {
    setDirection(index > current ? 1 : -1);
    setCurrent(index);
  };

  const openPrivacySettings = () => {
    window.dispatchEvent(new Event('open-privacy-consent'));
  };

  // Variants for slide animation
  const slideVariants = {
    enter: (dir: number) => ({
      x: dir > 0 ? 1000 : -1000,
      opacity: 0
    }),
    center: {
      x: 0,
      opacity: 1
    },
    exit: (dir: number) => ({
      x: dir < 0 ? 1000 : -1000,
      opacity: 0
    })
  };

  const activeSlide = slides[current];

  return (
    <div 
      className="relative w-full rounded-2xl overflow-hidden shadow-2xl transition-all duration-500 border border-zinc-200/60 dark:border-zinc-900 bg-linear-to-b from-white to-zinc-50/50 dark:from-zinc-950 dark:to-black/40"
      onMouseEnter={() => setIsHovered(true)}
      onMouseLeave={() => setIsHovered(false)}
    >
      {/* Background Volumetric Light Glow */}
      <div 
        className={`absolute top-0 left-0 w-full h-full bg-gradient-radial ${activeSlide.glowColor} pointer-events-none transition-all duration-700 blur-[80px] opacity-75 z-0`}
      />

      {/* Decorative Grid Grid Overlay */}
      <div className="absolute inset-0 bg-[radial-gradient(rgba(0,0,0,0.02)_1px,transparent_1px)] dark:bg-[radial-gradient(rgba(255,255,255,0.015)_1px,transparent_1px)] [background-size:16px_16px] pointer-events-none z-0" />

      {/* Handwriting / Craftsmanship Tag (Apple standard touch) */}
      <div className="absolute top-4 right-4 z-20 transform rotate-2 bg-amber-100/90 dark:bg-amber-950/60 text-amber-800 dark:text-amber-300 font-serif text-[10px] md:text-xs px-3 py-1 rounded-md border border-amber-300/40 dark:border-amber-800/40 shadow-xs pointer-events-none select-none flex items-center gap-1 backdrop-blur-xs">
        <Sparkles size={10} className="text-amber-600 dark:text-amber-400 animate-pulse" />
        <span>{t('promotions.tag')}</span>
      </div>

      {/* Core Carousel Layout */}
      <div className="relative z-10 w-full min-h-[460px] md:min-h-[400px] flex items-center">
        <div className="w-full px-6 py-10 md:px-12 md:py-14">
          <AnimatePresence initial={false} custom={direction} mode="wait">
            <motion.div
              key={current}
              custom={direction}
              variants={slideVariants}
              initial="enter"
              animate="center"
              exit="exit"
              transition={{ x: { type: "spring", stiffness: 260, damping: 28 }, opacity: { duration: 0.3 } }}
              className="grid grid-cols-1 md:grid-cols-12 gap-8 items-center"
            >
              {/* Product Content Column */}
              <div className="col-span-1 md:col-span-7 flex flex-col gap-4 text-left">
                {/* Social Proof + Rating */}
                <div className="flex items-center gap-2 flex-wrap">
                  <div className="flex items-center text-yellow-500 dark:text-yellow-400">
                    {[...Array(5)].map((_, i) => (
                      <Star key={i} size={13} fill="currentColor" className="mr-0.5" />
                    ))}
                  </div>
                  <span className="text-xs font-semibold text-zinc-800 dark:text-zinc-300">
                    {activeSlide.rating} {t('promotions.rating')}
                  </span>
                  <span className="text-[10px] text-zinc-500 dark:text-zinc-500 border-l border-zinc-300 dark:border-zinc-800 pl-2">
                    {t('promotions.socialProof')}
                  </span>
                </div>

                {/* Headline with SVG underline brush effect */}
                <h2 className="text-2xl md:text-4xl font-extrabold tracking-tight leading-tight text-zinc-950 dark:text-white">
                  {activeSlide.title}
                  <span className={`relative inline-block ${activeSlide.textColor} font-black`}>
                    {activeSlide.highlight}
                    <svg className="absolute -bottom-1 left-0 w-full h-1.5 opacity-80" viewBox="0 0 100 10" preserveAspectRatio="none">
                      <path d="M 0,5 C 20,8 40,2 60,7 C 80,3 90,8 100,5" stroke="currentColor" strokeWidth="2.5" fill="none" strokeLinecap="round" />
                    </svg>
                  </span>
                </h2>

                {/* Subtitle / Description */}
                <p className="text-xs md:text-sm font-light text-zinc-600 dark:text-zinc-400 leading-relaxed max-w-xl">
                  {activeSlide.description}
                </p>

                {/* Price Display */}
                <div className="flex flex-col gap-0.5 mt-2">
                  <span className="text-zinc-500 dark:text-zinc-500 text-[10px] uppercase tracking-wider font-mono">{t('promotions.specialValue')}</span>
                  <span className="text-lg md:text-xl font-bold font-mono text-zinc-950 dark:text-white tracking-tight">
                    {activeSlide.priceText}
                  </span>
                </div>

                {/* Testimonial Quote */}
                <div className="mt-2 pl-3 border-l-2 border-zinc-200 dark:border-zinc-800 italic text-[11px] text-zinc-600 dark:text-zinc-400 leading-normal">
                  {activeSlide.testimonial}
                </div>

                {/* Actions & Urgency */}
                <div className="flex flex-col sm:flex-row sm:items-center gap-4 mt-4">
                  <motion.button
                    whileHover={{ scale: 1.02 }}
                    whileTap={{ scale: 0.98 }}
                    className="inline-flex items-center justify-center gap-2 px-6 py-3 rounded-lg text-xs uppercase font-mono tracking-wider font-bold bg-zinc-950 text-white dark:bg-white dark:text-black border border-transparent dark:hover:bg-transparent dark:hover:border-white dark:hover:text-white hover:bg-zinc-800 transition-all duration-300 cursor-pointer shadow-md"
                  >
                    <span>{activeSlide.ctaText}</span>
                    <ChevronRight size={14} />
                  </motion.button>

                  <div className="flex items-center gap-2 text-zinc-500 dark:text-zinc-400 text-[11px]">
                    <Clock size={12} className="text-red-500 dark:text-red-400 animate-pulse" />
                    <span className="font-medium text-red-600 dark:text-red-400">{activeSlide.urgencyNote}</span>
                  </div>
                </div>
              </div>

              {/* Product Image Column */}
              <div className="col-span-1 md:col-span-5 flex justify-center relative">
                <div className="relative w-56 h-56 md:w-72 md:h-72 flex items-center justify-center">
                  {/* Subtle decorative background circle */}
                  <div className="absolute inset-0 rounded-full bg-linear-to-tr from-zinc-100 to-zinc-50 dark:from-zinc-900/60 dark:to-zinc-950/20 border border-zinc-200/40 dark:border-zinc-800/30 shadow-inner z-0 pointer-events-none scale-105" />
                  
                  {/* Outer floating sparkles */}
                  <motion.div
                    animate={{ y: [0, -10, 0] }}
                    transition={{ duration: 4, repeat: Infinity, ease: "easeInOut" }}
                    className="absolute -top-2 left-6 z-20 text-yellow-500/80 dark:text-yellow-400/80"
                  >
                    <Sparkles size={18} />
                  </motion.div>
                  <motion.div
                    animate={{ y: [0, 8, 0] }}
                    transition={{ duration: 5, repeat: Infinity, ease: "easeInOut", delay: 1 }}
                    className="absolute bottom-4 right-4 z-20 text-zinc-400/60 dark:text-zinc-600/60"
                  >
                    <Heart size={14} className="fill-current" />
                  </motion.div>

                  {/* Main Product Image */}
                  <div className="relative w-48 h-48 md:w-60 md:h-60 rounded-xl overflow-hidden shadow-lg border border-zinc-200/30 dark:border-zinc-800/20 z-10 transition-transform duration-500 hover:scale-105">
                    <Image 
                      src={activeSlide.image} 
                      alt={activeSlide.title}
                      fill
                      priority
                      sizes="(max-width: 768px) 192px, 240px"
                      className="object-cover pointer-events-none"
                    />
                  </div>
                </div>
              </div>
            </motion.div>
          </AnimatePresence>
        </div>
      </div>

      {/* Slide Navigation Controls */}
      <div className="absolute bottom-4 right-6 left-6 z-20 flex items-center justify-between pointer-events-none">
        {/* LGPD/ANPD Compliance Badge */}
        <button
          onClick={openPrivacySettings}
          className="pointer-events-auto flex items-center gap-1.5 bg-zinc-100/90 dark:bg-zinc-950/80 hover:bg-zinc-200 dark:hover:bg-zinc-900 border border-zinc-200 dark:border-zinc-800 px-3 py-1 rounded-full text-[10px] tracking-wide text-zinc-600 dark:text-zinc-400 font-mono transition-colors cursor-pointer"
        >
          <ShieldCheck size={11} className="text-emerald-500 dark:text-emerald-400" />
          <span>{t('promotions.badge')}</span>
        </button>

        {/* Carousel controls */}
        <div className="flex items-center gap-3 pointer-events-auto">
          {/* Pagination Indicators */}
          <div className="flex gap-1.5">
            {slides.map((_, idx) => (
              <button
                key={idx}
                onClick={() => handleDotClick(idx)}
                className={`h-1.5 rounded-full transition-all duration-300 cursor-pointer ${
                  current === idx 
                    ? 'w-5 bg-zinc-800 dark:bg-white' 
                    : 'w-1.5 bg-zinc-300 hover:bg-zinc-400 dark:bg-zinc-700 dark:hover:bg-zinc-600'
                }`}
                aria-label={`Go to slide ${idx + 1}`}
              />
            ))}
          </div>

          <div className="flex gap-1">
            <button
              onClick={handlePrev}
              className="w-7 h-7 flex items-center justify-center rounded-full bg-white/60 dark:bg-zinc-950/60 border border-zinc-200 dark:border-zinc-800 text-zinc-800 dark:text-white hover:bg-zinc-100 dark:hover:bg-zinc-900 transition-colors cursor-pointer"
              aria-label="Previous slide"
            >
              <ArrowLeft size={12} />
            </button>
            <button
              onClick={handleNext}
              className="w-7 h-7 flex items-center justify-center rounded-full bg-white/60 dark:bg-zinc-950/60 border border-zinc-200 dark:border-zinc-800 text-zinc-800 dark:text-white hover:bg-zinc-100 dark:hover:bg-zinc-900 transition-colors cursor-pointer"
              aria-label="Next slide"
            >
              <ArrowRight size={12} />
            </button>
          </div>
        </div>
      </div>
    </div>
  );
};
