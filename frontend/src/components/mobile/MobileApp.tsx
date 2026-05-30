"use client";

import React, { useState } from 'react';
import { ThemeProvider } from '@mui/material/styles';
import { 
  Box, 
  Container, 
  Typography, 
  Card, 
  CardContent, 
  Button, 
  IconButton, 
  Badge, 
  BottomNavigation, 
  BottomNavigationAction, 
  AppBar, 
  Toolbar, 
  Chip, 
  Stack, 
  TextField, 
  Divider,
  Alert,
  Snackbar
} from '@mui/material';
import HomeIcon from '@mui/icons-material/Home';
import CartIcon from '@mui/icons-material/ShoppingCart';
import AddIcon from '@mui/icons-material/Add';
import RemoveIcon from '@mui/icons-material/Remove';
import DeleteForeverIcon from '@mui/icons-material/DeleteForever';
import QrCodeIcon from '@mui/icons-material/QrCode';
import CreditCardIcon from '@mui/icons-material/CreditCard';
import CheckCircleIcon from '@mui/icons-material/CheckCircle';
import CopyAllIcon from '@mui/icons-material/CopyAll';
import SettingsInputHdmiIcon from '@mui/icons-material/SettingsInputHdmi';
import TerminalIcon from '@mui/icons-material/Terminal';
import SearchIcon from '@mui/icons-material/Search';

import { useAppSelector, useAppDispatch } from '@/lib/store/hooks';
import { addToCart, removeFromCart, updateQuantity, clearCart } from '@/lib/store/cartSlice';
import { Product } from '@/lib/store/productSlice';
import { getMobileTheme } from './theme';
import { useTheme } from '@/lib/themeContext';
import { useSearch } from '@/lib/searchContext';
import { MobileDock } from './MobileDock';
import { SmartHubPromotions } from '../web/SmartHubPromotions';
import { LanguageSwitcher } from '../web/LanguageSwitcher';
import { useLanguage } from '@/lib/languageContext';
import { translations } from '@/lib/i18n/translations';
import { motion } from 'framer-motion';


export const MobileApp: React.FC = () => {
  const { openSearch } = useSearch();
  const { theme } = useTheme();
  const { t, formatPrice, language } = useLanguage();
  const dynamicTheme = React.useMemo(() => getMobileTheme(theme), [theme]);
  const products = useAppSelector((state) => state.products.items);
  const { items: cartItems, totalAmount, totalQuantity } = useAppSelector((state) => state.cart);
  const dispatch = useAppDispatch();

  const getLocalizedProduct = (prod: Product) => {
    const id = prod.id;
    const name = t(`products.${id}.name`);
    const tagline = t(`products.${id}.tagline`);
    const description = t(`products.${id}.description`);

    // Localized features array check
    let features = prod.features;
    const langDict: any = translations[language];
    if (langDict && langDict.products && langDict.products[id] && Array.isArray(langDict.products[id].features)) {
      features = langDict.products[id].features;
    }

    return {
      ...prod,
      name: name !== `products.${id}.name` ? name : prod.name,
      tagline: tagline !== `products.${id}.tagline` ? tagline : prod.tagline,
      description: description !== `products.${id}.description` ? description : prod.description,
      features,
    } as Product;
  };

  const [activeTab, setActiveTab] = useState<number>(0);
  const [selectedCategory, setSelectedCategory] = useState<string>('All');
  const [checkoutStep, setCheckoutStep] = useState<'cart' | 'payment' | 'success'>('cart');
  const [paymentMethod, setPaymentMethod] = useState<'card' | 'pix'>('card');
  const [toastOpen, setToastOpen] = useState(false);
  const [toastMsg, setToastMsg] = useState('');

  const categories = ['All', ...Array.from(new Set(products.map((p) => p.category)))];

  const filteredProducts = selectedCategory === 'All'
    ? products
    : products.filter((p) => p.category === selectedCategory);

  const showToast = (msg: string) => {
    setToastMsg(msg);
    setToastOpen(true);
  };

  const handleAddToCart = (product: any) => {
    dispatch(addToCart({ product }));
    showToast(`Added ${product.name} to deck!`);
  };

  const handleUpdateQty = (productId: string, currentQty: number, change: number) => {
    const nextQty = currentQty + change;
    if (nextQty > 0) {
      dispatch(updateQuantity({ productId, quantity: nextQty }));
    }
  };

  const handleCopyPix = () => {
    navigator.clipboard.writeText("00020126580014BR.GOV.BCB.PIX0136nestfy-transaction-key-92847294852040000");
    showToast("PIX Key copied to clipboard.");
  };

  return (
    <ThemeProvider theme={dynamicTheme}>
      <Box sx={{ 
        bgcolor: 'background.default', 
        color: 'text.primary', 
        minHeight: '100vh', 
        display: 'flex', 
        flexDirection: 'column',
        position: 'relative'
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
              <Box sx={{ 
                width: 8, 
                height: 8, 
                bgcolor: theme === 'dark' ? '#00f0ff' : '#0066cc', 
                borderRadius: '50%', 
                boxShadow: theme === 'dark' ? '0 0 8px #00f0ff' : 'none' 
              }} />
              <Typography variant="h6" component="div" sx={{ 
                fontWeight: 'black', 
                color: theme === 'dark' ? '#ffffff' : '#09090b' 
              }}>
                NESTFY <span style={{ color: theme === 'dark' ? '#00f0ff' : '#0066cc' }}>M_OS</span>
              </Typography>
            </Box>
            
            <Box sx={{ display: 'flex', gap: 0.5, alignItems: 'center' }}>
              <LanguageSwitcher />

              <IconButton onClick={openSearch} color="inherit">
                <SearchIcon />
              </IconButton>
              
              <IconButton onClick={() => { setActiveTab(1); setCheckoutStep('cart'); }} color="inherit">
                <Badge badgeContent={totalQuantity} color="primary" sx={{
                  '& .MuiBadge-badge': {
                    bgcolor: theme === 'dark' ? '#00f0ff' : '#0066cc',
                    color: theme === 'dark' ? '#000000' : '#ffffff',
                  }
                }}>
                  <CartIcon sx={{ color: totalQuantity > 0 ? (theme === 'dark' ? '#00f0ff' : '#0066cc') : 'inherit' }} />
                </Badge>
              </IconButton>
            </Box>
          </Toolbar>
        </AppBar>

        {/* Content Body */}
        <Box sx={{ flexGrow: 1, overflowY: 'auto', pb: 9, pt: 2 }}>
          <Container maxWidth="xs" sx={{ px: 2 }}>
            
            {/* VIEW 0: HOME / CATALOG */}
            {activeTab === 0 && (
              <Box>
                {/* Hero Promotions Carousel Banner */}
                <Box sx={{ mb: 3 }}>
                  <SmartHubPromotions />
                </Box>

                {/* Categories Carousel (Scrollable chips) */}
                <Stack direction="row" spacing={1} sx={{ overflowX: 'auto', mb: 3, pb: 1, '&::-webkit-scrollbar': { display: 'none' } }}>
                  {categories.map((cat) => (
                    <Chip
                      key={cat}
                      label={cat === 'All' ? t('products.categoryAll') : cat}
                      onClick={() => setSelectedCategory(cat)}
                      variant={selectedCategory === cat ? 'filled' : 'outlined'}
                      color={selectedCategory === cat ? 'primary' : 'default'}
                      sx={{ 
                        fontSize: '0.75rem', 
                        textTransform: 'uppercase', 
                        fontWeight: 'bold',
                        letterSpacing: '0.05em',
                        borderColor: selectedCategory === cat ? '#00f0ff' : 'rgba(255, 255, 255, 0.15)'
                      }}
                    />
                  ))}
                </Stack>

                {/* Product List */}
                <Stack spacing={2.5}>
                  {filteredProducts.map((prod) => {
                    const lProd = getLocalizedProduct(prod);
                    return (
                      <Card key={prod.id}>
                        <CardContent>
                          <Box sx={{ display: 'flex', justifyContent: 'space-between', alignItems: 'flex-start' }}>
                            <Typography variant="caption" sx={{ color: '#00f0ff', fontWeight: 'bold', letterSpacing: '0.1em' }}>
                              {lProd.category}
                            </Typography>
                            <Typography variant="caption" sx={{ fontFamily: 'monospace', color: 'text.secondary' }}>
                              ID: {lProd.id.toUpperCase()}
                            </Typography>
                          </Box>
                          
                          <Typography variant="h6" sx={{ color: '#ffffff', fontWeight: 'bold', mt: 1, mb: 0.5 }}>
                            {lProd.name}
                          </Typography>
                          
                          <Typography variant="body2" color="text.secondary" sx={{ fontSize: '0.85rem', mb: 2 }}>
                            {lProd.description}
                          </Typography>
                          
                          <Box sx={{ display: 'flex', flexWrap: 'wrap', gap: 0.5, mb: 2 }}>
                            {lProd.features.slice(0, 2).map((feat, fidx) => (
                              <Chip 
                                key={fidx} 
                                label={feat} 
                                size="small" 
                                sx={{ fontSize: '0.65rem', bgcolor: 'rgba(255,255,255,0.04)', color: 'text.secondary' }} 
                              />
                            ))}
                          </Box>
                          
                          <Divider sx={{ my: 1.5 }} />
                          
                          <Box sx={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center' }}>
                            <Typography variant="h6" sx={{ fontFamily: 'monospace', fontWeight: 'bold', fontSize: '1.1rem' }}>
                              {formatPrice(lProd.price)}
                            </Typography>
                            <Button 
                              variant="outlined" 
                              color="primary"
                              size="small"
                              onClick={() => handleAddToCart(prod)}
                            >
                              {t('products.addToCart')}
                            </Button>
                          </Box>
                        </CardContent>
                      </Card>
                    );
                  })}
                </Stack>
              </Box>
            )}

            {/* VIEW 1: CART & CHECKOUT */}
            {activeTab === 1 && (
              <Box>
                {checkoutStep === 'cart' && (
                  <Box>
                    <Typography variant="h6" sx={{ mb: 2, fontWeight: 'bold' }}>
                      {t('products.selectedDeck')} ({cartItems.length})
                    </Typography>
                    
                    {cartItems.length === 0 ? (
                      <Box sx={{ textCenter: 'center', py: 8, display: 'flex', flexDirection: 'column', alignItems: 'center' }}>
                        <TerminalIcon sx={{ fontSize: 40, color: 'rgba(255,255,255,0.1)', mb: 2 }} />
                        <Typography variant="body2" color="text.secondary">
                          {t('products.tacticalEmpty')}
                        </Typography>
                        <Button 
                          variant="outlined" 
                          color="primary" 
                          sx={{ mt: 3 }}
                          onClick={() => setActiveTab(0)}
                        >
                          {t('products.exploreGear')}
                        </Button>
                      </Box>
                    ) : (
                      <Stack spacing={2}>
                        {cartItems.map((item) => (
                          <Card key={item.product.id} sx={{ bgcolor: 'rgba(255,255,255,0.02)' }}>
                            <CardContent sx={{ p: '16px !important' }}>
                              <Box sx={{ display: 'flex', justifyContent: 'space-between' }}>
                                <Typography variant="subtitle2" sx={{ fontWeight: 'bold', textTransform: 'uppercase' }}>
                                  {getLocalizedProduct(item.product).name}
                                </Typography>
                                <IconButton 
                                  size="small" 
                                  color="error" 
                                  onClick={() => {
                                    dispatch(removeFromCart(item.product.id));
                                    showToast("Removed item.");
                                  }}
                                >
                                  <DeleteForeverIcon sx={{ fontSize: 18 }} />
                                </IconButton>
                              </Box>
                              
                              <Box sx={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', mt: 2 }}>
                                <Box sx={{ display: 'flex', gap: 1.5, alignItems: 'center' }}>
                                  <IconButton 
                                    size="small" 
                                    onClick={() => handleUpdateQty(item.product.id, item.quantity, -1)}
                                    sx={{ border: '1px solid rgba(255,255,255,0.1)', p: 0.5 }}
                                  >
                                    <RemoveIcon sx={{ fontSize: 16 }} />
                                  </IconButton>
                                  <Typography variant="body2" sx={{ fontFamily: 'monospace' }}>
                                    {item.quantity}
                                  </Typography>
                                  <IconButton 
                                    size="small" 
                                    onClick={() => handleUpdateQty(item.product.id, item.quantity, 1)}
                                    sx={{ border: '1px solid rgba(255,255,255,0.1)', p: 0.5 }}
                                  >
                                    <AddIcon sx={{ fontSize: 16 }} />
                                  </IconButton>
                                </Box>
                                
                                <Typography variant="subtitle1" sx={{ fontFamily: 'monospace', fontWeight: 'bold' }}>
                                  {formatPrice(item.product.price * item.quantity)}
                                </Typography>
                              </Box>
                            </CardContent>
                          </Card>
                        ))}
                        
                        <Divider sx={{ my: 1 }} />
                        
                        <Box sx={{ display: 'flex', justifyContent: 'space-between', alignItems: 'flex-end', my: 1 }}>
                          <Typography variant="body2" color="text.secondary">{t('products.totalValue')}</Typography>
                          <Typography variant="h5" sx={{ fontFamily: 'monospace', fontWeight: 'black', color: '#00f0ff' }}>
                            {formatPrice(totalAmount)}
                          </Typography>
                        </Box>
                        
                        <Button 
                          variant="contained" 
                          color="primary" 
                          fullWidth 
                          onClick={() => setCheckoutStep('payment')}
                          sx={{ py: 1.5, mt: 2 }}
                        >
                          {t('products.initUplink')}
                        </Button>
                      </Stack>
                    )}
                  </Box>
                )}

                {checkoutStep === 'payment' && (
                  <Box>
                    <Typography variant="h6" sx={{ mb: 2, fontWeight: 'bold' }}>
                      Encryption Port
                    </Typography>
                    
                    <Stack direction="row" spacing={1.5} sx={{ mb: 3 }}>
                      <Button
                        variant={paymentMethod === 'card' ? 'contained' : 'outlined'}
                        color="primary"
                        onClick={() => setPaymentMethod('card')}
                        fullWidth
                        startIcon={<CreditCardIcon />}
                        sx={{ fontSize: '0.75rem' }}
                      >
                        Card
                      </Button>
                      <Button
                        variant={paymentMethod === 'pix' ? 'contained' : 'outlined'}
                        color="primary"
                        onClick={() => setPaymentMethod('pix')}
                        fullWidth
                        startIcon={<QrCodeIcon />}
                        sx={{ fontSize: '0.75rem' }}
                      >
                        PIX
                      </Button>
                    </Stack>

                    {paymentMethod === 'card' ? (
                      <Box component="form" onSubmit={(e) => { e.preventDefault(); setCheckoutStep('success'); dispatch(clearCart()); }} sx={{ display: 'flex', flexDirection: 'column', gap: 2 }}>
                        <TextField label="Card Number" variant="outlined" size="small" fullWidth required />
                        <TextField label="Holder Name" variant="outlined" size="small" fullWidth required />
                        <Stack direction="row" spacing={2}>
                          <TextField label="Expiry Date" placeholder="MM/YY" variant="outlined" size="small" fullWidth required />
                          <TextField label="CVV" type="password" variant="outlined" size="small" fullWidth required />
                        </Stack>
                        
                        <Button variant="contained" color="primary" type="submit" sx={{ py: 1.5, mt: 2 }}>
                          Authorize Deck
                        </Button>
                      </Box>
                    ) : (
                      <Box sx={{ display: 'flex', flexDirection: 'column', alignItems: 'center', gap: 2, textAlign: 'center' }}>
                        <Box sx={{ p: 2, bgcolor: 'rgba(0,240,255,0.05)', borderRadius: 2, border: '1px solid rgba(0, 240, 255, 0.25)', boxShadow: '0 0 10px rgba(0,240,255,0.1)' }}>
                          <QrCodeIcon sx={{ fontSize: 130, color: '#00f0ff' }} />
                        </Box>
                        
                        <Typography variant="caption" color="text.secondary" sx={{ maxW: '240px' }}>
                          Scan the code in your digital banking app. Transactions expire in 5 minutes.
                        </Typography>
                        
                        <Button 
                          variant="outlined" 
                          color="primary" 
                          size="small" 
                          onClick={handleCopyPix}
                          startIcon={<CopyAllIcon />}
                          sx={{ textTransform: 'none' }}
                        >
                          Copy PIX Key
                        </Button>
                        
                        <Button 
                          variant="contained" 
                          color="primary" 
                          fullWidth 
                          onClick={() => { setCheckoutStep('success'); dispatch(clearCart()); }}
                          sx={{ py: 1.5, mt: 2 }}
                        >
                          Verify Transaction
                        </Button>
                      </Box>
                    )}
                  </Box>
                )}

                {checkoutStep === 'success' && (
                  <Box sx={{ textAlign: 'center', py: 4 }}>
                    <motion.div
                      animate={{ scale: [1, 1.15, 1] }}
                      transition={{ duration: 0.6 }}
                    >
                      <CheckCircleIcon sx={{ fontSize: 60, color: '#00f0ff', mb: 2, filter: 'drop-shadow(0 0 8px #00f0ff)' }} />
                    </motion.div>
                    <Typography variant="h6" sx={{ fontWeight: 'bold', mb: 1 }}>
                      TRANSACTION SECURED
                    </Typography>
                    <Typography variant="body2" color="text.secondary" sx={{ mb: 4, px: 2 }}>
                      Your tech uplink has been established. Delivery teleportation scheduled.
                    </Typography>
                    
                    <Button 
                      variant="outlined" 
                      color="primary" 
                      onClick={() => { setCheckoutStep('cart'); setActiveTab(0); }}
                      fullWidth
                    >
                      Return to Store
                    </Button>
                  </Box>
                )}
              </Box>
            )}

            {/* VIEW 2: TERMINAL / SYSTEM STATS */}
            {activeTab === 2 && (
              <Box>
                <Typography variant="h6" sx={{ mb: 2, fontWeight: 'bold' }}>
                  Diagnostics Console
                </Typography>
                
                <Stack spacing={2}>
                  <Card sx={{ bgcolor: '#050505', border: '1px solid rgba(0,240,255,0.1)' }}>
                    <CardContent sx={{ fontFamily: 'monospace', fontSize: '0.75rem', color: '#00f0ff' }}>
                      <Box sx={{ display: 'flex', justifyContent: 'space-between', mb: 1 }}>
                        <span>SYSTEM CORE:</span>
                        <span style={{ color: '#ffffff' }}>NESTFY_MAIN_API</span>
                      </Box>
                      <Box sx={{ display: 'flex', justifyContent: 'space-between', mb: 1 }}>
                        <span>CONNECTION URL:</span>
                        <span style={{ color: '#ffffff' }}>localhost:8080</span>
                      </Box>
                      <Box sx={{ display: 'flex', justifyContent: 'space-between', mb: 1 }}>
                        <span>HEALTH STATUS:</span>
                        <span style={{ color: '#38bdf8' }}>ONLINE_STABLE</span>
                      </Box>
                      <Box sx={{ display: 'flex', justifyContent: 'space-between', mb: 1 }}>
                        <span>ENCRYPTION STATE:</span>
                        <span style={{ color: '#10b981' }}>AES_256_ACTIVE</span>
                      </Box>
                    </CardContent>
                  </Card>
                  
                  <Card sx={{ bgcolor: '#050505', border: '1px solid rgba(0,240,255,0.1)' }}>
                    <CardContent sx={{ fontFamily: 'monospace', fontSize: '0.75rem', color: '#00f0ff' }}>
                      <Typography variant="caption" sx={{ color: 'text.secondary', display: 'block', mb: 1, fontWeight: 'bold' }}>
                        CONTAINER_TELEMETRY
                      </Typography>
                      <Box sx={{ display: 'flex', justifyContent: 'space-between', mb: 0.5 }}>
                        <span>POSTGRESQL 17:</span>
                        <span style={{ color: '#10b981' }}>OK (Synced)</span>
                      </Box>
                      <Box sx={{ display: 'flex', justifyContent: 'space-between', mb: 0.5 }}>
                        <span>REDIS 7 CACHE:</span>
                        <span style={{ color: '#10b981' }}>OK (Active)</span>
                      </Box>
                      <Box sx={{ display: 'flex', justifyContent: 'space-between', mb: 0.5 }}>
                        <span>KAFKA KRaft:</span>
                        <span style={{ color: '#10b981' }}>OK (1 Node)</span>
                      </Box>
                    </CardContent>
                  </Card>
                  
                  <Typography variant="caption" color="text.secondary" sx={{ px: 1 }}>
                    Nestfy 3-Tier Clean System. React 19 / Material-UI 6 integration sandbox.
                  </Typography>
                </Stack>
              </Box>
            )}

          </Container>
        </Box>

        {/* Floating Mobile Dock */}
        <MobileDock
          activeTab={activeTab}
          setActiveTab={setActiveTab}
          totalQuantity={totalQuantity}
          onCartClick={() => setCheckoutStep('cart')}
        />

        {/* Toast Snackbar */}
        <Snackbar
          open={toastOpen}
          autoHideDuration={3000}
          onClose={() => setToastOpen(false)}
          anchorOrigin={{ vertical: 'bottom', horizontal: 'center' }}
        >
          <Alert onClose={() => setToastOpen(false)} severity="success" sx={{ width: '100%', bgcolor: 'background.paper', color: '#00f0ff', border: '1px solid #00f0ff' }}>
            {toastMsg}
          </Alert>
        </Snackbar>

      </Box>
    </ThemeProvider>
  );
};
