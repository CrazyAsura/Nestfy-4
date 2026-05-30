"use client";

import React from 'react';
import { Header } from '@/components/web/Header';
import { GlassCard } from '@/components/ui/GlassCard';
import { ArrowLeft, Cookie, Info } from 'lucide-react';
import Link from 'next/link';
import { useLanguage } from '@/lib/languageContext';

const content = {
  en: {
    backToCore: 'Back to Core',
    registry: 'SYS_COOKIE_REGISTRY',
    title: 'Cookies & Cache',
    highlight: 'Policy',
    desc: 'Detailed registry of storage block metrics and local cache expirations.',
    cardTitle: 'Dynamic Cache Strategy',
    cardText: 'Our PWA storefront uses client-side cache and cookies to manage your navigation states, prevent loading delays, and secure your encrypted checkout payloads. You can configure performance and analytics caches at any time via the deck launcher in the bottom right corner.',
    thBlock: 'Cookie Block',
    thCategory: 'Category',
    thPurpose: 'Purpose',
    thExpiration: 'Expiration',
    rowCartPurpose: 'Stores active cart arrays, items, and quantities for purchase.',
    rowConsentPurpose: 'Stores your customized cookie consent preferences.',
    rowThemePurpose: 'Caches page layout layouts and dark theme selectors to avoid styling flashes.',
    rowTelemetryPurpose: 'Anonymously tracks scrolling speeds and categories filtered to optimize load operations.',
    catRequired: 'REQUIRED',
    catPerformance: 'PERFORMANCE',
    catAnalytics: 'ANALYTICS',
    exp30: '30 Days',
    exp365: '365 Days',
    expPersistent: 'Persistent',
    expSession: 'Session',
    bottomNote: 'Matter protocol devices in your home do not read or communicate with browser storefront cookies.',
    footer: 'NESTFY SYSTEMS © 2026. COOKIE_INDEX_OK.'
  },
  pt: {
    backToCore: 'Voltar ao Painel',
    registry: 'REGISTRO_DE_COOKIES_SISTEMA',
    title: 'Política de',
    highlight: 'Cookies & Cache',
    desc: 'Registro detalhado das métricas dos blocos de armazenamento e expiração de cache local.',
    cardTitle: 'Estratégia de Cache Dinâmico',
    cardText: 'Nossa loja PWA utiliza cookies e cache do lado do cliente para gerenciar seus estados de navegação, evitar atrasos de carregamento e proteger suas cargas de checkout criptografadas. Você pode configurar cookies de desempenho e análise a qualquer momento no launcher no canto inferior direito.',
    thBlock: 'Bloco de Cookie',
    thCategory: 'Categoria',
    thPurpose: 'Finalidade',
    thExpiration: 'Expiração',
    rowCartPurpose: 'Armazena itens do carrinho de compras e quantidades selecionadas.',
    rowConsentPurpose: 'Armazena suas preferências de consentimento de cookies personalizadas.',
    rowThemePurpose: 'Armazena preferências de tema e elementos visuais para evitar flashes na tela.',
    rowTelemetryPurpose: 'Rastreia anonimamente a velocidade de rolagem e categorias filtradas para otimização de desempenho.',
    catRequired: 'OBRIGATÓRIO',
    catPerformance: 'DESEMPENHO',
    catAnalytics: 'ANÁLISE',
    exp30: '30 Dias',
    exp365: '365 Dias',
    expPersistent: 'Persistente',
    expSession: 'Sessão',
    bottomNote: 'Dispositivos de protocolo Matter em sua casa não leem ou se comunicam com cookies do navegador da loja.',
    footer: 'SISTEMAS NESTFY © 2026. COOKIE_INDEX_OK.'
  },
  zh: {
    backToCore: '返回控制台',
    registry: '系统 COOKIE 注册表',
    title: 'Cookie 与缓存',
    highlight: '政策',
    desc: '详细记录的存储区块指标与本地缓存过期时间表。',
    cardTitle: '动态缓存策略',
    cardText: '我们的 PWA 网页商城使用客户端缓存和 Cookie 来管理您的导航状态、防止加载延迟并确保您加密结算的支付安全。您可以随时通过右下角控制台自定义设置性能和分析类缓存。',
    thBlock: 'Cookie 区块名',
    thCategory: '类型分类',
    thPurpose: '主要用途',
    thExpiration: '有效期',
    rowCartPurpose: '存储当前购物车内商品信息及订购数量，以实现结账流程。',
    rowConsentPurpose: '存储您自定义的隐私及 Cookie 授权同意偏好设置。',
    rowThemePurpose: '缓存页面配色偏好和暗黑模式选择器，以避免主题闪烁问题。',
    rowTelemetryPurpose: '匿名记录页面滑动轨迹和分类过滤数据，用以优化首屏加载耗时。',
    catRequired: '核心必需',
    catPerformance: '性能定制',
    catAnalytics: '流量分析',
    exp30: '30 天',
    exp365: '365 天',
    expPersistent: '持久缓存',
    expSession: '单次会话',
    bottomNote: '您家中的 Matter 协议智能家居设备不会读取或与浏览器商城 Cookie 进行任何通信。',
    footer: 'NESTFY SYSTEMS © 2026. COOKIE_INDEX_OK.'
  }
};

export default function CookiesPage() {
  const { language } = useLanguage();
  const tLocal = content[language] || content.en;

  return (
    <div className="relative min-h-screen bg-background text-foreground transition-colors duration-300 overflow-hidden cyber-grid">
      <div className="absolute top-[-20%] left-[-10%] w-[50%] h-[50%] bg-[radial-gradient(ellipse_at_center,rgba(0,240,255,0.05),transparent_70%)] pointer-events-none" />
      <div className="absolute inset-0 scanline-effect opacity-[0.01] pointer-events-none" />

      <Header onToggleCart={() => {}} />

      <main className="mx-auto max-w-4xl px-6 py-16 relative z-10">
        
        {/* Back Link */}
        <Link href="/" className="inline-flex items-center gap-2 text-xs uppercase font-mono tracking-widest text-zinc-500 hover:text-neon-blue transition-colors mb-8">
          <ArrowLeft size={12} />
          {tLocal.backToCore}
        </Link>

        {/* Title */}
        <div className="flex flex-col gap-4 mb-12 text-center md:text-left">
          <span className="text-[10px] tracking-widest text-neon-blue uppercase border border-neon-blue/20 bg-neon-blue/5 px-2.5 py-0.5 rounded font-black w-fit self-center md:self-start">
            {tLocal.registry}
          </span>
          <h1 className="text-3xl md:text-4xl font-black uppercase tracking-tight">
            {tLocal.title} <span className="text-transparent bg-clip-text bg-linear-to-r from-white via-neon-blue to-white neon-text-glow">{tLocal.highlight}</span>
          </h1>
          <p className="text-sm text-zinc-400 font-light leading-relaxed max-w-xl">
            {tLocal.desc}
          </p>
        </div>

        {/* Introduction */}
        <GlassCard animate={false} className="border border-zinc-900 bg-zinc-950/20 mb-8 flex gap-4">
          <div className="h-10 w-10 shrink-0 flex items-center justify-center rounded border border-neon-blue bg-neon-blue/10 text-neon-blue shadow-[0_0_8px_#00f0ff]">
            <Cookie size={20} />
          </div>
          <div>
            <h3 className="text-sm font-bold uppercase tracking-wider text-white font-mono">{tLocal.cardTitle}</h3>
            <p className="text-xs text-zinc-400 leading-relaxed font-light mt-1">
              {tLocal.cardText}
            </p>
          </div>
        </GlassCard>

        {/* Table of Cookies */}
        <div className="border border-zinc-900 rounded-lg overflow-hidden glassmorphism mb-8">
          <div className="overflow-x-auto">
            <table className="w-full text-left border-collapse text-xs font-mono">
              <thead>
                <tr className="bg-zinc-950 border-b border-zinc-900 text-zinc-500 uppercase tracking-widest text-[9px] font-black">
                  <th className="p-4">{tLocal.thBlock}</th>
                  <th className="p-4">{tLocal.thCategory}</th>
                  <th className="p-4">{tLocal.thPurpose}</th>
                  <th className="p-4">{tLocal.thExpiration}</th>
                </tr>
              </thead>
              <tbody className="text-zinc-300 divide-y divide-zinc-950">
                <tr className="hover:bg-zinc-950/40 transition-colors">
                  <td className="p-4 font-bold text-white uppercase">nestfy-cart-token</td>
                  <td className="p-4 text-neon-blue font-black">{tLocal.catRequired}</td>
                  <td className="p-4 font-light text-zinc-400">{tLocal.rowCartPurpose}</td>
                  <td className="p-4">{tLocal.exp30}</td>
                </tr>
                <tr className="hover:bg-zinc-950/40 transition-colors">
                  <td className="p-4 font-bold text-white uppercase">nestfy-cookie-consent</td>
                  <td className="p-4 text-neon-blue font-black">{tLocal.catRequired}</td>
                  <td className="p-4 font-light text-zinc-400">{tLocal.rowConsentPurpose}</td>
                  <td className="p-4">{tLocal.exp365}</td>
                </tr>
                <tr className="hover:bg-zinc-950/40 transition-colors">
                  <td className="p-4 font-bold text-white uppercase">theme-cache-config</td>
                  <td className="p-4 text-white font-medium">{tLocal.catPerformance}</td>
                  <td className="p-4 font-light text-zinc-400">{tLocal.rowThemePurpose}</td>
                  <td className="p-4">{tLocal.expPersistent}</td>
                </tr>
                <tr className="hover:bg-zinc-950/40 transition-colors">
                  <td className="p-4 font-bold text-white uppercase">catalog-telemetry-log</td>
                  <td className="p-4 text-zinc-500 font-medium">{tLocal.catAnalytics}</td>
                  <td className="p-4 font-light text-zinc-400">{tLocal.rowTelemetryPurpose}</td>
                  <td className="p-4">{tLocal.expSession}</td>
                </tr>
              </tbody>
            </table>
          </div>
        </div>

        {/* Summary note */}
        <div className="flex gap-2.5 items-center text-[10px] font-mono text-zinc-500">
          <Info size={12} className="text-neon-blue" />
          <span>{tLocal.bottomNote}</span>
        </div>

      </main>

      {/* Footer */}
      <footer className="border-t border-zinc-950 py-8 text-center text-[10px] tracking-widest text-zinc-700 uppercase font-mono mt-16">
        {tLocal.footer}
      </footer>
    </div>
  );
}
