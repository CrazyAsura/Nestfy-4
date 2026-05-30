"use client";

import React, { useState } from 'react';
import { useAppSelector, useAppDispatch } from '@/lib/store/hooks';
import { removeFromCart, updateQuantity, clearCart } from '@/lib/store/cartSlice';
import { X, Trash2, Plus, Minus, CreditCard, QrCode, Terminal, CheckCircle2 } from 'lucide-react';
import { motion, AnimatePresence } from 'framer-motion';
import { CyberButton } from '../ui/CyberButton';
import { useLanguage } from '@/lib/languageContext';

interface CartDrawerProps {
  isOpen: boolean;
  onClose: () => void;
}

type CheckoutStep = 'cart' | 'payment' | 'success';
type PaymentMethod = 'card' | 'pix';

export const CartDrawer: React.FC<CartDrawerProps> = ({ isOpen, onClose }) => {
  const { items, totalAmount } = useAppSelector((state) => state.cart);
  const dispatch = useAppDispatch();
  const { t, formatPrice } = useLanguage();
  
  const [step, setStep] = useState<CheckoutStep>('cart');
  const [paymentMethod, setPaymentMethod] = useState<PaymentMethod>('card');
  const [cardNumber, setCardNumber] = useState('');
  const [cardName, setCardName] = useState('');
  const [cardExpiry, setCardExpiry] = useState('');
  const [cardCvv, setCardCvv] = useState('');
  const [isCopied, setIsCopied] = useState(false);

  const handleUpdateQty = (productId: string, currentQty: number, change: number) => {
    const nextQty = currentQty + change;
    if (nextQty > 0) {
      dispatch(updateQuantity({ productId, quantity: nextQty }));
    }
  };

  const handleRemove = (productId: string) => {
    dispatch(removeFromCart(productId));
  };

  const handleCopyPix = () => {
    navigator.clipboard.writeText("00020126580014BR.GOV.BCB.PIX0136nestfy-transaction-key-92847294852040000");
    setIsCopied(true);
    setTimeout(() => setIsCopied(false), 2000);
  };

  const handleCheckoutSubmit = (e: React.FormEvent) => {
    e.preventDefault();
    setStep('success');
    setTimeout(() => {
      dispatch(clearCart());
    }, 100);
  };

  const getLocalizedProduct = (prod: any) => {
    const id = prod.id;
    const name = t(`products.${id}.name`);
    const tagline = t(`products.${id}.tagline`);
    return {
      ...prod,
      name: name !== `products.${id}.name` ? name : prod.name,
      tagline: tagline !== `products.${id}.tagline` ? tagline : prod.tagline,
    };
  };

  return (
    <AnimatePresence>
      {isOpen && (
        <>
          {/* Backdrop */}
          <motion.div
            initial={{ opacity: 0 }}
            animate={{ opacity: 0.6 }}
            exit={{ opacity: 0 }}
            onClick={onClose}
            className="fixed inset-0 z-50 bg-black/90 backdrop-blur-sm cursor-pointer"
          />

          {/* Drawer Panel */}
          <motion.div
            initial={{ x: '100%' }}
            animate={{ x: 0 }}
            exit={{ x: '100%' }}
            transition={{ type: 'spring', damping: 25, stiffness: 200 }}
            className="fixed top-0 right-0 z-50 h-full w-full max-w-md border-l border-neon-blue/20 bg-black p-6 flex flex-col justify-between shadow-[0_0_50px_rgba(0,0,0,0.9)]"
          >
            {/* Header */}
            <div className="flex items-center justify-between pb-4 border-b border-zinc-900 mb-6">
              <div className="flex items-center gap-2">
                <Terminal size={16} className="text-neon-blue neon-text-glow" />
                <h2 className="text-lg font-bold tracking-widest uppercase text-white font-mono">
                  {step === 'cart' && t('products.operationsDeck')}
                  {step === 'payment' && t('products.encryptionPort')}
                  {step === 'success' && t('products.uplinkSynced')}
                </h2>
              </div>
              <button 
                onClick={onClose}
                className="text-zinc-500 hover:text-white transition-colors cursor-pointer"
              >
                <X size={20} />
              </button>
            </div>

            {/* Content Body */}
            <div className="flex-1 overflow-y-auto pr-2">
              <AnimatePresence mode="wait">
                {/* STEP 1: CART LIST */}
                {step === 'cart' && (
                  <motion.div
                    key="cart-list"
                    initial={{ opacity: 0, x: 20 }}
                    animate={{ opacity: 1, x: 0 }}
                    exit={{ opacity: 0, x: -20 }}
                    className="flex flex-col gap-4 h-full"
                  >
                    {items.length === 0 ? (
                      <div className="flex flex-col items-center justify-center h-64 text-center">
                        <Terminal size={40} className="text-zinc-800 mb-4" />
                        <p className="text-sm text-zinc-500 uppercase tracking-widest font-mono">{t('products.tacticalInventory')}</p>
                      </div>
                    ) : (
                      items.map((item) => {
                        const lProd = getLocalizedProduct(item.product);
                        return (
                          <div 
                            key={item.product.id}
                            className="flex gap-4 p-4 rounded border border-zinc-900 bg-zinc-950/50 hover:border-zinc-800 transition-colors"
                          >
                            <div className="flex-1 flex flex-col justify-between">
                              <div>
                                <h4 className="text-sm font-bold uppercase tracking-wider text-white truncate">{lProd.name}</h4>
                                <p className="text-[10px] text-zinc-500 font-mono mt-0.5">{lProd.tagline}</p>
                              </div>
                              <div className="flex items-center gap-3 mt-3">
                                <button 
                                  onClick={() => handleUpdateQty(item.product.id, item.quantity, -1)}
                                  className="h-6 w-6 flex items-center justify-center rounded border border-zinc-800 bg-zinc-900 hover:border-neon-blue hover:text-neon-blue transition-colors cursor-pointer"
                                >
                                  <Minus size={10} />
                                </button>
                                <span className="text-xs font-mono text-white">{item.quantity}</span>
                                <button 
                                  onClick={() => handleUpdateQty(item.product.id, item.quantity, 1)}
                                  className="h-6 w-6 flex items-center justify-center rounded border border-zinc-800 bg-zinc-900 hover:border-neon-blue hover:text-neon-blue transition-colors cursor-pointer"
                                >
                                  <Plus size={10} />
                                </button>
                              </div>
                            </div>
                            
                            <div className="flex flex-col items-end justify-between">
                              <button 
                                onClick={() => handleRemove(item.product.id)}
                                className="text-zinc-600 hover:text-red-500 transition-colors cursor-pointer"
                              >
                                <Trash2 size={14} />
                              </button>
                              <span className="text-sm font-mono text-zinc-300">
                                {formatPrice(item.product.price * item.quantity)}
                              </span>
                            </div>
                          </div>
                        );
                      })
                    )}
                  </motion.div>
                )}

                {/* STEP 2: CHECKOUT / PAYMENT FORM */}
                {step === 'payment' && (
                  <motion.div
                    key="payment-port"
                    initial={{ opacity: 0, x: 20 }}
                    animate={{ opacity: 1, x: 0 }}
                    exit={{ opacity: 0, x: -20 }}
                    className="flex flex-col gap-6"
                  >
                    {/* Method Tabs */}
                    <div className="grid grid-cols-2 gap-3">
                      <button
                        type="button"
                        onClick={() => setPaymentMethod('card')}
                        className={`flex items-center justify-center gap-2 py-3 rounded border text-xs tracking-wider uppercase font-mono transition-all duration-300 ${
                          paymentMethod === 'card'
                            ? 'bg-neon-blue/15 border-neon-blue text-neon-blue shadow-[0_0_10px_rgba(0,240,255,0.2)]'
                            : 'bg-zinc-950 border-zinc-900 text-zinc-500'
                        }`}
                      >
                        <CreditCard size={14} />
                        {t('products.paymentCard')}
                      </button>
                      <button
                        type="button"
                        onClick={() => setPaymentMethod('pix')}
                        className={`flex items-center justify-center gap-2 py-3 rounded border text-xs tracking-wider uppercase font-mono transition-all duration-300 ${
                          paymentMethod === 'pix'
                            ? 'bg-neon-blue/15 border-neon-blue text-neon-blue shadow-[0_0_10px_rgba(0,240,255,0.2)]'
                            : 'bg-zinc-950 border-zinc-900 text-zinc-500'
                        }`}
                      >
                        <QrCode size={14} />
                        {t('products.paymentPix')}
                      </button>
                    </div>

                    {paymentMethod === 'card' ? (
                      <form onSubmit={handleCheckoutSubmit} className="flex flex-col gap-4">
                        {/* Virtual Card Preview */}
                        <div className="relative h-44 rounded-lg bg-gradient-to-br from-zinc-900 via-black to-zinc-950 border border-neon-blue/35 p-6 flex flex-col justify-between overflow-hidden shadow-[0_0_15px_rgba(0,240,255,0.1)]">
                          <div className="absolute inset-0 cyber-grid-dense opacity-10 pointer-events-none" />
                          <div className="flex justify-between items-start">
                            <span className="text-[10px] tracking-widest text-zinc-600 font-mono font-bold">NESTFY CORE CARD</span>
                            <div className="w-8 h-6 bg-zinc-800 rounded opacity-60" />
                          </div>
                          
                          <div className="text-base font-mono text-zinc-300 tracking-[0.2em] my-4 truncate">
                            {cardNumber || '•••• •••• •••• ••••'}
                          </div>
                          
                          <div className="flex justify-between items-end">
                            <div>
                              <span className="text-[8px] text-zinc-600 block uppercase tracking-wider">Hologram Holder</span>
                              <span className="text-xs font-mono text-zinc-400 truncate block max-w-[200px]">
                                {cardName || 'YOUR SIGNATURE'}
                              </span>
                            </div>
                            <div>
                              <span className="text-[8px] text-zinc-600 block uppercase tracking-wider">EXP</span>
                              <span className="text-xs font-mono text-zinc-400">
                                {cardExpiry || 'MM/YY'}
                              </span>
                            </div>
                          </div>
                        </div>

                        {/* Input Fields */}
                        <div className="flex flex-col gap-3">
                          <input
                            type="text"
                            placeholder={t('products.cardNumber')}
                            value={cardNumber}
                            onChange={(e) => setCardNumber(e.target.value.replace(/\D/g, '').slice(0, 16))}
                            required
                            className="w-full bg-zinc-950 border border-zinc-900 rounded p-2.5 text-xs text-white placeholder-zinc-700 focus:border-neon-blue focus:outline-none transition-colors"
                          />
                          <input
                            type="text"
                            placeholder={t('products.cardHolder')}
                            value={cardName}
                            onChange={(e) => setCardName(e.target.value.toUpperCase())}
                            required
                            className="w-full bg-zinc-950 border border-zinc-900 rounded p-2.5 text-xs text-white placeholder-zinc-700 focus:border-neon-blue focus:outline-none transition-colors"
                          />
                          <div className="grid grid-cols-2 gap-3">
                            <input
                              type="text"
                              placeholder="MM/YY"
                              value={cardExpiry}
                              onChange={(e) => setCardExpiry(e.target.value.slice(0, 5))}
                              required
                              className="w-full bg-zinc-950 border border-zinc-900 rounded p-2.5 text-xs text-white placeholder-zinc-700 focus:border-neon-blue focus:outline-none transition-colors"
                            />
                            <input
                              type="password"
                              placeholder={t('products.cardCvv')}
                              value={cardCvv}
                              onChange={(e) => setCardCvv(e.target.value.replace(/\D/g, '').slice(0, 3))}
                              required
                              className="w-full bg-zinc-950 border border-zinc-900 rounded p-2.5 text-xs text-white placeholder-zinc-700 focus:border-neon-blue focus:outline-none transition-colors"
                            />
                          </div>
                        </div>

                        <CyberButton type="submit" variant="primary" className="mt-4">
                          {t('products.authorizeDeck')}
                        </CyberButton>
                      </form>
                    ) : (
                      <div className="flex flex-col items-center gap-4 text-center p-4 bg-zinc-950/40 rounded border border-zinc-900">
                        <div className="p-3 bg-neon-blue/5 rounded border border-neon-blue/20">
                          {/* Simulated Glowing QR Code */}
                          <div className="w-40 h-40 bg-zinc-900 relative rounded flex items-center justify-center p-2 border border-neon-blue shadow-[0_0_15px_rgba(0,240,255,0.25)]">
                            <div className="absolute inset-0 bg-[linear-gradient(to_bottom,rgba(0,240,255,0)_40%,rgba(0,240,255,0.4)_50%,rgba(0,240,255,0)_60%)] bg-[size:100%_20px] animate-[scanline_2s_infinite_linear]" />
                            <QrCode className="w-32 h-32 text-neon-blue opacity-85" />
                          </div>
                        </div>
                        
                        <div>
                          <h4 className="text-xs uppercase tracking-wider text-white font-mono font-bold">Tactical QR-Port</h4>
                          <p className="text-[10px] text-zinc-500 mt-1 max-w-xs leading-relaxed">
                            {t('products.pixScan')}
                          </p>
                        </div>
                        
                        <div className="w-full flex items-center justify-between gap-3 bg-black p-2.5 border border-zinc-900 rounded">
                          <span className="text-[10px] font-mono text-zinc-400 truncate max-w-[220px]">
                            nestfy-transaction-key-92847294852040000
                          </span>
                          <button
                            type="button"
                            onClick={handleCopyPix}
                            className="text-[10px] uppercase font-mono tracking-widest text-neon-blue hover:text-white transition-colors cursor-pointer"
                          >
                            {isCopied ? t('products.copied') : t('products.copy')}
                          </button>
                        </div>

                        <CyberButton 
                          type="button" 
                          onClick={() => setStep('success')} 
                          variant="primary" 
                          className="w-full mt-2"
                        >
                          {t('products.verifyTrans')}
                        </CyberButton>
                      </div>
                    )}
                  </motion.div>
                )}

                {/* STEP 3: SUCCESS PANEL */}
                {step === 'success' && (
                  <motion.div
                    key="success-screen"
                    initial={{ opacity: 0, scale: 0.95 }}
                    animate={{ opacity: 1, scale: 1 }}
                    exit={{ opacity: 0, scale: 0.95 }}
                    className="flex flex-col items-center justify-center text-center h-full gap-5 py-12"
                  >
                    <motion.div
                      animate={{ scale: [1, 1.15, 1] }}
                      transition={{ duration: 0.6 }}
                    >
                      <CheckCircle2 className="w-16 h-16 text-neon-blue neon-text-glow" />
                    </motion.div>
                    
                    <div>
                      <h3 className="text-lg font-bold tracking-widest uppercase text-white font-mono">{t('products.uplinkSynced')}</h3>
                      <p className="text-xs text-zinc-400 mt-2 max-w-xs leading-relaxed font-light font-mono">
                        {t('products.securedUplink')}
                      </p>
                    </div>

                    <div className="w-full bg-zinc-950 border border-zinc-900 p-4 rounded font-mono text-left text-[10px] text-zinc-500">
                      <div className="flex justify-between">
                        <span>TRANSACTION_ID:</span>
                        <span className="text-zinc-300">NST-7492-BF</span>
                      </div>
                      <div className="flex justify-between mt-1">
                        <span>NODE_HASH:</span>
                        <span className="text-zinc-300 truncate max-w-[150px]">0x38af9c...a28e</span>
                      </div>
                      <div className="flex justify-between mt-1">
                        <span>STATUS:</span>
                        <span className="text-neon-blue">UPLINK_SUCCESS</span>
                      </div>
                    </div>

                    <CyberButton
                      onClick={() => {
                        setStep('cart');
                        onClose();
                      }}
                      variant="outline"
                      className="w-full mt-4"
                    >
                      {t('products.returnStore')}
                    </CyberButton>
                  </motion.div>
                )}
              </AnimatePresence>
            </div>

            {/* Bottom Subtotal Panel (Only visible on Step 1 when items exist) */}
            {step === 'cart' && items.length > 0 && (
              <div className="pt-4 border-t border-zinc-900 mt-6 flex flex-col gap-4">
                <div className="flex justify-between items-end font-mono">
                  <span className="text-xs text-zinc-500 uppercase tracking-widest">{t('products.totalValue')}</span>
                  <span className="text-lg font-black text-white">
                    {formatPrice(totalAmount)}
                  </span>
                </div>
                
                <div className="grid grid-cols-2 gap-3">
                  <CyberButton
                    onClick={() => dispatch(clearCart())}
                    variant="secondary"
                    className="flex gap-2 items-center justify-center font-mono"
                  >
                    <Trash2 size={13} />
                    {t('products.clearCart')}
                  </CyberButton>
                  <CyberButton
                    onClick={() => setStep('payment')}
                    variant="primary"
                    className="font-semibold"
                  >
                    {t('products.initUplink')}
                  </CyberButton>
                </div>
              </div>
            )}
          </motion.div>
        </>
      )}
    </AnimatePresence>
  );
};
