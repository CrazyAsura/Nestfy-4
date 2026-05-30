"use client";

import React from 'react';
import { motion } from 'framer-motion';
import { cn } from '@/lib/utils';

interface CyberButtonProps extends Omit<React.ButtonHTMLAttributes<HTMLButtonElement>, 'onDrag' | 'onDragStart' | 'onDragEnd' | 'onAnimationStart' | 'style'> {
  children: React.ReactNode;
  variant?: 'primary' | 'secondary' | 'outline' | 'ghost';
  glow?: boolean;
}

export const CyberButton: React.FC<CyberButtonProps> = ({
  children,
  className,
  variant = 'primary',
  glow = true,
  ...props
}) => {
  const getVariantStyles = () => {
    switch (variant) {
      case 'primary':
        return 'bg-white text-black font-semibold border border-white hover:bg-transparent hover:text-white';
      case 'secondary':
        return 'bg-zinc-900 text-white font-medium border border-zinc-800 hover:border-neon-blue hover:text-neon-blue';
      case 'outline':
        return 'bg-transparent text-white font-medium border border-neon-blue/40 hover:border-neon-blue hover:bg-neon-blue/10';
      case 'ghost':
        return 'bg-transparent text-zinc-400 hover:text-white';
      default:
        return 'bg-white text-black';
    }
  };

  return (
    <motion.button
      whileTap={{ scale: 0.96 }}
      whileHover={{ scale: 1.02 }}
      transition={{ type: 'spring', stiffness: 400, damping: 15 }}
      className={cn(
        "relative px-6 py-2.5 rounded text-sm tracking-widest uppercase transition-all duration-300 overflow-hidden cursor-pointer",
        getVariantStyles(),
        variant === 'outline' && glow && "shadow-[0_0_10px_rgba(0,240,255,0.15)] hover:shadow-[0_0_18px_rgba(0,240,255,0.35)]",
        variant === 'primary' && "shadow-[0_0_8px_rgba(255,255,255,0.1)]",
        className
      )}
      {...props}
    >
      {/* Laser slide hover overlay for primary */}
      {variant === 'primary' && (
        <span className="absolute inset-0 w-full h-full bg-gradient-to-r from-transparent via-neon-blue/30 to-transparent -translate-x-full hover:animate-[shimmer_1.5s_infinite] pointer-events-none" />
      )}
      
      {/* Neon corner notch for secondary/outline */}
      {(variant === 'secondary' || variant === 'outline') && (
        <div className="absolute top-0 right-0 w-1.5 h-1.5 bg-neon-blue rounded-bl-sm opacity-60" />
      )}

      <span className="relative z-10 flex items-center justify-center gap-2">
        {children}
      </span>
    </motion.button>
  );
};
