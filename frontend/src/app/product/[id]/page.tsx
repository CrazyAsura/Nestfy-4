"use client";

import React, { use, useState, useEffect } from 'react';
import { useAppSelector, useAppDispatch } from '@/lib/store/hooks';
import { addToCart } from '@/lib/store/cartSlice';
import { useTheme } from '@/lib/themeContext';
import { Header } from '@/components/web/Header';
import { CartDrawer } from '@/components/web/CartDrawer';
import { GlassCard } from '@/components/ui/GlassCard';
import { CyberButton } from '@/components/ui/CyberButton';
import { ProductReviews } from '@/components/web/ProductReviews';
import { ArrowLeft, Star, Cpu, Terminal, CheckCircle2, Package, Clock, ShieldCheck } from 'lucide-react';
import Link from 'next/link';

// MUI Imports for Mobile layout
import { 
  Box, 
  Container, 
  Typography, 
  Card, 
  CardContent, 
  Button, 
  IconButton, 
  Badge, 
  AppBar, 
  Toolbar, 
  Chip, 
  Stack, 
  Divider,
  ThemeProvider,
  Alert,
  Snackbar
} from '@mui/material';
import ArrowBackIcon from '@mui/icons-material/ArrowBack';
import CartIcon from '@mui/icons-material/ShoppingCart';
import CheckIcon from '@mui/icons-material/Check';
import { getMobileTheme } from '@/components/mobile/theme';
import { MobileDock } from '@/components/mobile/MobileDock';
import { MobileProductReviews } from '@/components/mobile/MobileProductReviews';

interface PageProps {
  params: Promise<{ id: string }>;
}

export default function ProductDetailPage({ params }: PageProps) {
  const { id } = use(params);
  const products = useAppSelector((state) => state.products.items);
  const { totalQuantity } = useAppSelector((state) => state.cart);
  const dispatch = useAppDispatch();
  
  const { theme } = useTheme();
  
  const [isMounted, setIsMounted] = useState(false);
  const [isCartOpen, setIsCartOpen] = useState(false);
  const [isMobileViewport, setIsMobileViewport] = useState(false);
  
  // Mobile app local state triggers
  const [mobileActiveTab, setMobileActiveTab] = useState<number>(0);
  const [toastOpen, setToastOpen] = useState(false);
  const [toastMsg, setToastMsg] = useState('');

  // Find product
  const product = products.find((p) => p.id === id);

  useEffect(() => {
    setIsMounted(true);
    
    const checkViewport = () => {
      setIsMobileViewport(window.innerWidth <= 768);
    };

    checkViewport();
    window.addEventListener('resize', checkViewport);
    return () => window.removeEventListener('resize', checkViewport);
  }, []);

  if (!isMounted) {
    return (
      <div className="flex h-screen w-screen items-center justify-center bg-black text-neon-blue font-mono text-xs tracking-widest uppercase">
        <div className="flex flex-col items-center gap-3">
          <div className="h-6 w-6 animate-spin rounded-full border-2 border-neon-blue border-t-transparent" />
          <span>Syncing Core Module...</span>
        </div>
      </div>
    );
  }

  if (!product) {
    return (
      <div className="flex min-h-screen items-center justify-center bg-background text-foreground font-mono text-xs tracking-widest uppercase flex-col gap-6">
        <Cpu size={36} className="text-red-500 animate-pulse" />
        <span>Hardware Module Not Synced to Database</span>
        <Link href="/">
          <CyberButton variant="outline">Return to Core Index</CyberButton>
        </Link>
      </div>
    );
  }

  const handleAddToCart = () => {
    dispatch(addToCart({ product }));
    if (isMobileViewport) {
      setToastMsg(`Added ${product.name} to deck!`);
      setToastOpen(true);
    } else {
      setIsCartOpen(true);
    }
  };

  // 1. MOBILE VIEW (MUI theme engine)
  if (isMobileViewport) {
    const dynamicMobileTheme = getMobileTheme(theme);
    return (
      <ThemeProvider theme={dynamicMobileTheme}>
        <Box sx={{ 
          bgcolor: 'background.default', 
          color: 'text.primary', 
          minHeight: '100vh', 
          display: 'flex', 
          flexDirection: 'column',
          pb: 12
        }}>
          {/* Top Navbar */}
          <AppBar position="sticky" sx={{ 
            bgcolor: theme === 'dark' ? '#000000' : '#ffffff', 
            borderBottom: theme === 'dark' ? '1px solid rgba(0, 240, 255, 0.15)' : '1px solid rgba(0, 0, 0, 0.08)', 
            backgroundImage: 'none',
            color: theme === 'dark' ? '#ffffff' : '#09090b'
          }}>
            <Toolbar sx={{ justifyContent: 'space-between' }}>
              <Box sx={{ display: 'flex', alignItems: 'center', gap: 1 }}>
                <Link href="/" style={{ textDecoration: 'none', color: 'inherit' }}>
                  <IconButton color="inherit" edge="start">
                    <ArrowBackIcon />
                  </IconButton>
                </Link>
                <Typography variant="h6" component="div" sx={{ fontWeight: 'black', letterSpacing: '0.1em' }}>
                  MODULE DETAILS
                </Typography>
              </Box>
              
              <IconButton onClick={() => setIsCartOpen(true)} color="inherit">
                <Badge badgeContent={totalQuantity} color="primary">
                  <CartIcon sx={{ color: totalQuantity > 0 ? (theme === 'dark' ? '#00f0ff' : '#0066cc') : 'inherit' }} />
                </Badge>
              </IconButton>
            </Toolbar>
          </AppBar>

          {/* Details Content */}
          <Container maxWidth="xs" sx={{ px: 2, pt: 3 }}>
            
            {/* Tagline */}
            <Chip 
              label={product.category} 
              size="small" 
              color="primary" 
              sx={{ 
                fontSize: '0.65rem', 
                fontWeight: 'bold', 
                letterSpacing: '0.08em', 
                mb: 1.5,
                bgcolor: theme === 'dark' ? 'rgba(0, 240, 255, 0.1)' : 'rgba(0, 102, 204, 0.08)',
                color: theme === 'dark' ? '#00f0ff' : '#0066cc',
                border: theme === 'dark' ? '1px solid rgba(0, 240, 255, 0.2)' : '1px solid rgba(0, 102, 204, 0.15)'
              }} 
            />
            
            <Typography variant="h5" sx={{ fontWeight: 'black', color: theme === 'dark' ? '#ffffff' : '#09090b', mb: 0.5 }}>
              {product.name}
            </Typography>
            <Typography variant="subtitle2" color="primary" sx={{ fontFamily: 'monospace', fontSize: '0.8rem', mb: 2.5 }}>
              {product.tagline}
            </Typography>

            {/* Visual block */}
            <Card sx={{ 
              mb: 3, 
              background: theme === 'dark' 
                ? 'linear-gradient(135deg, #050505 30%, rgba(0,240,255,0.05) 100%)' 
                : 'linear-gradient(135deg, #f8f9fa 30%, rgba(0,102,204,0.04) 100%)',
              border: theme === 'dark' ? '1px solid rgba(0,240,255,0.2)' : '1px solid rgba(0,0,0,0.08)'
            }}>
              <CardContent sx={{ py: 6, display: 'flex', flexDirection: 'column', alignItems: 'center', position: 'relative' }}>
                <Box sx={{ position: 'absolute', top: 8, left: 8, fontFamily: 'monospace', fontSize: '0.6rem', color: 'text.secondary' }}>
                  SYS_TELEMETRY: {product.id.toUpperCase()}_v9.42
                </Box>
                <Cpu style={{ fontSize: 60, color: theme === 'dark' ? 'rgba(0,240,255,0.15)' : 'rgba(0,102,204,0.1)' }} className="w-16 h-16" />
                <Typography variant="caption" sx={{ mt: 2, fontFamily: 'monospace', letterSpacing: '0.1em', color: 'text.secondary' }}>
                  MATTER PROTOCOL ONLINE
                </Typography>
              </CardContent>
            </Card>

            {/* Price & Cart button */}
            <Box sx={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', mb: 4 }}>
              <Box>
                <Typography variant="caption" color="text.secondary" sx={{ display: 'block', textTransform: 'uppercase', tracking: '0.1em' }}>
                  Sync cost
                </Typography>
                <Typography variant="h5" sx={{ fontFamily: 'monospace', fontWeight: 'bold' }}>
                  ${product.price.toLocaleString('en-US', { minimumFractionDigits: 2 })}
                </Typography>
              </Box>
              <Button 
                variant="contained" 
                color="primary" 
                onClick={handleAddToCart}
                sx={{ px: 3, py: 1 }}
              >
                Add To Deck
              </Button>
            </Box>

            {/* Description */}
            <Typography variant="subtitle2" sx={{ fontWeight: 'bold', mb: 1, textTransform: 'uppercase', letterSpacing: '0.05em' }}>
              Product Narrative
            </Typography>
            <Typography variant="body2" color="text.secondary" sx={{ mb: 4, lineHeight: 1.6, fontWeight: 'light' }}>
              {product.longDescription}
            </Typography>

            {/* Specifications Card */}
            <Typography variant="subtitle2" sx={{ fontWeight: 'bold', mb: 1.5, textTransform: 'uppercase', letterSpacing: '0.05em' }}>
              Specifications Matrix
            </Typography>
            <Card sx={{ mb: 4, bgcolor: 'background.paper', backgroundImage: 'none' }}>
              <CardContent sx={{ p: '12px !important' }}>
                <Stack spacing={1.5}>
                  {product.specs.map((spec, sidx) => (
                    <Box key={sidx} sx={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center' }}>
                      <Typography variant="caption" sx={{ fontWeight: 'bold', color: 'text.secondary', textTransform: 'uppercase' }}>
                        {spec.label}
                      </Typography>
                      <Typography variant="caption" sx={{ fontFamily: 'monospace', fontWeight: 'bold', color: 'text.primary' }}>
                        {spec.value}
                      </Typography>
                    </Box>
                  ))}
                </Stack>
              </CardContent>
            </Card>

            {/* Features check list */}
            <Typography variant="subtitle2" sx={{ fontWeight: 'bold', mb: 1.5, textTransform: 'uppercase', letterSpacing: '0.05em' }}>
              Key Integrations
            </Typography>
            <Stack spacing={1.5} sx={{ mb: 4 }}>
              {product.features.map((feat, fidx) => (
                <Box key={fidx} sx={{ display: 'flex', gap: 1.5, alignItems: 'center' }}>
                  <CheckIcon sx={{ fontSize: 16, color: theme === 'dark' ? '#00f0ff' : '#0066cc' }} />
                  <Typography variant="caption" color="text.secondary">
                    {feat}
                  </Typography>
                </Box>
              ))}
            </Stack>

            {/* Reviews Section */}
            <MobileProductReviews productId={id} />
          </Container>

          {/* Floating Mobile Dock */}
          <MobileDock 
            activeTab={mobileActiveTab}
            setActiveTab={(val) => {
              setMobileActiveTab(val);
              // Navigate back to catalog if home pressed
              if (val === 0) window.location.href = "/";
            }}
            totalQuantity={totalQuantity}
            onCartClick={() => setIsCartOpen(true)}
          />

          {/* Cart Drawer fallback for mobile */}
          <CartDrawer isOpen={isCartOpen} onClose={() => setIsCartOpen(false)} />

          {/* Toast Snackbar */}
          <Snackbar
            open={toastOpen}
            autoHideDuration={3000}
            onClose={() => setToastOpen(false)}
            anchorOrigin={{ vertical: 'bottom', horizontal: 'center' }}
          >
            <Alert onClose={() => setToastOpen(false)} severity="success" sx={{ width: '100%', bgcolor: 'background.paper', color: theme === 'dark' ? '#00f0ff' : '#0066cc', border: theme === 'dark' ? '1px solid #00f0ff' : '1px solid #0066cc' }}>
              {toastMsg}
            </Alert>
          </Snackbar>
        </Box>
      </ThemeProvider>
    );
  }

  // 2. DESKTOP VIEW (Shadcn style custom CSS)
  return (
    <div className="relative min-h-screen bg-background text-foreground transition-colors duration-300 overflow-hidden cyber-grid">
      <div className="absolute top-[-20%] left-[-10%] w-[50%] h-[50%] bg-[radial-gradient(ellipse_at_center,rgba(0,240,255,0.05),transparent_70%)] pointer-events-none" />
      <div className="absolute inset-0 scanline-effect opacity-[0.01] pointer-events-none" />

      {/* Header */}
      <Header onToggleCart={() => setIsCartOpen(!isCartOpen)} />

      <main className="mx-auto max-w-7xl px-6 py-16 relative z-10">
        
        {/* Back navigation */}
        <Link href="/" className="inline-flex items-center gap-2 text-xs uppercase font-mono tracking-widest text-zinc-500 hover:text-primary transition-colors mb-8">
          <ArrowLeft size={12} />
          Back to Core Index
        </Link>

        {/* Product Details Columns */}
        <div className="grid grid-cols-1 lg:grid-cols-12 gap-12 w-full items-start">
          
          {/* Left Column: Visual Mockup / Interface block (5 cols) */}
          <div className="lg:col-span-5 w-full">
            <GlassCard animate={false} className="border border-border">
              <div className="relative w-full h-[320px] bg-secondary/25 rounded border border-border flex flex-col items-center justify-center overflow-hidden">
                <div className="absolute inset-0 cyber-grid-dense opacity-25" />
                <div className="absolute top-0 left-0 w-full h-full bg-gradient-to-t from-background via-transparent to-transparent z-10" />
                
                {/* Tech corner notches */}
                <div className="absolute top-3 left-3 border-t border-l border-primary/40 w-6 h-6" />
                <div className="absolute top-3 right-3 border-t border-r border-primary/40 w-6 h-6" />
                <div className="absolute bottom-3 left-3 border-b border-l border-primary/40 w-6 h-6" />
                <div className="absolute bottom-3 right-3 border-b border-r border-primary/40 w-6 h-6" />
                
                <Box sx={{ position: 'absolute', top: 12, left: 40, fontFamily: 'monospace', fontSize: '8px', color: 'text.secondary' }}>
                  SYS_MODEL_ID: {product.id.toUpperCase()}_v9.42_STABLE
                </Box>
                
                <Cpu className="w-24 h-24 text-zinc-400 dark:text-zinc-800 animate-pulse mb-4 z-20" />
                
                <div className="z-20 flex items-center gap-2 border border-primary/20 bg-primary/5 px-3 py-1 rounded font-mono text-[9px] text-primary tracking-widest uppercase">
                  <Terminal size={10} />
                  Local System Connected
                </div>
              </div>
            </GlassCard>
          </div>

          {/* Right Column: Information details (7 cols) */}
          <div className="lg:col-span-7 flex flex-col gap-6">
            
            {/* Title & tags */}
            <div className="flex flex-col gap-2">
              <div className="flex items-center gap-3">
                <span className="text-[10px] tracking-widest text-primary dark:text-neon-blue uppercase border border-border dark:border-neon-blue/20 bg-primary/5 dark:bg-neon-blue/5 px-2.5 py-0.5 rounded font-black">
                  {product.category}
                </span>
                <div className="flex items-center gap-1.5 text-zinc-500 text-xs">
                  <Star size={12} className="text-yellow-500 fill-yellow-500" />
                  <span>{product.rating} (5 reviews)</span>
                </div>
              </div>
              
              <h1 className="text-3xl md:text-4xl font-black uppercase tracking-tight text-foreground">
                {product.name}
              </h1>
              
              <p className="text-sm text-primary font-mono font-medium tracking-wider">
                // {product.tagline}
              </p>
            </div>

            {/* Dynamic Price & Sync state */}
            <GlassCard animate={false} className="border border-border p-5 bg-secondary/10">
              <div className="flex justify-between items-center gap-6 flex-wrap">
                <div className="flex flex-col">
                  <span className="text-[9px] uppercase tracking-wider text-zinc-500 font-bold">Sync payload price</span>
                  <span className="text-3xl font-mono font-black text-foreground">
                    ${product.price.toLocaleString('en-US', { minimumFractionDigits: 2 })}
                  </span>
                </div>
                
                <div className="flex items-center gap-4">
                  <div className="flex items-center gap-2 text-xs text-zinc-500">
                    <Package size={14} className="text-primary" />
                    <span>In Stock ({product.stock} units)</span>
                  </div>
                  <CyberButton variant="primary" onClick={handleAddToCart} className="w-48">
                    Sync to Deck
                  </CyberButton>
                </div>
              </div>
            </GlassCard>

            {/* Descriptions */}
            <div className="flex flex-col gap-3">
              <h3 className="text-xs font-bold uppercase tracking-widest text-zinc-500 font-mono">
                System Overview
              </h3>
              <p className="text-sm text-zinc-600 dark:text-zinc-300 leading-relaxed font-light">
                {product.longDescription}
              </p>
            </div>

            {/* Specs Grid */}
            <div className="flex flex-col gap-3">
              <h3 className="text-xs font-bold uppercase tracking-widest text-zinc-500 font-mono">
                Hardware Specs Matrix
              </h3>
              <div className="grid grid-cols-1 md:grid-cols-2 gap-4 bg-secondary/35 p-5 rounded-lg border border-border">
                {product.specs.map((spec, sidx) => (
                  <div key={sidx} className="flex justify-between items-center py-2 border-b border-border/60 text-xs">
                    <span className="uppercase text-zinc-500 font-bold text-[10px] tracking-wider">{spec.label}</span>
                    <span className="font-mono text-foreground font-semibold">{spec.value}</span>
                  </div>
                ))}
              </div>
            </div>

            {/* Key Integrations features check list */}
            <div className="flex flex-col gap-3">
              <h3 className="text-xs font-bold uppercase tracking-widest text-zinc-500 font-mono">
                Core System Integrations
              </h3>
              <div className="grid grid-cols-1 md:grid-cols-2 gap-3 text-xs text-zinc-600 dark:text-zinc-400">
                {product.features.map((feat, fidx) => (
                  <div key={fidx} className="flex items-center gap-2.5">
                    <CheckCircle2 size={14} className="text-primary" />
                    <span>{feat}</span>
                  </div>
                ))}
              </div>
            </div>

            {/* Reviews Section */}
            <ProductReviews productId={id} />

          </div>

        </div>

      </main>

      {/* Cart Drawer */}
      <CartDrawer isOpen={isCartOpen} onClose={() => setIsCartOpen(false)} />

      {/* Footer */}
      <footer className="border-t border-border bg-background/50 py-12 relative z-10 text-center text-xs tracking-wider text-zinc-500 font-mono uppercase flex flex-col gap-4">
        <div className="flex justify-center gap-6 flex-wrap text-[10px]">
          <Link href="/about" className="hover:text-primary transition-colors">About Us</Link>
          <Link href="/faq" className="hover:text-primary transition-colors">FAQ</Link>
          <Link href="/privacy" className="hover:text-primary transition-colors">Privacy Policy</Link>
          <Link href="/cookies" className="hover:text-primary transition-colors">Cookies Policy</Link>
          <Link href="/terms" className="hover:text-primary transition-colors">Terms of Use</Link>
        </div>
        <p className="text-[10px] text-zinc-700">© 2026 Nestfy Tech Home. dynamic_product_telemetry_indexed.</p>
      </footer>
    </div>
  );
}
