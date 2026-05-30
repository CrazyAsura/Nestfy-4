"use client";

import React, { useState } from 'react';
import { Header } from '@/components/web/Header';
import { GlassCard } from '@/components/ui/GlassCard';
import { motion, AnimatePresence } from 'framer-motion';
import { Plus, Minus, ArrowLeft, Terminal } from 'lucide-react';
import Link from 'next/link';

interface FAQItem {
  question: string;
  answer: string;
}

const faqData: FAQItem[] = [
  {
    question: "Do Nestfy devices require an active internet connection?",
    answer: "No. The Nestfy ecosystem is built on local-first principles. Devices, voice triggers, and schedules are handled entirely inside the Dome Hub locally in your house, ensuring complete operation even during internet outages."
  },
  {
    question: "How does the offline voice command engine work?",
    answer: "The Dome Hub features an integrated low-power neural co-processor. When you command a device via voice, speech-to-text models parse the soundwaves directly on the device memory. No audio records are uploaded to cloud servers."
  },
  {
    question: "Is Nestfy compatible with existing Matter/Thread setups?",
    answer: "Yes, fully. Nestfy Dome Hub acts as a certified Matter Controller and Thread Border Router. You can connect third-party smart bulbs, thermostats, or plugs that support the Matter standard directly to the local network."
  },
  {
    question: "How does facial recognition work on the LockGate Pro lock?",
    answer: "The LockGate Pro uses structured 3D infrared light sensors (similar to FaceID) to scan facial depth features. The computed biometric math model is stored in the lock's local encrypted storage chip. No physical face images are stored or shared."
  },
  {
    question: "Can I connect to my smart home when I am away from home?",
    answer: "Yes. By establishing an encrypted P2P tunnel (using WireGuard or standard secure ports) directly between your mobile phone and the Dome Hub, you can control your house remotely without relying on public cloud databases."
  }
];

export default function FAQPage() {
  const [openIndex, setOpenIndex] = useState<number | null>(null);

  const toggleFAQ = (idx: number) => {
    setOpenIndex(openIndex === idx ? null : idx);
  };

  return (
    <div className="relative min-h-screen bg-background text-foreground transition-colors duration-300 overflow-hidden cyber-grid">
      <div className="absolute top-[-20%] left-[-10%] w-[50%] h-[50%] bg-[radial-gradient(ellipse_at_center,rgba(0,240,255,0.05),transparent_70%)] pointer-events-none" />
      <div className="absolute inset-0 scanline-effect opacity-[0.01] pointer-events-none" />

      <Header onToggleCart={() => {}} />

      <main className="mx-auto max-w-3xl px-6 py-16 relative z-10">
        
        {/* Back Link */}
        <Link href="/" className="inline-flex items-center gap-2 text-xs uppercase font-mono tracking-widest text-zinc-500 hover:text-neon-blue transition-colors mb-8">
          <ArrowLeft size={12} />
          Back to Core
        </Link>

        {/* Title */}
        <div className="flex flex-col gap-4 mb-12 text-center md:text-left">
          <span className="text-[10px] tracking-widest text-neon-blue uppercase border border-neon-blue/20 bg-neon-blue/5 px-2.5 py-0.5 rounded font-black w-fit self-center md:self-start">
            SYS_KNOWLEDGE_DECK
          </span>
          <h1 className="text-3xl md:text-4xl font-black uppercase tracking-tight">
            Frequently Asked <span className="text-transparent bg-clip-text bg-gradient-to-r from-white via-neon-blue to-white neon-text-glow">Questions</span>
          </h1>
          <p className="text-sm text-zinc-400 font-light leading-relaxed max-w-xl">
            Review detailed hardware specifications and system core capabilities.
          </p>
        </div>

        {/* Accordions */}
        <div className="flex flex-col gap-4">
          {faqData.map((item, idx) => {
            const isOpen = openIndex === idx;
            return (
              <GlassCard 
                key={idx}
                animate={false} 
                className="p-0 border border-zinc-900 bg-zinc-950/20 hover:border-zinc-800 overflow-hidden"
              >
                {/* Question trigger */}
                <button
                  onClick={() => toggleFAQ(idx)}
                  className="w-full flex justify-between items-center p-5 text-left font-mono text-xs uppercase tracking-wider text-white hover:text-neon-blue transition-colors cursor-pointer"
                >
                  <span className="flex items-center gap-3">
                    <Terminal size={14} className={isOpen ? "text-neon-blue neon-text-glow" : "text-zinc-600"} />
                    {item.question}
                  </span>
                  {isOpen ? (
                    <Minus size={14} className="text-neon-blue" />
                  ) : (
                    <Plus size={14} className="text-zinc-500" />
                  )}
                </button>

                {/* Animated Answer container */}
                <AnimatePresence initial={false}>
                  {isOpen && (
                    <motion.div
                      initial={{ height: 0, opacity: 0 }}
                      animate={{ height: 'auto', opacity: 1 }}
                      exit={{ height: 0, opacity: 0 }}
                      transition={{ duration: 0.3, ease: 'easeInOut' }}
                      className="border-t border-zinc-950 bg-black/60"
                    >
                      <div className="p-5 text-xs text-zinc-400 font-light leading-relaxed">
                        {item.answer}
                      </div>
                    </motion.div>
                  )}
                </AnimatePresence>
              </GlassCard>
            );
          })}
        </div>

      </main>

      {/* Footer */}
      <footer className="border-t border-zinc-950 py-8 text-center text-[10px] tracking-widest text-zinc-700 uppercase font-mono mt-16">
        NESTFY SYSTEMS © 2026. UPLINK_KNOWLEDGE_OK.
      </footer>
    </div>
  );
}
