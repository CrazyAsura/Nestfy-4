"use client";

import React from 'react';
import { Box, Paper, IconButton, Badge, Avatar } from '@mui/material';
import HomeIcon from '@mui/icons-material/Home';
import CartIcon from '@mui/icons-material/ShoppingCart';
import SettingsInputHdmiIcon from '@mui/icons-material/SettingsInputHdmi';
import WbSunnyIcon from '@mui/icons-material/WbSunny';
import NightsStayIcon from '@mui/icons-material/NightsStay';
import LoginIcon from '@mui/icons-material/Login';
import { useTheme } from '@/lib/themeContext';
import { useAppSelector } from '@/lib/store/hooks';
import Link from 'next/link';

interface MobileDockProps {
  activeTab: number;
  setActiveTab: (tab: number) => void;
  totalQuantity: number;
  onCartClick: () => void;
}

export const MobileDock: React.FC<MobileDockProps> = ({
  activeTab,
  setActiveTab,
  totalQuantity,
  onCartClick,
}) => {
  const { theme, toggleTheme } = useTheme();
  const { isAuthenticated, user } = useAppSelector((s) => s.auth);

  return (
    <Box sx={{
      position: 'fixed',
      bottom: 20,
      left: '5%',
      right: '5%',
      zIndex: 100,
      display: 'flex',
      justifyContent: 'center',
    }}>
      <Paper sx={{
        display: 'flex',
        alignItems: 'center',
        justifyContent: 'space-around',
        width: '100%',
        maxWidth: 360,
        px: 2,
        py: 1,
        borderRadius: 4,
        background: theme === 'dark' ? 'rgba(10, 10, 15, 0.85)' : 'rgba(255, 255, 255, 0.85)',
        backdropFilter: 'blur(16px)',
        border: theme === 'dark' ? '1px solid rgba(0, 240, 255, 0.2)' : '1px solid rgba(0, 0, 0, 0.08)',
        boxShadow: theme === 'dark' 
          ? '0 8px 32px rgba(0, 0, 0, 0.5), 0 0 15px rgba(0, 240, 255, 0.1)' 
          : '0 8px 32px rgba(0, 0, 0, 0.08)',
        transition: 'all 0.3s ease-in-out',
      }} elevation={0}>
        
        {/* Tab 0: Catalog */}
        <IconButton 
          onClick={() => setActiveTab(0)}
          sx={{
            color: activeTab === 0 
              ? (theme === 'dark' ? '#00f0ff' : '#0066cc') 
              : 'text.secondary',
            bgcolor: activeTab === 0 
              ? (theme === 'dark' ? 'rgba(0, 240, 255, 0.08)' : 'rgba(0, 102, 204, 0.06)') 
              : 'transparent',
            borderRadius: 2,
            p: 1.2,
            transition: 'all 0.2s',
          }}
        >
          <HomeIcon />
        </IconButton>

        {/* Tab 1: Cart */}
        <IconButton 
          onClick={() => {
            setActiveTab(1);
            onCartClick();
          }}
          sx={{
            color: activeTab === 1 
              ? (theme === 'dark' ? '#00f0ff' : '#0066cc') 
              : 'text.secondary',
            bgcolor: activeTab === 1 
              ? (theme === 'dark' ? 'rgba(0, 240, 255, 0.08)' : 'rgba(0, 102, 204, 0.06)') 
              : 'transparent',
            borderRadius: 2,
            p: 1.2,
            transition: 'all 0.2s',
          }}
        >
          <Badge badgeContent={totalQuantity} color="primary" sx={{
            '& .MuiBadge-badge': {
              bgcolor: theme === 'dark' ? '#00f0ff' : '#0066cc',
              color: theme === 'dark' ? '#000000' : '#ffffff',
              fontWeight: 'bold',
            }
          }}>
            <CartIcon />
          </Badge>
        </IconButton>

        {/* Tab 2: Terminal */}
        <IconButton 
          onClick={() => setActiveTab(2)}
          sx={{
            color: activeTab === 2 
              ? (theme === 'dark' ? '#00f0ff' : '#0066cc') 
              : 'text.secondary',
            bgcolor: activeTab === 2 
              ? (theme === 'dark' ? 'rgba(0, 240, 255, 0.08)' : 'rgba(0, 102, 204, 0.06)') 
              : 'transparent',
            borderRadius: 2,
            p: 1.2,
            transition: 'all 0.2s',
          }}
        >
          <SettingsInputHdmiIcon />
        </IconButton>

        {/* Divider */}
        <Box sx={{
          width: '1px',
          height: 24,
          bgcolor: theme === 'dark' ? 'rgba(255, 255, 255, 0.12)' : 'rgba(0, 0, 0, 0.08)',
        }} />

        {/* Theme Toggler (Sun / Moon) */}
        <IconButton 
          onClick={toggleTheme}
          sx={{
            color: theme === 'dark' ? '#fbbf24' : '#4f46e5',
            borderRadius: 2,
            p: 1.2,
            transition: 'all 0.2s',
            '&:hover': {
              bgcolor: theme === 'dark' ? 'rgba(251, 191, 36, 0.1)' : 'rgba(79, 70, 229, 0.06)',
            }
          }}
        >
          {theme === 'dark' ? (
            <WbSunnyIcon sx={{ filter: 'drop-shadow(0 0 3px rgba(251,191,36,0.4))' }} />
          ) : (
            <NightsStayIcon />
          )}
        </IconButton>

        {/* Profile / Login Icon */}
        <Link href="/auth" style={{ textDecoration: 'none' }}>
          <IconButton
            sx={{
              color: isAuthenticated
                ? (theme === 'dark' ? '#00f0ff' : '#0066cc')
                : 'text.secondary',
              bgcolor: isAuthenticated
                ? (theme === 'dark' ? 'rgba(0, 240, 255, 0.08)' : 'rgba(0, 102, 204, 0.06)')
                : 'transparent',
              borderRadius: 2,
              p: 1.2,
              transition: 'all 0.2s',
            }}
          >
            {isAuthenticated && user ? (
              <Avatar sx={{ width: 24, height: 24, fontSize: '0.7rem', fontWeight: 800, bgcolor: theme === 'dark' ? 'rgba(0,240,255,0.15)' : 'rgba(0,102,204,0.1)', color: theme === 'dark' ? '#00f0ff' : '#0066cc' }}>
                {user.name.charAt(0).toUpperCase()}
              </Avatar>
            ) : (
              <LoginIcon />
            )}
          </IconButton>
        </Link>
      </Paper>
    </Box>
  );
};
