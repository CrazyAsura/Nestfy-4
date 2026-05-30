import type { Metadata } from "next";
import { Geist, Geist_Mono } from "next/font/google";
import "./globals.css";
import { Providers } from "@/components/Providers";

const geistSans = Geist({
  variable: "--font-geist-sans",
  subsets: ["latin"],
});

const geistMono = Geist_Mono({
  variable: "--font-geist-mono",
  subsets: ["latin"],
});

export const metadata: Metadata = {
  title: "Nestfy | Technological Store",
  description: "Futuristic sci-fi technological storefront featuring quantum computers, cyberwear, and bio-hacking implants.",
};

import { CookieConsent } from "@/components/ui/CookieConsent";
import { WebDock } from "@/components/web/WebDock";

export default function RootLayout({
  children,
}: Readonly<{
  children: React.ReactNode;
}>) {
  return (
    <html
      lang="en"
      className={`${geistSans.variable} ${geistMono.variable} h-full antialiased`}
    >
      <body className="min-h-full flex flex-col">
        <Providers>
          {children}
          <CookieConsent />
          <WebDock />
        </Providers>
      </body>
    </html>
  );
}

