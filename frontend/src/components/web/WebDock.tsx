"use client";

import React from 'react';
import { useTheme } from '@/lib/themeContext';
import { useAppSelector } from '@/lib/store/hooks';
import { motion } from 'framer-motion';
import { Home, Info, HelpCircle, Shield, Cookie, FileText, Sun, Moon, User, LogIn, Search } from 'lucide-react';
import Link from 'next/link';
import { usePathname } from 'next/navigation';
import { useSearch } from '@/lib/searchContext';

export const WebDock: React.FC = () => {
  const { theme, toggleTheme } = useTheme();
  const { isAuthenticated, user } = useAppSelector((s) => s.auth);
  const { openSearch } = useSearch();
  const pathname = usePathname();

  const dockItems = [
    { name: 'Catalog', icon: Home, href: '/' },
    { name: 'About', icon: Info, href: '/about' },
    { name: 'FAQ', icon: HelpCircle, href: '/faq' },
    { name: 'Privacy', icon: Shield, href: '/privacy' },
    { name: 'Cookies', icon: Cookie, href: '/cookies' },
    { name: 'Terms', icon: FileText, href: '/terms' },
  ];


  return (
    <div className="fixed bottom-6 left-1/2 -translate-x-1/2 z-40 hidden md:block">
      <motion.div
        initial={{ y: 80, opacity: 0 }}
        animate={{ y: 0, opacity: 1 }}
        transition={{ type: 'spring', stiffness: 260, damping: 20 }}
        className="flex items-center gap-3 px-4 py-3 rounded-2xl glassmorphism border border-zinc-200/10 dark:border-neon-blue/20 shadow-[0_10px_30px_rgba(0,0,0,0.5)] dark:shadow-[0_0_30px_rgba(0,240,255,0.1)] relative backdrop-blur-xl"
      >
        {/* Dock Items */}
        <div className="flex items-center gap-2">
          {dockItems.map((item) => {
            const Icon = item.icon;
            const isActive = pathname === item.href;
            return (
              <Link key={item.name} href={item.href} className="relative group">
                <motion.div
                  whileHover={{ scale: 1.22, y: -8 }}
                  whileTap={{ scale: 0.95 }}
                  transition={{ type: 'spring', stiffness: 400, damping: 15 }}
                  className={`flex h-11 w-11 items-center justify-center rounded-xl border transition-colors cursor-pointer ${
                    isActive
                      ? 'border-neon-blue bg-neon-blue/10 text-neon-blue dark:shadow-[0_0_10px_rgba(0,240,255,0.3)]'
                      : 'border-zinc-200/10 dark:border-zinc-800 bg-zinc-100/5 dark:bg-black/40 text-zinc-500 hover:text-foreground hover:border-zinc-400 dark:hover:border-neon-blue/60'
                  }`}
                >
                  <Icon size={18} />
                </motion.div>
                
                {/* Tooltip */}
                <span className="absolute -top-10 left-1/2 -translate-x-1/2 px-2.5 py-1 rounded bg-black border border-zinc-800 text-[10px] uppercase font-mono tracking-widest text-white opacity-0 pointer-events-none group-hover:opacity-100 transition-opacity duration-200 shadow-md">
                  {item.name}
                </span>
              </Link>
            );
          })}
        </div>

        {/* Search Button */}
        <button
          onClick={openSearch}
          className="relative group flex h-11 w-11 items-center justify-center rounded-xl border border-zinc-200/10 dark:border-zinc-800 bg-zinc-100/5 dark:bg-black/40 text-zinc-500 hover:text-neon-blue hover:border-neon-blue dark:hover:border-neon-blue/60 transition-all cursor-pointer"
        >
          <Search size={18} />
          {/* Tooltip */}
          <span className="absolute -top-10 left-1/2 -translate-x-1/2 px-2.5 py-1 rounded bg-black border border-zinc-800 text-[10px] uppercase font-mono tracking-widest text-white opacity-0 pointer-events-none group-hover:opacity-100 transition-opacity duration-200 shadow-md whitespace-nowrap">
            Search
          </span>
        </button>

        {/* Separator Divider */}
        <div className="h-6 w-px bg-zinc-200/20 dark:bg-zinc-800/80 mx-1" />

        {/* Theme Controller (Sun / Moon) */}
        <button
          onClick={toggleTheme}
          className="relative group flex h-11 w-11 items-center justify-center rounded-xl border border-zinc-200/10 dark:border-zinc-800 bg-zinc-100/5 dark:bg-black/40 text-zinc-500 hover:text-neon-blue hover:border-neon-blue dark:hover:border-neon-blue/60 transition-all cursor-pointer overflow-hidden"
          title="Toggle Theme"
        >
          <motion.div
            key={theme}
            initial={{ y: 20, rotate: 45, opacity: 0 }}
            animate={{ y: 0, rotate: 0, opacity: 1 }}
            exit={{ y: -20, rotate: -45, opacity: 0 }}
            transition={{ type: 'spring', stiffness: 300, damping: 18 }}
          >
            {theme === 'dark' ? (
              <Sun size={18} className="text-amber-400 filter drop-shadow-[0_0_4px_rgba(251,191,36,0.5)]" />
            ) : (
              <Moon size={18} className="text-indigo-600" />
            )}
          </motion.div>

          {/* Tooltip */}
          <span className="absolute -top-10 left-1/2 -translate-x-1/2 px-2.5 py-1 rounded bg-black border border-zinc-800 text-[10px] uppercase font-mono tracking-widest text-white opacity-0 pointer-events-none group-hover:opacity-100 transition-opacity duration-200 shadow-md whitespace-nowrap">
            {theme === 'dark' ? 'Light Mode' : 'Dark Mode'}
          </span>
        </button>

        {/* Separator Divider */}
        <div className="h-6 w-px bg-zinc-200/20 dark:bg-zinc-800/80 mx-1" />

        {/* Auth Profile / Login Icon */}
        <Link href={isAuthenticated ? '/auth' : '/auth'} className="relative group">
          <motion.div
            whileHover={{ scale: 1.22, y: -8 }}
            whileTap={{ scale: 0.95 }}
            transition={{ type: 'spring', stiffness: 400, damping: 15 }}
            className={`flex h-11 w-11 items-center justify-center rounded-xl border transition-colors cursor-pointer ${
              isAuthenticated
                ? 'border-neon-blue bg-neon-blue/10 text-neon-blue dark:shadow-[0_0_10px_rgba(0,240,255,0.3)]'
                : 'border-zinc-200/10 dark:border-zinc-800 bg-zinc-100/5 dark:bg-black/40 text-zinc-500 hover:text-foreground hover:border-zinc-400 dark:hover:border-neon-blue/60'
            }`}
          >
            {isAuthenticated && user ? (
              <span className="text-xs font-black">{user.name.charAt(0).toUpperCase()}</span>
            ) : (
              <LogIn size={18} />
            )}
          </motion.div>
          <span className="absolute -top-10 left-1/2 -translate-x-1/2 px-2.5 py-1 rounded bg-black border border-zinc-800 text-[10px] uppercase font-mono tracking-widest text-white opacity-0 pointer-events-none group-hover:opacity-100 transition-opacity duration-200 shadow-md whitespace-nowrap">
            {isAuthenticated ? 'Profile' : 'Sign In'}
          </span>
        </Link>
      </motion.div>
    </div>
  );
};
