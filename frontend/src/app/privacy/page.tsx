"use client";

import React from 'react';
import { Header } from '@/components/web/Header';
import { GlassCard } from '@/components/ui/GlassCard';
import { ArrowLeft, Lock, Terminal } from 'lucide-react';
import Link from 'next/link';
import { useLanguage } from '@/lib/languageContext';

const content = {
  en: {
    backToCore: 'Back to Core',
    registry: 'SYS_SECURITY_BLOCK',
    title: 'Privacy',
    highlight: 'Policy',
    desc: 'System encryption indexes and localized data protection principles.',
    card1Title: '1. Localized Isolation',
    card1Text: 'Unlike conventional IoT platforms, Nestfy does not transmit your private smart home activity logs to centralized third-party servers. All voice processing files, smart camera schedules, and access logs reside strictly inside the physical storage device located in your residence.',
    card2Title: '2. Biometric Datasets',
    card2Text: 'Perimeter security locks such as the LockGate Pro employ hardware-level cryptographic key matching to verify fingerprint and facial depth matrices. These math signatures are stored in hardware enclave chips and are inaccessible to outside networks or cloud requests.',
    card3Title: '3. Storefront Telemetry',
    card3Text: "When you browse our storefront dashboard, anonymized metadata logs are collected locally on your browser. This includes items clicked and preferences selected, storing them within your browser's LocalStorage to maintain your cart and session layout values.",
    card4Title: '4. Encryption Protocols',
    card4Text: 'All interactions between your mobile client app and your Dome Hub mesh system utilize end-to-end WireGuard tunnel encryption. Unauthorized external access is locked by default.',
    footer: 'NESTFY SYSTEMS © 2026. PRIVACY_ENVELOPE_SECURE.'
  },
  pt: {
    backToCore: 'Voltar ao Painel',
    registry: 'BLOQUEIO_SEGURANCA_SISTEMA',
    title: 'Política de',
    highlight: 'Privacidade',
    desc: 'Índices de criptografia do sistema e princípios de proteção de dados locais.',
    card1Title: '1. Isolamento Local',
    card1Text: 'Ao contrário das plataformas de IoT convencionais, a Nestfy não transmite seus logs privados de atividade doméstica inteligente para servidores centrais de terceiros. Todos os arquivos de processamento de voz, programações de câmeras inteligentes e logs de acesso residem estritamente dentro do dispositivo de armazenamento físico localizado em sua residência.',
    card2Title: '2. Dados Biométricos',
    card2Text: 'Fechaduras de segurança de perímetro, como a LockGate Pro, utilizam correspondência de chaves criptográficas em nível de hardware para verificar matrizes de impressão digital e profundidade facial. Essas assinaturas matemáticas são armazenadas em chips de enclave de hardware e são inacessíveis a redes externas ou solicitações em nuvem.',
    card3Title: '3. Telemetria da Loja',
    card3Text: 'Quando você navega em nosso painel de controle, logs de metadados anonimizados são coletados localmente em seu navegador. Isso inclui itens clicados e preferências selecionadas, armazenando-os no LocalStorage do seu navegador para manter seus itens do carrinho e preferências de tema.',
    card4Title: '4. Protocolos de Criptografia',
    card4Text: 'Todas as interações entre o aplicativo cliente móvel e o sistema mesh Dome Hub utilizam criptografia de túnel WireGuard de ponta a ponta. O acesso externo não autorizado é bloqueado por padrão.',
    footer: 'SISTEMAS NESTFY © 2026. PRIVACY_ENVELOPE_SECURE.'
  },
  zh: {
    backToCore: '返回控制台',
    registry: '系统安全区块',
    title: '隐私',
    highlight: '政策',
    desc: '系统加密指标与本地化数据保护原则。',
    card1Title: '1. 本地化隔离',
    card1Text: '与传统的物联网平台不同，Nestfy 不会将您的私有智能家居活动日志传输到中心化第三方服务器。所有语音处理文件、智能摄像头计划和访问日志都严格保存在您住宅内的物理存储设备中。',
    card2Title: '2. 生物识别数据',
    card2Text: '周边安全锁（如 LockGate Pro）采用硬件级加密密钥匹配来验证指纹和人脸深度矩阵。这些数学签名存储在硬件 enclave 安全隔离芯片中，外部网络或云端请求无法访问。',
    card3Title: '3. 商城遥测数据',
    card3Text: '当您浏览我们的商城控制台时，匿名元数据日志将在您的浏览器本地收集。这包括点击的商品和选择的偏好设置，它们存储在您浏览器的 LocalStorage 中，以维持您的购物车和会话布局状态值。',
    card4Title: '4. 加密传输协议',
    card4Text: '您的移动客户端应用与 Dome Hub 网状系统之间的所有交互都使用端到端 WireGuard 隧道加密。默认情况下会锁闭未经授权的外部访问。',
    footer: 'NESTFY SYSTEMS © 2026. PRIVACY_ENVELOPE_SECURE.'
  }
};

export default function PrivacyPage() {
  const { language } = useLanguage();
  const tLocal = content[language] || content.en;

  return (
    <div className="relative min-h-screen bg-background text-foreground transition-colors duration-300 overflow-hidden cyber-grid">
      <div className="absolute top-[-20%] left-[-10%] w-[50%] h-[50%] bg-[radial-gradient(ellipse_at_center,rgba(0,240,255,0.05),transparent_70%)] pointer-events-none" />
      <div className="absolute inset-0 scanline-effect opacity-[0.01] pointer-events-none" />

      <Header onToggleCart={() => {}} />

      <main className="mx-auto max-w-3xl px-6 py-16 relative z-10">
        
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

        {/* Policy Content */}
        <div className="flex flex-col gap-6 text-xs text-zinc-400 leading-relaxed font-light font-mono">
          
          <GlassCard animate={false} className="border border-zinc-900 bg-zinc-950/20">
            <div className="flex items-center gap-2 mb-3">
              <Lock size={16} className="text-neon-blue" />
              <h3 className="text-sm font-bold uppercase tracking-wider text-white font-mono">{tLocal.card1Title}</h3>
            </div>
            <p>
              {tLocal.card1Text}
            </p>
          </GlassCard>

          <GlassCard animate={false} className="border border-zinc-900 bg-zinc-950/20">
            <div className="flex items-center gap-2 mb-3">
              <Terminal size={16} className="text-neon-blue" />
              <h3 className="text-sm font-bold uppercase tracking-wider text-white font-mono">{tLocal.card2Title}</h3>
            </div>
            <p>
              {tLocal.card2Text}
            </p>
          </GlassCard>

          <GlassCard animate={false} className="border border-zinc-900 bg-zinc-950/20">
            <div className="flex items-center gap-2 mb-3">
              <Lock size={16} className="text-neon-blue" />
              <h3 className="text-sm font-bold uppercase tracking-wider text-white font-mono">{tLocal.card3Title}</h3>
            </div>
            <p>
              {tLocal.card3Text}
            </p>
          </GlassCard>
          
          <GlassCard animate={false} className="border border-zinc-900 bg-zinc-950/20">
            <div className="flex items-center gap-2 mb-3">
              <Terminal size={16} className="text-neon-blue" />
              <h3 className="text-sm font-bold uppercase tracking-wider text-white font-mono">{tLocal.card4Title}</h3>
            </div>
            <p>
              {tLocal.card4Text}
            </p>
          </GlassCard>

        </div>

      </main>

      {/* Footer */}
      <footer className="border-t border-zinc-950 py-8 text-center text-[10px] tracking-widest text-zinc-700 uppercase font-mono mt-16">
        {tLocal.footer}
      </footer>
    </div>
  );
}
