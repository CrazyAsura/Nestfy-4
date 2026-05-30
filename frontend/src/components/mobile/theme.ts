"use client";

import { createTheme } from '@mui/material/styles';

export const getMobileTheme = (mode: 'light' | 'dark') => {
  return createTheme({
    palette: {
      mode,
      primary: {
        main: mode === 'dark' ? '#00f0ff' : '#0066cc', // Neon Blue for Dark, Deep Cobalt for Light
        contrastText: mode === 'dark' ? '#000000' : '#ffffff',
      },
      secondary: {
        main: mode === 'dark' ? '#ffffff' : '#09090b',
        contrastText: mode === 'dark' ? '#000000' : '#ffffff',
      },
      background: {
        default: mode === 'dark' ? '#000000' : '#ffffff',
        paper: mode === 'dark' ? '#09090b' : '#f8f9fa',
      },
      text: {
        primary: mode === 'dark' ? '#ffffff' : '#09090b',
        secondary: mode === 'dark' ? '#a1a1aa' : '#71717a',
      },
      divider: mode === 'dark' ? 'rgba(0, 240, 255, 0.15)' : 'rgba(0, 0, 0, 0.08)',
    },
    typography: {
      fontFamily: 'var(--font-sans), Roboto, Helvetica, Arial, sans-serif',
      h1: {
        fontWeight: 800,
        letterSpacing: '0.1em',
      },
      h6: {
        fontWeight: 700,
        letterSpacing: '0.15em',
        fontSize: '1rem',
        textTransform: 'uppercase',
      },
      button: {
        textTransform: 'uppercase',
        letterSpacing: '0.1em',
        fontWeight: 700,
      },
    },
    components: {
      MuiButton: {
        styleOverrides: {
          root: {
            borderRadius: 4,
            padding: '8px 16px',
            transition: 'all 0.3s cubic-bezier(0.16, 1, 0.3, 1)',
            '&:hover': {
              boxShadow: mode === 'dark' 
                ? '0 0 12px rgba(0, 240, 255, 0.4)' 
                : '0 4px 12px rgba(0, 102, 204, 0.2)',
            },
          },
        },
        variants: [
          {
            props: { variant: 'contained', color: 'primary' },
            style: {
              backgroundColor: mode === 'dark' ? '#ffffff' : '#0066cc',
              color: mode === 'dark' ? '#000000' : '#ffffff',
              border: mode === 'dark' ? '1px solid #ffffff' : '1px solid #0066cc',
              '&:hover': {
                backgroundColor: 'transparent',
                color: mode === 'dark' ? '#ffffff' : '#0066cc',
                borderColor: mode === 'dark' ? '#00f0ff' : '#0066cc',
              },
            },
          },
          {
            props: { variant: 'outlined', color: 'primary' },
            style: {
              borderColor: mode === 'dark' ? 'rgba(0, 240, 255, 0.4)' : 'rgba(0, 102, 204, 0.4)',
              color: mode === 'dark' ? '#00f0ff' : '#0066cc',
              '&:hover': {
                borderColor: mode === 'dark' ? '#00f0ff' : '#0066cc',
                backgroundColor: mode === 'dark' ? 'rgba(0, 240, 255, 0.08)' : 'rgba(0, 102, 204, 0.08)',
              },
            },
          },
        ],
      },
      MuiCard: {
        styleOverrides: {
          root: {
            backgroundColor: mode === 'dark' ? 'rgba(10, 10, 15, 0.75)' : 'rgba(255, 255, 255, 0.8)',
            backdropFilter: 'blur(16px)',
            border: mode === 'dark' ? '1px solid rgba(0, 240, 255, 0.15)' : '1px solid rgba(0, 0, 0, 0.08)',
            borderRadius: 8,
            transition: 'all 0.3s cubic-bezier(0.16, 1, 0.3, 1)',
            '&:hover': {
              borderColor: mode === 'dark' ? '#00f0ff' : '#0066cc',
              boxShadow: mode === 'dark' 
                ? '0 0 15px rgba(0, 240, 255, 0.25)' 
                : '0 4px 20px rgba(0, 102, 204, 0.15)',
            },
          },
        },
      },
      MuiBottomNavigation: {
        styleOverrides: {
          root: {
            backgroundColor: mode === 'dark' ? '#000000' : '#ffffff',
            borderTop: mode === 'dark' ? '1px solid rgba(0, 240, 255, 0.15)' : '1px solid rgba(0, 0, 0, 0.08)',
          },
        },
      },
      MuiBottomNavigationAction: {
        styleOverrides: {
          root: {
            color: mode === 'dark' ? '#a1a1aa' : '#71717a',
            '&.Mui-selected': {
              color: mode === 'dark' ? '#00f0ff' : '#0066cc',
            },
          },
        },
      },
      MuiTextField: {
        styleOverrides: {
          root: {
            '& .MuiOutlinedInput-root': {
              '& fieldset': {
                borderColor: mode === 'dark' ? 'rgba(255, 255, 255, 0.15)' : 'rgba(0, 0, 0, 0.12)',
              },
              '&:hover fieldset': {
                borderColor: mode === 'dark' ? 'rgba(0, 240, 255, 0.4)' : 'rgba(0, 102, 204, 0.4)',
              },
              '&.Mui-focused fieldset': {
                borderColor: mode === 'dark' ? '#00f0ff' : '#0066cc',
              },
            },
          },
        },
      },
    },
  });
};
