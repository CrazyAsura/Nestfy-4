"use client";

import React from 'react';
import { useAppSelector } from '@/lib/store/hooks';
import { ShoppingCart, Cpu, Search, User, HelpCircle, Smartphone } from 'lucide-react';
import { motion } from 'framer-motion';
import Link from 'next/link';
import { useSearch } from '@/lib/searchContext';

interface HeaderProps {
  onToggleCart: () => void;
}

export const Header: React.FC<HeaderProps> = ({
  onToggleCart,
}) => {
  const { openSearch } = useSearch();
  const { totalQuantity } = useAppSelector((state) => state.cart);


  return (
    <header className="sticky top-0 z-40 w-full border-b border-border bg-background/80 backdrop-blur-md transition-colors duration-300">
      <div className="mx-auto flex h-20 max-w-7xl items-center justify-between px-6 md:px-8">
        
        {/* Brand Logo */}
        <Link href="/" className="flex items-center gap-3">
          <motion.div
            animate={{ rotate: [0, 10, -10, 0] }}
            transition={{ duration: 6, repeat: Infinity, ease: "easeInOut" }}
            className="flex h-10 w-10 items-center justify-center rounded border border-neon-blue bg-neon-blue/10 text-neon-blue dark:shadow-[0_0_10px_rgba(0,240,255,0.3)]"
          >
            <Cpu size={22} className="neon-text-glow" />
          </motion.div>
          
          <span className="text-xl font-bold tracking-[0.25em] text-foreground uppercase neon-text-glow">
            Nest<span className="text-neon-blue font-extrabold">fy</span>
          </span>
        </Link>
 
        {/* Desktop Nav Links */}
        <nav className="hidden md:flex items-center gap-8 text-sm uppercase tracking-widest text-zinc-500 dark:text-zinc-400 font-medium">
          <Link href="/category/central-hubs" className="hover:text-foreground transition-colors pb-1">
            Smart Hub
          </Link>
          <Link href="/" className="hover:text-foreground transition-colors pb-1">
            Category
          </Link>
          <Link href="/about" className="hover:text-foreground transition-colors pb-1">
            About
          </Link>
          <Link href="/faq" className="hover:text-foreground transition-colors pb-1">
            FAQ
          </Link>
        </nav>

        {/* Action Buttons */}
        <div className="flex items-center gap-5">
          {/* Search Icon */}
          <button 
            onClick={openSearch}
            className="text-zinc-400 hover:text-neon-blue transition-colors cursor-pointer"
          >
            <Search size={20} />
          </button>

          {/* User Icon */}
          <button className="text-zinc-400 hover:text-neon-blue transition-colors cursor-pointer">
            <User size={20} />
          </button>

          {/* Cart Icon */}
          <button 
            onClick={onToggleCart}
            className="relative text-zinc-400 hover:text-neon-blue transition-colors cursor-pointer"
          >
            <ShoppingCart size={20} className={totalQuantity > 0 ? "text-neon-blue neon-text-glow" : ""} />
            {totalQuantity > 0 && (
              <motion.span
                initial={{ scale: 0 }}
                animate={{ scale: 1 }}
                className="absolute -top-2 -right-2 flex h-4.5 w-4.5 items-center justify-center rounded-full bg-neon-blue text-[9px] font-black text-black shadow-[0_0_8px_#00f0ff]"
              >
                {totalQuantity}
              </motion.span>
            )}
          </button>
        </div>
      </div>
    </header>
  );
};
