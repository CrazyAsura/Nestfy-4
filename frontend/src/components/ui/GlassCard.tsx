"use client";

import React from 'react';
import { motion } from 'framer-motion';
import { cn } from '@/lib/utils';

interface GlassCardProps extends React.HTMLAttributes<HTMLDivElement> {
  children: React.ReactNode;
  glow?: boolean;
  hoverGlow?: boolean;
  animate?: boolean;
  delay?: number;
}

export const GlassCard: React.FC<GlassCardProps> = ({
  children,
  className,
  glow = false,
  hoverGlow = true,
  animate = true,
  delay = 0,
  ...props
}) => {
  const cardContent = (
    <div
      className={cn(
        "glassmorphism relative rounded-lg overflow-hidden transition-all duration-300",
        glow && "neon-glow border-neon-blue",
        hoverGlow && "neon-glow-hover",
        className
      )}
      {...props}
    >
      {/* Sci-fi corner decorations */}
      <div className="absolute top-0 left-0 w-2 h-2 border-t border-l border-neon-blue/40" />
      <div className="absolute top-0 right-0 w-2 h-2 border-t border-r border-neon-blue/40" />
      <div className="absolute bottom-0 left-0 w-2 h-2 border-b border-l border-neon-blue/40" />
      <div className="absolute bottom-0 right-0 w-2 h-2 border-b border-r border-neon-blue/40" />
      
      {/* Decorative scanline backdrop */}
      <div className="absolute inset-0 bg-[radial-gradient(ellipse_at_center,rgba(0,240,255,0.02),transparent_60%)] pointer-events-none" />
      
      <div className="relative z-10 p-6 h-full flex flex-col">
        {children}
      </div>
    </div>
  );

  if (!animate) return cardContent;

  return (
    <motion.div
      initial={{ opacity: 0, y: 15 }}
      animate={{ opacity: 1, y: 0 }}
      transition={{ duration: 0.5, delay, ease: [0.16, 1, 0.3, 1] }}
      whileHover={hoverGlow ? { y: -4, scale: 1.01 } : undefined}
    >
      {cardContent}
    </motion.div>
  );
};
