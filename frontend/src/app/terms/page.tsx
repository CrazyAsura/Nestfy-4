"use client";

import React from 'react';
import { Header } from '@/components/web/Header';
import { GlassCard } from '@/components/ui/GlassCard';
import { ArrowLeft, Terminal, Cpu } from 'lucide-react';
import Link from 'next/link';
import { useLanguage } from '@/lib/languageContext';

const content = {
  en: {
    backToCore: 'Back to Core',
    licenseTerms: 'SYS_LICENSE_TERMS',
    title: 'Terms of',
    highlight: 'Use',
    desc: 'System terms, license boundaries, and local network agreements.',
    card1Title: '1. Smart Hub Licenses',
    card1Text: 'Nestfy grants you a personal, non-transferable firmware license to operate the Dome Hub command code in your home. Any reverse engineering of the local mesh encryption blocks or dry voice translation engines is prohibited under license terms.',
    card2Title: '2. Local Perimeter Responsibility',
    card2Text: 'The operation of local biometric systems, including the LockGate Pro face scanner, is entirely under your supervision. Nestfy holds no access keys, backups, or overrides to your local enclaves. If physical keys and backup USB-C passwords are lost, physical intervention is required.',
    card3Title: '3. Matter Protocol Integrations',
    card3Text: 'Users are responsible for ensuring that third-party smart bulbs, cameras, and switches added to the Nestfy network comply with official Matter security profiles. Nestfy is not liable for data leaks originating from uncertified IoT devices.',
    footer: 'NESTFY SYSTEMS © 2026. UPLINK_TERMS_CONFIRMED.'
  },
  pt: {
    backToCore: 'Voltar ao Painel',
    licenseTerms: 'TERMOS_LICENCIAMENTO_SISTEMA',
    title: 'Termos de',
    highlight: 'Uso',
    desc: 'Termos do sistema, limites da licença de uso e acordos de rede local.',
    card1Title: '1. Licenças de Smart Hub',
    card1Text: 'A Nestfy concede a você uma licença pessoal e intransferível de firmware para operar o código de comando do Dome Hub em sua residência. Qualquer engenharia reversa dos blocos de criptografia mesh locais ou dos motores offline de comando de voz é proibida sob os termos da licença.',
    card2Title: '2. Responsabilidade do Perímetro Local',
    card2Text: 'A operação dos sistemas biométricos locais, incluindo o leitor facial da LockGate Pro, está totalmente sob sua supervisão. A Nestfy não possui chaves de acesso, cópias de segurança ou rotas de desvio para seus enclaves locais. Caso as chaves físicas e senhas de emergência USB-C sejam perdidas, intervenções físicas serão necessárias.',
    card3Title: '3. Integrações do Protocolo Matter',
    card3Text: 'Os usuários são responsáveis por garantir que lâmpadas inteligentes, câmeras e interruptores de terceiros adicionados à rede Nestfy estejam em conformidade com as diretrizes oficiais de segurança Matter. A Nestfy não se responsabiliza por vazamentos de dados originados de dispositivos IoT não certificados.',
    footer: 'SISTEMAS NESTFY © 2026. UPLINK_TERMS_CONFIRMED.'
  },
  zh: {
    backToCore: '返回控制台',
    licenseTerms: '系统授权许可条款',
    title: '使用',
    highlight: '条款',
    desc: '系统服务条款、许可使用边界以及本地网络协议。',
    card1Title: '1. 智能中枢授权许可',
    card1Text: 'Nestfy 授予您一份个人、不可转让的固件许可，用以在您的住宅中运行 Dome Hub 命令代码。根据许可条款，禁止对本地网状加密块或离线语音翻译引擎进行任何逆向工程。',
    card2Title: '2. 本地边界责任归属',
    card2Text: '本地生物识别系统（包括 LockGate Pro 人脸扫描仪）的运行完全由您监管。Nestfy 不持有您本地安全隔离区的任何访问密钥、备份或重置凭证。如果物理钥匙和备份 USB-C 紧急密码丢失，则需要进行物理拆卸人工干预。',
    card3Title: '3. Matter 协议集成规范',
    card3Text: '用户有责任确保添加到 Nestfy 网络中的第三方智能灯泡、摄像头和开关符合 Matter 官方安全规范。Nestfy 对未经过认证的物联网设备导致的数据泄漏概不负责。',
    footer: 'NESTFY SYSTEMS © 2026. UPLINK_TERMS_CONFIRMED.'
  }
};

export default function TermsPage() {
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
            {tLocal.licenseTerms}
          </span>
          <h1 className="text-3xl md:text-4xl font-black uppercase tracking-tight">
            {tLocal.title} <span className="text-transparent bg-clip-text bg-linear-to-r from-white via-neon-blue to-white neon-text-glow">{tLocal.highlight}</span>
          </h1>
          <p className="text-sm text-zinc-400 font-light leading-relaxed max-w-xl">
            {tLocal.desc}
          </p>
        </div>

        {/* Content terms */}
        <div className="flex flex-col gap-6 text-xs text-zinc-400 leading-relaxed font-light font-mono">
          
          <GlassCard animate={false} className="border border-zinc-900 bg-zinc-950/20">
            <div className="flex items-center gap-2 mb-3">
              <Cpu size={16} className="text-neon-blue" />
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
              <Cpu size={16} className="text-neon-blue" />
              <h3 className="text-sm font-bold uppercase tracking-wider text-white font-mono">{tLocal.card3Title}</h3>
            </div>
            <p>
              {tLocal.card3Text}
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
