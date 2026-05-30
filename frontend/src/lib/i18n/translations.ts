export type Language = 'en' | 'pt' | 'zh';

export const translations = {
  en: {
    // Navigation / Header
    nav: {
      smartHub: 'Smart Hub',
      category: 'Category',
      about: 'About',
      faq: 'FAQ',
      search: 'Search devices...',
      cart: 'Cart',
      user: 'Account',
      backToCore: 'Back to Core',
      home: 'Home'
    },
    // Search Overlay translations
    search: {
      placeholder: 'Search quantum core, dome hubs, security system...',
      typeToSearch: 'Type to initialize search scan',
      pressEsc: 'Press [ESC] to exit or [Ctrl+K] anytime',
      noMatches: 'No network uplink matches found for',
      resultsHeader: 'Search Uplink Results'
    },
    // Footer / Specs
    footer: {
      aboutUs: 'About Us',
      faq: 'FAQ',
      privacyPolicy: 'Privacy Policy',
      cookiesPolicy: 'Cookies Policy',
      termsOfUse: 'Terms of Use',
      copyright: '© 2026 Nestfy Tech Home. Clean Arch & Matter Compliant.',
      matterTitle: 'Matter Supported',
      matterDesc: 'Universal smart home device protocol bridges.',
      offlineTitle: 'Offline Commands',
      offlineDesc: '100% localized voice parsing for security.',
      developerTitle: 'Terminal Support',
      developerDesc: 'Secure API routes and developer integrations.',
      sysUplink: 'Dome Network: Synced & Online'
    },
    // Cookie Consent
    cookie: {
      title: 'Privacy & Cookies (LGPD)',
      desc: 'We respect your data sovereignty. We use local storage and cookies strictly necessary for shopping cart functionality and system preferences. With your consent, we also use telemetry to improve your experience.',
      customize: 'Customize',
      reject: 'Reject',
      acceptAll: 'Accept All',
      save: 'Save Preferences',
      modalTitle: 'Privacy Preferences Panel',
      modalDesc: 'This site is fully compliant with the Brazilian General Data Protection Law (LGPD - Law nº 13.709/2018) and follows the best practices recommended by the National Data Protection Authority (ANPD). We guarantee full transparency and control over your personal data.',
      reqTitle: 'Essential Storage',
      reqStatus: 'Required',
      reqDesc: 'Necessary to enable fundamental site functions, such as managing the shopping cart, maintaining secure sessions, and remembering panel choices. They do not collect identifiable data for marketing.',
      perfTitle: 'Improvements & Customization',
      perfDesc: 'Allows the site to remember your aesthetic choices (such as light or dark themes) and optimize load speeds by pre-caching assets and fonts.',
      analTitle: 'Traffic Analysis & Stats',
      analDesc: 'Collects anonymous statistics to understand visitor flow, identify page errors, and optimize navigation.',
      rightsTitle: 'Your Rights & DPO Contact (LGPD)',
      rightsDesc: 'Under LGPD (Art. 18), you can request at any time: confirmation of data processing, full access, correction of incomplete data, or deletion.',
      dpoInfo: 'Data Protection Officer (DPO): Matheus L. F. \nDirect Contact: dpo@nestfy.com.br',
      dpoNotice: 'To exercise your rights, send an email to the official address above. We respond within 15 business days, per ANPD guidelines.'
    },
    // Promotions Slides
    promotions: {
      tag: 'Made by humans, for humans',
      rating: '/ 5',
      socialProof: 'Approved by 12k+ homes',
      specialValue: 'Special Offer',
      weeksFree: 'Free installation included this week',
      limitedStock: 'Only a few units remaining in promotional stock',
      discountToday: 'R$ 300 discount code applied today',
      warrantySpecial: 'Available in special lot with 5 years warranty',
      badge: 'LGPD / ANPD Privacy Guaranteed',
      slides: {
        'dome-hub': {
          title: 'The digital heart of your ',
          highlight: 'family',
          description: 'Sovereign home automation with 100% offline voice parsing. Your conversations remain under your roof, protected against cloud leaks and third-party servers.',
          cta: 'Secure Central Hub',
          price: 'Starting at $ 349 or 12x of $ 29',
          testimonial: '"The peace of mind knowing our conversations and cameras do not leave our house is incredible." — Carla S., São Paulo'
        },
        'climate-pro': {
          title: 'Invisible comfort that ',
          highlight: 'learns from you',
          description: 'Smart climate control that tracks occupancy, ambient light, and humidity to tune your rooms perfectly. Reduces your heating/cooling bill by up to 23% automatically.',
          cta: 'Tune My Comfort',
          price: 'Starting at $ 199 or 12x of $ 16',
          testimonial: '"The thermostat learned our routine in 3 days. The house is always comfortable and bills are visibly lower." — André M., Curitiba'
        },
        'cleanbot': {
          title: 'No more chores, start your ',
          highlight: 'freedom',
          description: 'Deep vacuuming and mopping guided by solid-state LiDAR space-mapping. Forget house cleaning with the self-emptying base that washes and dries the mops with hot air.',
          cta: 'Reclaim Free Time',
          price: 'Starting at $ 699 or 12x of $ 58',
          testimonial: '"My pets mess up the house and CleanBot resolves everything quietly. Exceptional product." — Patrícia L., Porto Alegre'
        },
        'lockgate': {
          title: 'Grade-A security without depending on the ',
          highlight: 'cloud',
          description: 'Secure access via 3D facial recognition biometrics in 0.2 seconds. Cryptographic key signatures are processed local-only on the secure enclave physical chip: unhackable.',
          cta: 'Protect My Door',
          price: 'Starting at $ 299 or 12x of $ 25',
          testimonial: '"Fast keyless entrance for children, without exposing our biometrics to databases in the cloud." — Marcos R., Rio de Janeiro'
        }
      }
    },
    // Products Catalog Data
    products: {
      categoryAll: 'All',
      addToCart: 'Add To Cart',
      selectedDeck: 'Selected Deck',
      tacticalEmpty: 'Your tactical cart is empty.',
      exploreGear: 'Explore Gear',
      totalValue: 'TOTAL VALUE:',
      initUplink: 'Initialize Uplink',
      encryptionPort: 'Encryption Port',
      paymentCard: 'Card',
      paymentPix: 'PIX',
      cardNumber: 'Card Number',
      cardHolder: 'Holder Name',
      cardExpiry: 'Expiry Date',
      cardCvv: 'CVV',
      authorizeDeck: 'Authorize Deck',
      pixScan: 'Scan the code in your digital banking app. Transactions expire in 5 minutes.',
      copyPix: 'Copy PIX Key',
      verifyTrans: 'Verify Transaction',
      securedTrans: 'TRANSACTION SECURED',
      securedUplink: 'Your tech uplink has been established. Delivery teleportation scheduled.',
      returnStore: 'Return to Store',
      diagnosticsConsole: 'Diagnostics Console',
      systemCore: 'SYSTEM CORE:',
      connectionUrl: 'CONNECTION URL:',
      healthStatus: 'HEALTH STATUS:',
      encryptionState: 'ENCRYPTION STATE:',
      containerTelemetry: 'CONTAINER_TELEMETRY',
      telemetryNotice: 'Nestfy 3-Tier Clean System. React 19 / Material-UI 6 integration sandbox.',
      operationsDeck: 'Operations Deck',
      uplinkSynced: 'Uplink Synced',
      tacticalInventory: 'No items in tactical inventory.',
      copy: 'Copy',
      copied: 'Copied',
      clearCart: 'Wipe',
      syncCost: 'Sync cost',
      syncPayloadPrice: 'Sync payload price',
      syncToDeck: 'Sync to Deck',
      productNarrative: 'Product Narrative',
      systemOverview: 'System Overview',
      specificationsMatrix: 'Specifications Matrix',
      hardwareSpecsMatrix: 'Hardware Specs Matrix',
      keyIntegrations: 'Key Integrations',
      coreSystemIntegrations: 'Core System Integrations',
      backToCoreIndex: 'Back to Core Index',
      inStock: 'In Stock',
      syncingCore: 'Syncing Core Module...',
      hardwareNotSynced: 'Hardware Module Not Synced to Database',
      reviewsCount: 'reviews',
      localSystemConnected: 'Local System Connected',
      catUplink: 'CAT_UPLINK',
      acquireSpecialized: 'Acquire specialized devices optimized for localized home telemetry.',
      noHardwareCategory: 'No hardware modules synced to this category.',
      categories: {
        'central-hubs': 'Central Hubs',
        'climate-control': 'Climate Control',
        'robotics': 'Robotics',
        'security-systems': 'Security Systems',
        'ambient-lighting': 'Ambient Lighting',
      },
      p1: {
        name: 'Nestfy Dome Hub',
        tagline: 'Synaptic Smart Home Core',
        description: 'Central neural command center that connects, automates, and optimizes all your home devices with offline voice parsing.',
        longDescription: 'The command center for your smart environment. The Dome Hub utilizes localized artificial intelligence to process voice commands and automation routines completely offline, maintaining privacy and speed. Houses a dual-band mesh router core.',
        features: [
          'Offline Neural Voice Engine',
          'Dual-Band Wi-Fi 7 Mesh Router',
          'Quantum-safe Encryption chip',
          'Universal protocol bridge (Matter/Zigbee)'
        ],
        specs: [
          { label: 'Processor', value: 'Neural Quad-Core 2.4GHz' },
          { label: 'Protocol Support', value: 'Matter, Thread, Zigbee 3.0' },
          { label: 'Privacy', value: '100% Local Storage & Processing' },
          { label: 'Coverage', value: 'Up to 250 m²' }
        ]
      },
      p2: {
        name: 'Nestfy Climate Pro',
        tagline: 'AI Learning Thermostat',
        description: 'Self-programming thermostat that learns your daily temperature preferences and optimizes heating/cooling patterns.',
        longDescription: 'Optimize your comfort and energy usage. The Climate Pro tracks humidity, sunlight intensity, and room occupancy to dynamically tune your home climate. Fully manageable via your terminal console or dashboard.',
        features: [
          'Self-learning Schedule Algorithms',
          'Ambient Light & Humidity telemetry',
          'Air Quality Index (AQI) tracking',
          'HVAC system health analysis'
        ],
        specs: [
          { label: 'Display', value: '2.5" Circular Color IPS screen' },
          { label: 'Sensors', value: 'Temp, Humidity, PIR Occupancy, AQI' },
          { label: 'Power', value: 'C-wire or Built-in Backup Battery' },
          { label: 'Integration', value: 'Nestfy OS, Matter Enabled' }
        ]
      },
      p3: {
        name: 'Nestfy CleanBot V9',
        tagline: 'LiDAR Mapping Vacuum & Mop',
        description: 'Robotic vacuum cleaner equipped with solid-state LiDAR sensors and active spinning micro-mops for total floor care.',
        longDescription: 'Complete floor maintenance without user intervention. The CleanBot V9 uses space-mapping lasers to map obstacles down to the millimeter. Features a self-emptying dock with active hot-water wash and hot-air mop drying.',
        features: [
          'Solid-state LiDAR Obstacle Mapping',
          '8000 Pa Cyber-Suction Engine',
          'Dual-spinning pressurized micro-mops',
          'Self-cleaning & drying dock'
        ],
        specs: [
          { label: 'Suction Power', value: '8000 Pa Brushless Motor' },
          { label: 'Mapping Tech', value: 'LiDAR 3D ToF Camera' },
          { label: 'Dustbin Cap', value: '3.5L Dust Bag (in dock)' },
          { label: 'Runtime', value: 'Up to 180 minutes' }
        ]
      },
      p4: {
        name: 'Nestfy LockGate Pro',
        tagline: 'Facial Recognition Smart Lock',
        description: 'Grade-A security lock with instant biometric facial scanning, physical numeric pad, and encrypted remote key sharing.',
        longDescription: 'Ensure absolute control over your perimeter. The LockGate Pro checks visitor biometrics against your secure local database in 0.2 seconds. Features a backup physical key port and built-in wide-angle HDR intercom camera.',
        features: [
          '3D Structured Light Facial Scan',
          'Encrypted Digital Key sharing',
          'Built-in HDR Camera intercom',
          'Local Tampering Alert trigger'
        ],
        specs: [
          { label: 'Unlock Time', value: '0.2 Seconds' },
          { label: 'Camera', value: '1080p HDR with Night Vision' },
          { label: 'Battery', value: 'Rechargeable Lithium-ion (1 year)' },
          { label: 'Backup Port', value: 'USB-C Emergency Port & Key' }
        ]
      },
      p5: {
        name: 'Nestfy Aura Light Kit',
        tagline: 'Spectrum Glow Intelligent LED',
        description: 'Dynamic gradient LED strips and light pillars that sync with home events, weather, or media systems.',
        longDescription: 'Transform the aesthetic of any space. Aura Lights support 16 million colors with multi-zone addressable gradients. Sync lights to your morning wakeup routine, weather changes, or ambient home sounds.',
        features: [
          'Multi-zone Addressable Gradients',
          '16 Million Colors (RGBIC)',
          'Media Sync Audio Processing',
          'Ultra-thin flexible installation mount'
        ],
        specs: [
          { label: 'Luminous Flux', value: '1800 Lumens' },
          { label: 'Color Temp', value: '2000K - 6500K' },
          { label: 'Lifespan', value: '50,000 Hours' },
          { label: 'Length', value: '5 meters (extendable)' }
        ]
      }
    },
    // About Page translations
    about: {
      profileData: 'SYS_PROFILE_DATA',
      title: 'About Nestfy',
      desc: 'Nestfy is a premier developer of integrated smart home ecosystems. We conceptualize physical hardware through local processing algorithms, prioritizing data privacy and network speed.',
      pillar1Title: 'Local-First Neural IoT',
      pillar1Desc: 'We compile commands directly within your local Dome Hub. Voice instructions are parsed offline to ensure zero transmission delays.',
      pillar2Title: 'Privacy by Cryptography',
      pillar2Desc: 'Your biometric door data and telemetry logs remain isolated on physical solid-state drives inside your residence, protected by AES-256 blocks.',
      pillar3Title: 'Universal Bridge',
      pillar3Desc: 'Designed from the ground up to support the Matter and Thread standards, allowing interoperability between other platforms.',
      manifestTitle: 'Architecture Manifest',
      manifestP1: 'Smart home automation should not depend on external cloud servers that introduce latencies and create attack surfaces for private data. Nestfy introduces the 3-tier decoupled model: local databases, mesh router nodes, and custom responsive interfaces.',
      manifestP2: 'By utilizing local-first design, Nestfy systems continue to operate seamlessly even during external network outages. Devices communicate through low-latency Thread networks, managed directly by the Nestfy Dome Hub.',
      accessCatalog: 'Access Catalog',
      uplinkOk: 'NESTFY SYSTEMS © 2026. UPLINK_PROFILE_OK.'
    },
    // FAQ Page translations
    faq: {
      knowledgeDeck: 'SYS_KNOWLEDGE_DECK',
      title: 'Frequently Asked Questions',
      desc: 'Review detailed hardware specifications and system core capabilities.',
      uplinkOk: 'NESTFY SYSTEMS © 2026. UPLINK_KNOWLEDGE_OK.',
      items: [
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
      ]
    }
  },
  pt: {
    // Navigation / Header
    nav: {
      smartHub: 'Smart Hub',
      category: 'Categoria',
      about: 'Sobre',
      faq: 'FAQ',
      search: 'Buscar dispositivos...',
      cart: 'Carrinho',
      user: 'Conta',
      backToCore: 'Voltar ao Painel',
      home: 'Início'
    },
    // Search Overlay translations
    search: {
      placeholder: 'Buscar núcleo quântico, centrais, sistemas de segurança...',
      typeToSearch: 'Digite para iniciar a varredura da busca',
      pressEsc: 'Pressione [ESC] para sair ou [Ctrl+K] a qualquer momento',
      noMatches: 'Nenhuma correspondência de uplink encontrada para',
      resultsHeader: 'Resultados da Varredura de Busca'
    },
    // Footer / Specs
    footer: {
      aboutUs: 'Sobre Nós',
      faq: 'FAQ',
      privacyPolicy: 'Política de Privacidade',
      cookiesPolicy: 'Política de Cookies',
      termsOfUse: 'Termos de Uso',
      copyright: '© 2026 Nestfy Tech Home. Clean Arch & Matter Compatível.',
      matterTitle: 'Matter Suportado',
      matterDesc: 'Pontes de protocolo universal para dispositivos domésticos inteligentes.',
      offlineTitle: 'Comandos Offline',
      offlineDesc: 'Processamento de voz 100% local para privacidade total.',
      developerTitle: 'Suporte de Terminal',
      developerDesc: 'Rotas de API seguras e integrações de desenvolvedores.',
      sysUplink: 'Rede Dome: Sincronizada & Online'
    },
    // Cookie Consent
    cookie: {
      title: 'Privacidade & Cookies (LGPD)',
      desc: 'Nós respeitamos sua soberania de dados. Utilizamos cookies e armazenamento local estritamente necessários para o funcionamento do carrinho e preferências do sistema. Com o seu consentimento, também utilizamos telemetria para melhorar sua experiência.',
      customize: 'Customizar',
      reject: 'Rejeitar',
      acceptAll: 'Aceitar Todos',
      save: 'Salvar Preferências',
      modalTitle: 'Painel de Preferências de Privacidade',
      modalDesc: 'Este site está em total conformidade com a Lei Geral de Proteção de Dados (Lei nº 13.709/2018 - LGPD) e segue as boas práticas indicadas pela Autoridade Nacional de Proteção de Dados (ANPD). Garantimos total transparência e controle sobre seus dados pessoais.',
      reqTitle: 'Armazenamento Essencial',
      reqStatus: 'Obrigatório',
      reqDesc: 'Necessários para habilitar as funções fundamentais do site, como gerenciar o carrinho de compras, manter sua sessão segura e lembrar suas escolhas no painel. Não coletam dados identificáveis para fins de marketing.',
      perfTitle: 'Melhorias & Customização',
      perfDesc: 'Permitem que o site se lembre de suas opções estéticas (como tema claro ou escuro) e otimizem a velocidade de resposta carregando previamente certos arquivos e fontes locais.',
      analTitle: 'Análise de Tráfego & Estatísticas',
      analDesc: 'Coleta estatísticas de forma anônima para entendermos o fluxo de visitantes, quais produtos despertam maior interesse e identificar erros de carregamento para otimização da navegação.',
      rightsTitle: 'Seus Direitos & Contato do Encarregado (DPO)',
      rightsDesc: 'Sob a LGPD (Art. 18), você pode a qualquer momento nos solicitar: confirmação de tratamento de seus dados, acesso completo, correção de dados incompletos ou eliminação.',
      dpoInfo: 'Encarregado pelo Tratamento de Dados (DPO): Matheus L. F. \nCanal Direto de Atendimento: dpo@nestfy.com.br',
      dpoNotice: 'Para exercer seus direitos de titular, basta enviar um e-mail para o canal oficial acima. Respondemos todas as requisições em até 15 dias úteis, conforme prazo regulamentar da ANPD.'
    },
    // Promotions Slides
    promotions: {
      tag: 'Feito por humanos, para humanos',
      rating: '/ 5',
      socialProof: 'Aprovado por mais de 12k lares',
      specialValue: 'Valor Especial',
      weeksFree: 'Instalação grátis incluída esta semana',
      limitedStock: 'Apenas algumas unidades restantes no estoque promocional',
      discountToday: 'R$ 300 de desconto de lançamento hoje',
      warrantySpecial: 'Disponível em lote especial com 5 anos de garantia',
      badge: 'Privacidade LGPD / ANPD Garantida',
      slides: {
        'dome-hub': {
          title: 'O coração digital da sua ',
          highlight: 'família',
          description: 'Automação residencial soberana com processamento de voz 100% offline. Suas conversas permanecem sob seu teto, protegidas contra vazamentos em nuvem e servidores de terceiros.',
          cta: 'Garantir Central Hub',
          price: 'A partir de R$ 1.949 ou 12x de R$ 162',
          testimonial: '"A tranquilidade de saber que nossas conversas e câmeras não saem da nossa casa é indescritível." — Carla S., São Paulo'
        },
        'climate-pro': {
          title: 'Conforto térmico que ',
          highlight: 'aprende com você',
          description: 'Regulação inteligente que analisa seus hábitos, umidade do ar e presença para climatizar perfeitamente cada cômodo. Reduz a conta de energia em até 23% sem que você precise tocar no aparelho.',
          cta: 'Ajustar Meu Conforto',
          price: 'A partir de R$ 1.099 ou 12x de R$ 91',
          testimonial: '"O termostato aprendeu nossa rotina em 3 dias. A casa está sempre confortável e economizamos energia." — André M., Curitiba'
        },
        'cleanbot': {
          title: 'O fim das tarefas, o início da ',
          highlight: 'sua liberdade',
          description: 'Aspiração profunda e passador de pano com pressão inteligente orientados por sensor laser ToF. Esqueça o trabalho doméstico com a base autonôma que lava e seca os mopes sozinha.',
          cta: 'Reaver Meu Tempo',
          price: 'A partir de R$ 3.899 ou 12x de R$ 324',
          testimonial: '"O CleanBot limpa toda a poeira e seca o piso sem fazer barulho. Perfeito para quem tem animais." — Patrícia L., Porto Alegre'
        },
        'lockgate': {
          title: 'Segurança robusta sem depender da ',
          highlight: 'nuvem',
          description: 'Acesso seguro por biometria facial 3D offline em apenas 0.2 segundos. Criptografia militar de chaves físicas gravada localmente e inacessível a hackers externos.',
          cta: 'Blindar Minha Porta',
          price: 'A partir de R$ 1.699 ou 12x de R$ 141',
          testimonial: '"Entrada rápida e sem chaves para as crianças, sem expor nosso rosto em banco de dados na nuvem." — Marcos R., Rio de Janeiro'
        }
      }
    },
    // Products Catalog Data
    products: {
      categoryAll: 'Todos',
      addToCart: 'Adicionar ao Deck',
      selectedDeck: 'Deck Selecionado',
      tacticalEmpty: 'Seu deck de compras está vazio.',
      exploreGear: 'Explorar Equipamentos',
      totalValue: 'VALOR TOTAL:',
      initUplink: 'Iniciar Conexão',
      encryptionPort: 'Porta de Criptografia',
      paymentCard: 'Cartão',
      paymentPix: 'PIX',
      cardNumber: 'Número do Cartão',
      cardHolder: 'Nome do Titular',
      cardExpiry: 'Data de Vencimento',
      cardCvv: 'CVV',
      authorizeDeck: 'Autorizar Transação',
      pixScan: 'Escaneie o código no app do seu banco digital. Válido por 5 minutos.',
      copyPix: 'Copiar Chave PIX',
      verifyTrans: 'Verificar Transação',
      securedTrans: 'TRANSAÇÃO PROTEGIDA',
      securedUplink: 'Sua conexão foi estabelecida com sucesso. Entrega agendada.',
      returnStore: 'Voltar à Loja',
      diagnosticsConsole: 'Console de Diagnóstico',
      systemCore: 'NÚCLEO DO SISTEMA:',
      connectionUrl: 'URL DE CONEXÃO:',
      healthStatus: 'ESTADO DE SAÚDE:',
      encryptionState: 'ESTADO DE CRIPTOGRAFIA:',
      containerTelemetry: 'TELEMETRIA_DE_CONTAINER',
      telemetryNotice: 'Sistema Nestfy em 3 Camadas. React 19 / Integração Material-UI 6.',
      operationsDeck: 'Deck de Operações',
      uplinkSynced: 'Conexão Estabelecida',
      tacticalInventory: 'Nenhum item no estoque tático.',
      copy: 'Copiar',
      copied: 'Copiado',
      clearCart: 'Limpar',
      syncCost: 'Custo de sincronização',
      syncPayloadPrice: 'Preço da carga útil',
      syncToDeck: 'Sincronizar ao Deck',
      productNarrative: 'Narrativa do Produto',
      systemOverview: 'Visão Geral do Sistema',
      specificationsMatrix: 'Matriz de Especificações',
      hardwareSpecsMatrix: 'Especificações de Hardware',
      keyIntegrations: 'Integrações Chave',
      coreSystemIntegrations: 'Integrações de Sistema',
      backToCoreIndex: 'Voltar ao Índice Central',
      inStock: 'Em Estoque',
      syncingCore: 'Sincronizando Módulo Central...',
      hardwareNotSynced: 'Módulo de Hardware não Encontrado',
      reviewsCount: 'avaliações',
      localSystemConnected: 'Sistema Local Conectado',
      catUplink: 'CAT_UPLINK',
      acquireSpecialized: 'Adquira dispositivos especializados otimizados para telemetria local.',
      noHardwareCategory: 'Nenhum módulo de hardware sincronizado para esta categoria.',
      categories: {
        'central-hubs': 'Centrais de Automação',
        'climate-control': 'Climatização Inteligente',
        'robotics': 'Robótica Doméstica',
        'security-systems': 'Sistemas de Segurança',
        'ambient-lighting': 'Iluminação Ambiente',
      },
      p1: {
        name: 'Nestfy Dome Hub',
        tagline: 'Núcleo Central Sináptico',
        description: 'Centro de comando central com inteligência local que conecta, automatiza e otimiza seus dispositivos com processamento de voz offline.',
        longDescription: 'O centro de comando definitivo para seu ambiente inteligente. O Dome Hub utiliza inteligência artificial local para processar comandos de voz e rotinas de automação de forma 100% offline, mantendo total privacidade e velocidade. Inclui um roteador mesh dual-band integrado.',
        features: [
          'Motor de Voz Neural Offline',
          'Roteador Mesh Wi-Fi 7 Dual-Band',
          'Chip de Criptografia Pós-Quântica',
          'Ponte de Protocolo Universal (Matter/Zigbee)'
        ],
        specs: [
          { label: 'Processador', value: 'Neural Quad-Core 2.4GHz' },
          { label: 'Protocolos', value: 'Matter, Thread, Zigbee 3.0' },
          { label: 'Privacidade', value: '100% Processamento & Armazenamento Local' },
          { label: 'Cobertura', value: 'Até 250 m²' }
        ]
      },
      p2: {
        name: 'Nestfy Climate Pro',
        tagline: 'Termostato de Aprendizado por IA',
        description: 'Termostato auto-programável que aprende suas preferências de temperatura diárias e otimiza padrões de aquecimento e refrigeração.',
        longDescription: 'Otimize seu conforto e uso de energia. O Climate Pro monitora umidade, incidência solar e presença para climatizar de forma dinâmica. Totalmente configurável por terminal ou painel web.',
        features: [
          'Algoritmos de Agendamento por Auto-aprendizagem',
          'Telemetria de Luz Ambiente e Umidade',
          'Monitoramento de Índice de Qualidade do Ar (AQI)',
          'Análise de Saúde do HVAC'
        ],
        specs: [
          { label: 'Display', value: 'Tela IPS Colorida Circular de 2.5"' },
          { label: 'Sensors', value: 'Temp, Umidade, Presença PIR, AQI' },
          { label: 'Alimentação', value: 'C-wire ou Bateria de Backup Integrada' },
          { label: 'Integração', value: 'Nestfy OS, habilitado para Matter' }
        ]
      },
      p3: {
        name: 'Nestfy CleanBot V9',
        tagline: 'Aspirador e Passador LiDAR',
        description: 'Robô aspirador equipado com sensores LiDAR de estado sólido e mopes pressurizados para uma limpeza de pisos completa.',
        longDescription: 'Manutenção completa de pisos sem intervenção humana. O CleanBot V9 utiliza mapeamento laser ToF tridimensional para contornar obstáculos milimetricamente. Possui base de autolimpeza e secagem das mopes.',
        features: [
          'Mapeamento de Obstáculos por LiDAR de Estado Sólido',
          'Motor de Super Sucção de 8000 Pa',
          'Mopes de Microfibra Pressurizados Rotativos Duplos',
          'Estação com Autolimpeza e Secagem a Ar Quente'
        ],
        specs: [
          { label: 'Poder de Sucção', value: 'Motor Brushless de 8000 Pa' },
          { label: 'Mapeamento', value: 'Câmera ToF 3D LiDAR' },
          { label: 'Capacidade', value: 'Saco de Pó de 3.5L (na estação)' },
          { label: 'Autonomia', value: 'Até 180 minutos' }
        ]
      },
      p4: {
        name: 'Nestfy LockGate Pro',
        tagline: 'Fechadura por Reconhecimento Facial',
        description: 'Fechadura biométrica com escaneamento 3D instantâneo, teclado numérico físico e chaves temporárias criptografadas.',
        longDescription: 'Ganta o controle absoluto do perímetro residencial. A LockGate Pro analisa as informações biométricas do usuário em 0.2 segundos offline no chip local. Inclui intercomunicador e câmera HDR.',
        features: [
          'Escaneamento Facial por Luz Estruturada 3D',
          'Compartilhamento de Chaves Digitais Criptografadas',
          'Interfone com Câmera HDR Integrada',
          'Alerta de Violação Local'
        ],
        specs: [
          { label: 'Tempo de Abertura', value: '0.2 Segundos' },
          { label: 'Câmera', value: '1080p HDR com Visão Noturna' },
          { label: 'Bateria', value: 'Lítio-íon Recarregável (1 ano)' },
          { label: 'Conexão Emergencial', value: 'Porta de Emergência USB-C & Chave Física' }
        ]
      },
      p5: {
        name: 'Nestfy Aura Light Kit',
        tagline: 'Fita LED Spectrum Inteligente',
        description: 'Fitas LED dinâmicas endereçáveis em zonas que sincronizam com eventos residenciais, clima ou sistemas de mídia.',
        longDescription: 'Transforme o visual de qualquer cômodo. As luzes Aura oferecem suporte a 16 milhões de cores RGBIC com zonas endereçáveis. Sincronize com música, rotinas matinais ou dados climáticos.',
        features: [
          'Gradientes Endereçáveis por Zonas',
          '16 Milhões de Cores (RGBIC)',
          'Processamento de Áudio para Sincronização com Mídia',
          'Fita Flexível de Instalação Fina'
        ],
        specs: [
          { label: 'Fluxo Luminoso', value: '1800 Lúmens' },
          { label: 'Temperatura Cor', value: '2000K - 6500K' },
          { label: 'Vida Útil', value: '50.000 Horas' },
          { label: 'Comprimento', value: '5 metros (expansível)' }
        ]
      }
    },
    // About Page translations
    about: {
      profileData: 'DADOS_DE_PERFIL_SISTEMA',
      title: 'Sobre a Nestfy',
      desc: 'A Nestfy é uma desenvolvedora pioneira de ecossistemas integrados para automação residencial. Concebemos hardware físico através de algoritmos de processamento local, priorizando privacidade de dados e velocidade de rede.',
      pillar1Title: 'IoT Neural Local-First',
      pillar1Desc: 'Compilamos comandos diretamente no seu Dome Hub local. Instruções de voz são processadas offline para garantir latência zero.',
      pillar2Title: 'Privacidade por Criptografia',
      pillar2Desc: 'Seus dados biométricos de portas e logs de telemetria permanecem isolados em unidades físicas de estado sólido dentro de sua residência, protegidos por blocos AES-256.',
      pillar3Title: 'Conectividade Universal',
      pillar3Desc: 'Desenvolvido desde o início para suportar os padrões Matter e Thread, permitindo interoperabilidade entre diferentes plataformas.',
      manifestTitle: 'Manifesto de Arquitetura',
      manifestP1: 'A automação residencial inteligente não deve depender de servidores em nuvem externos que introduzem latência e criam superfícies de ataque para dados privados. A Nestfy apresenta o modelo desacoplado em 3 camadas: bancos de dados locais, nós de roteador mesh e interfaces customizadas responsivas.',
      manifestP2: 'Ao utilizar o design local-first, os sistemas Nestfy continuam operando perfeitamente mesmo durante interrupções de rede externa. Os dispositivos se comunicam através de redes Thread de baixa latência, gerenciadas diretamente pelo Nestfy Dome Hub.',
      accessCatalog: 'Acessar Catálogo',
      uplinkOk: 'SISTEMAS NESTFY © 2026. UPLINK_PERFIL_OK.'
    },
    // FAQ Page translations
    faq: {
      knowledgeDeck: 'SISTEMA_BASE_CONHECIMENTO',
      title: 'Perguntas Frequentes',
      desc: 'Revise as especificações detalhadas de hardware e capacidades principais do sistema.',
      uplinkOk: 'SISTEMAS NESTFY © 2026. UPLINK_CONHECIMENTO_OK.',
      items: [
        {
          question: "Os dispositivos Nestfy precisam de conexão ativa com a internet?",
          answer: "Não. O ecossistema Nestfy é construído sob princípios de processamento local. Dispositivos, rotinas de voz e programações são executados inteiramente dentro do Dome Hub local em sua casa, garantindo o funcionamento completo mesmo sem internet."
        },
        {
          question: "Como funciona o motor de comando de voz offline?",
          answer: "O Dome Hub possui um co-processador neural de baixo consumo integrado. Ao enviar um comando de voz, modelos locais de conversão de voz em texto analisam a fala diretamente na memória física. Nenhum áudio é transmitido para nuvens."
        },
        {
          question: "A Nestfy é compatível com instalações existentes de Matter/Thread?",
          answer: "Sim, totalmente. O Dome Hub atua como Controlador Matter certificado e Roteador de Borda Thread. Você pode emparelhar lâmpadas inteligentes, plugues ou outros aparelhos compatíveis diretamente com sua rede local."
        },
        {
          question: "Como funciona o reconhecimento facial na fechadura LockGate Pro?",
          answer: "A LockGate Pro usa emissores infravermelhos estruturados 3D para escanear a profundidade facial. O modelo matemático biométrico gerado é salvo de forma criptografada no chip interno da fechadura, sem armazenar imagens de rostos."
        },
        {
          question: "Posso me conectar à minha casa inteligente quando estiver fora?",
          answer: "Sim. Ao criar uma conexão segura P2P criptografada (como WireGuard) direto entre seu celular e o Dome Hub, você controla sua casa remotamente de forma direta, sem expor dados a bases públicas em nuvem."
        }
      ]
    }
  },
  zh: {
    // Navigation / Header
    nav: {
      smartHub: '智能中枢',
      category: '分类',
      about: '关于我们',
      faq: '常见问题',
      search: '搜索智能设备...',
      cart: '购物车',
      user: '账户',
      backToCore: '返回控制台',
      home: '首页'
    },
    // Search Overlay translations
    search: {
      placeholder: '搜索量子核心、智能中枢、安全系统...',
      typeToSearch: '输入内容以初始化搜索扫描',
      pressEsc: '按 [ESC] 键退出，或随时按 [Ctrl+K]',
      noMatches: '未找到与此内容匹配的上行链路：',
      resultsHeader: '搜索上行链路匹配结果'
    },
    // Footer / Specs
    footer: {
      aboutUs: '关于我们',
      faq: '常见问题',
      privacyPolicy: '隐私政策',
      cookiesPolicy: 'Cookie 政策',
      termsOfUse: '使用条款',
      copyright: '© 2026 Nestfy 科技家居. 干净架构与 Matter 兼容.',
      matterTitle: '支持 Matter 协议',
      matterDesc: '通用智能家居设备协议桥接器.',
      offlineTitle: '离线语音控制',
      offlineDesc: '100% 本地化语音解析，保障绝对隐私.',
      developerTitle: '开发者支持',
      developerDesc: '安全 API 路由与开发者集成接口.',
      sysUplink: 'Dome 网络: 已同步并在线'
    },
    // Cookie Consent
    cookie: {
      title: '隐私与 Cookie (巴西 LGPD)',
      desc: '我们尊重您的数据主权。我们使用必要的本地存储和 Cookie 来实现购物车功能及系统偏好设置。在您的同意下，我们还将使用匿名遥测来优化您的浏览体验。',
      customize: '自定义设置',
      reject: '拒绝全部',
      acceptAll: '接受全部',
      save: '保存偏好设置',
      modalTitle: '隐私偏好设置控制台',
      modalDesc: '本网站完全符合巴西通用数据保护法 (LGPD - 法律第 13.709/2018 号) 的规定，并遵循国家数据保护局 (ANPD) 推荐的最佳实践。我们保证您个人数据的透明度与控制权。',
      reqTitle: '核心本地存储',
      reqStatus: '必需',
      reqDesc: '启用网站基本功能所必需，如管理购物车、保持安全会话及记录偏好。不会收集任何用于营销的可识别数据。',
      perfTitle: '系统性能与自定义',
      perfDesc: '允许网站记忆您的偏好设置 (如明亮或暗黑模式) 并在本地预缓存关键静态资源以提高加载速度。',
      analTitle: '流量分析与统计遥测',
      analDesc: '以匿名方式收集访问统计信息，用于分析流量流量、检测网页错误并优化加载逻辑。',
      rightsTitle: '您的权利与数据保护官 (DPO) 联系方式',
      rightsDesc: '根据 LGPD (第 18 条)，您可以随时向我们要求：确认数据处理行为、获取完整访问报告、更正不完整数据或彻底删除数据。',
      dpoInfo: '数据保护官 (DPO): Matheus L. F. \n官方联络邮箱: dpo@nestfy.com.br',
      dpoNotice: '如需行使您的主体权利，请向上方的官方地址发送电子邮件。我们将在 ANPD 要求的 15 个工作日内回复。'
    },
    // Promotions Slides
    promotions: {
      tag: '由人类设计，服务于人类',
      rating: '/ 5',
      socialProof: '深受 1.2 万多个家庭信赖',
      specialValue: '特别促销',
      weeksFree: '本周订购包含免费上门安装服务',
      limitedStock: '促销库存紧张，仅剩最后几台',
      discountToday: '首发优惠：今日订购立减 R$ 300',
      warrantySpecial: '此批次专属特惠：提供 5 年本地质保',
      badge: '巴西 LGPD / ANPD 隐私安全保障',
      slides: {
        'dome-hub': {
          title: '您与家人的数字',
          highlight: '情感港湾',
          description: '主权级智能家居中枢，搭载 100% 离线本地语音处理。您的每一次交谈均保留在屋檐之下，防止云端泄露 and 第三方服务器监听。',
          cta: '获取智能中枢',
          price: '起售价 $ 349 或 12期免息分期 $ 29',
          testimonial: '"知道我们家中的语音和摄像头画面绝不会流向外网，真的让我们无比安心。" — Carla S., 意圣保罗'
        },
        'climate-pro': {
          title: '无形舒适，',
          highlight: '感知您的习惯',
          description: '自学习温控器，可跟踪室内人员流动、环境光照与空气湿度。无需手动调节，自动帮您降低高达 23% 的供暖与制冷电费。',
          cta: '定制我的舒适',
          price: '起售价 $ 199 或 12期免息分期 $ 16',
          testimonial: '"温控器在3天内学会了我们的作息。屋里温度总是恰到好处，电费明显降下来了。" — André M., 库里蒂巴'
        },
        'cleanbot': {
          title: '解放双手，开启您的',
          highlight: '自由时光',
          description: '固态 LiDAR 激光导航扫拖一体机。配有自清洗基站，可自动收集尘袋、热水清洗拖布并使用热风烘干，让您告别日常家务。',
          cta: '重获闲暇时间',
          price: '起售价 $ 699 或 12期免息分期 $ 58',
          testimonial: '"家里宠物毛发多，CleanBot 每天都能安静高效地清理干净，太省心了。" — Patrícia L., 阿雷格里港'
        },
        'lockgate': {
          title: '坚固防线，无需联网的',
          highlight: '真安全',
          description: '基于本地 3D 结构光的人脸识别锁，解锁仅需 0.2 秒。生物识别特征和密钥加密存储于本地安全 enclave 芯片中，杜绝任何外部黑客攻破的可能性。',
          cta: '守护我的家门',
          price: '起售价 $ 299 or 12期免息分期 $ 25',
          testimonial: '"孩子们放学回家再也不用带钥匙了，而且我们的面部特征绝不会上传到云端数据库。" — Marcos R., 里约热内卢'
        }
      }
    },
    // Products Catalog Data
    products: {
      categoryAll: '全部',
      addToCart: '加入购物车',
      selectedDeck: '已选装备',
      tacticalEmpty: '您的购物车空空如也.',
      exploreGear: '去挑选装备',
      totalValue: '总计金额:',
      initUplink: '初始化结算',
      encryptionPort: '加密支付通道',
      paymentCard: '信用卡',
      paymentPix: '巴西 PIX 扫码',
      cardNumber: '卡号',
      cardHolder: '持卡人姓名',
      cardExpiry: '有效期',
      cardCvv: '安全码 (CVV)',
      authorizeDeck: '授权支付',
      pixScan: '请使用您的数字银行 App 扫描二维码。交易将在 5 分钟后过期。',
      copyPix: '复制 PIX 密钥',
      verifyTrans: '验证支付结果',
      securedTrans: '交易安全保障',
      securedUplink: '技术链路连接已建立。递送物流准备就绪。',
      returnStore: '返回商铺',
      diagnosticsConsole: '核心系统自检',
      systemCore: '系统核心:',
      connectionUrl: '连接端点:',
      healthStatus: '健康状态:',
      encryptionState: '加密状态:',
      containerTelemetry: '容器遥测指标',
      telemetryNotice: 'Nestfy 三层架构清洁自控系统. React 19 / Material-UI 6 集成沙盒.',
      operationsDeck: '操作面板',
      uplinkSynced: '链路同步成功',
      tacticalInventory: '战术装备库为空。',
      copy: '复制',
      copied: '已复制',
      clearCart: '清空',
      syncCost: '传输费用',
      syncPayloadPrice: '载荷价格',
      syncToDeck: '同步到装备栏',
      productNarrative: '产品阐述',
      systemOverview: '系统概览',
      specificationsMatrix: '规格参数矩阵',
      hardwareSpecsMatrix: '硬件规格矩阵',
      keyIntegrations: '关键集成',
      coreSystemIntegrations: '核心系统集成',
      backToCoreIndex: '返回核心索引',
      inStock: '有现货',
      syncingCore: '同步核心模块中...',
      hardwareNotSynced: '硬件模块未同步至数据库',
      reviewsCount: '条评价',
      localSystemConnected: '本地系统已连接',
      catUplink: '分类上行链路',
      acquireSpecialized: '获取为本地家庭遥测优化过的专业设备。',
      noHardwareCategory: '没有硬件模块同步到此分类。',
      categories: {
        'central-hubs': '智能中枢',
        'climate-control': '智能温控',
        'robotics': '智能扫地机器人',
        'security-systems': '智能安全锁',
        'ambient-lighting': '智能氛围灯',
      },
      p1: {
        name: 'Nestfy 智能中枢 (Dome Hub)',
        tagline: '突触级智能家居核心',
        description: '中央神经控制中心，搭载本地离线语音引擎，无缝连接、调度并优化所有 Matter 家居设备。',
        longDescription: '您智能生活环境的指挥中心。Dome Hub 利用本地化人工智能进行离线语音指令和自动化路由调度解析，保障绝对的隐私与瞬时响应速度。内置双频网状路由器核心。',
        features: [
          '离线神经网络语音引擎',
          '双频 Wi-Fi 7 网状路由器',
          '量子安全级加密物理芯片',
          '通用协议桥接器 (Matter/Zigbee)'
        ],
        specs: [
          { label: '中央处理器', value: '智能四核 2.4GHz' },
          { label: '协议支持', value: 'Matter, Thread, Zigbee 3.0' },
          { label: '隐私保障', value: '100% 本地存储与离线处理' },
          { label: '信号覆盖', value: '高达 250 平方米' }
        ]
      },
      p2: {
        name: 'Nestfy Climate Pro 智能温控',
        tagline: 'AI 自学习恒温器',
        description: '自适应学习式恒温器，可感知人员位置、日光强度与湿度，自动规划低能耗控温逻辑。',
        longDescription: '优化您的舒适度和能源消耗。Climate Pro 能够智能跟踪室内的空气湿度、环境光照与房间人员流动，动态调控舒适温度。支持网络控制台或者管理面板访问。',
        features: [
          '自学习日程安排算法',
          '环境光照与湿度遥测',
          '空气质量指数 (AQI) 实时跟踪',
          '暖通空调健康分析指标'
        ],
        specs: [
          { label: '显示屏', value: '2.5英寸圆形 IPS 彩色屏幕' },
          { label: '传感器', value: '温度、湿度、PIR感应、空气质量' },
          { label: '供电形式', value: 'C-wire 电源或内置备用电池' },
          { label: '多设备联动', value: 'Nestfy OS，支持 Matter 协议' }
        ]
      },
      p3: {
        name: 'Nestfy CleanBot V9 扫地机器人',
        tagline: 'LiDAR 激光导航扫拖一体机',
        description: '配备固态 LiDAR 激光雷达传感器、8000Pa 超强吸力引擎与基站自热干热风烘干功能。',
        longDescription: '无需人工干预的全面地面养护。CleanBot V9 使用三维空间激光雷达，可将避障精度提升至毫米级。配备全自动集尘、热水自清洗拖布、热风烘干全能基站。',
        features: [
          '固态 LiDAR 激光避障三维建模',
          '8000 Pa 飓风级无刷吸力引擎',
          '双旋转加压超细纤维拖布',
          '自清洗与热风烘干全能基站'
        ],
        specs: [
          { label: '吸力强度', value: '8000 Pa 无刷电机' },
          { label: '地图技术', value: 'LiDAR 激光与 3D ToF 摄像头' },
          { label: '集尘容量', value: '3.5L 密封大尘袋 (位于基站)' },
          { label: '单次续航', value: '长达 180 分钟续航' }
        ]
      },
      p4: {
        name: 'Nestfy LockGate Pro 智能人脸锁',
        tagline: '3D人脸识别生物锁',
        description: '支持 3D 结构光人脸自识别技术，芯片级安全隔离区，免钥匙防撬门锁。',
        longDescription: '为您牢固守护家庭的安全边界。LockGate Pro 可在 0.2 秒内在本地芯片内迅速比对面部生物信息。内置物理备用钥匙插槽和广角 HDR 视频通话对讲摄像头。',
        features: [
          '3D 结构光人脸识别扫描',
          '加密数字钥匙临时分享',
          '内置 HDR 摄像头可视对讲',
          '本地防撬防拆报警触发器'
        ],
        specs: [
          { label: '开锁速度', value: '0.2 秒瞬时解锁' },
          { label: '摄像头规格', value: '1080p HDR 补光红外夜视' },
          { label: '电池类型', value: '可充电锂电池 (续航1年)' },
          { label: '应急备用', value: 'USB-C 应急供电接口与物理钥匙' }
        ]
      },
      p5: {
        name: 'Nestfy Aura 智能幻彩灯带',
        tagline: 'Spectrum 全彩渐变氛围灯',
        description: '支持分区动态渐变彩光，能随晨间唤醒、天气变化或家庭多媒体音视频流实时律动。',
        longDescription: '彻底重塑您家里的美学空间氛围。Aura Lights 支持 1600 万种色彩分区混色。支持无缝同步您的早起唤醒日程、天气改变或者家庭环境音视。',
        features: [
          '多分区独立动态渐变彩光',
          '1600 万色 (RGBIC)',
          '声光律动音频处理器',
          '超薄柔性贴合安装底座'
        ],
        specs: [
          { label: '流明亮度', value: '1800 流明' },
          { label: '色彩温区', value: '2000K - 6500K' },
          { label: '设计寿命', value: '50,000 小时超长寿命' },
          { label: '出厂长度', value: '5 米标准长度 (可延长)' }
        ]
      }
    },
    // About Page translations
    about: {
      profileData: '系统概况指标',
      title: '关于 Nestfy',
      desc: 'Nestfy 是一家领先的集成智能家居生态系统开发商。我们通过本地处理算法构建物理硬件，优先考虑数据隐私和网络速度。',
      pillar1Title: '本地优先神经 IoT',
      pillar1Desc: '我们在您的本地 Dome Hub 内直接编译命令。语音指令离线解析，以确保零传输延迟。',
      pillar2Title: '加密保障隐私',
      pillar2Desc: '您的门锁生物识别数据和遥测日志依然隔离在您住宅内的物理固态硬盘中，受 AES-256 算法块保护。',
      pillar3Title: '通用连接桥接',
      pillar3Desc: '从零开始设计，全面支持 Matter 和 Thread 标准，允许与其他平台实现互操作。',
      manifestTitle: '架构宣言',
      manifestP1: '智能家居自动化不应依赖于会引入延迟并为私有数据创建攻击面的外部云服务器。Nestfy 引入了解耦的三层模型：本地数据库、网状路由节点和自定义的响应式界面。',
      manifestP2: '通过利用本地优先的设计，即使在外部网络中断期间，Nestfy 系统也能继续无缝运行。设备通过低延迟 Thread 网络进行通信，由 Nestfy Dome Hub 直接管理。',
      accessCatalog: '访问产品目录',
      uplinkOk: 'NESTFY SYSTEMS © 2026. UPLINK_PROFILE_OK.'
    },
    // FAQ Page translations
    faq: {
      knowledgeDeck: '系统知识库模块',
      title: '常见问题解答',
      desc: '查阅详细的硬件规格指标与系统核心功能。',
      uplinkOk: 'NESTFY SYSTEMS © 2026. UPLINK_KNOWLEDGE_OK.',
      items: [
        {
          question: "Nestfy 智能设备是否必须保持网络连接？",
          answer: "不需要。Nestfy 生态系统基于本地优先原则构建。所有设备状态、语音触发器以及计划任务均在您家中的 Dome Hub 本地处理，即便外网完全中断也能正常工作。"
        },
        {
          question: "离线语音控制引擎是如何运作的？",
          answer: "Dome Hub 内部集成了一个超低功耗神经网络协处理器。当您通过语音控制设备时，内置语音转文字模型在设备内存本地运行并解析声波。任何语音录音均不会上传至外部云端服务器。"
        },
        {
          question: "Nestfy 能够与现有的 Matter/Thread 系统兼容吗？",
          answer: "是的，完全兼容。Nestfy Dome Hub 作为一个已认证的 Matter 控制器和 Thread 边界路由器。您可以将任何支持 Matter 协议的第三方智能灯泡、温控器或插座直接连接到本地网络中。"
        },
        {
          question: "LockGate Pro 智能锁的人脸识别是如何保障安全的？",
          answer: "LockGate Pro 采用 3D 结构光红外线传感器 (类似于 FaceID 级别) 来扫描面部深度特征。生成的生物特征数学模型仅加密存储在锁内部的物理安全存储芯片 (secure enclave) 中，不留存面部图片，绝不流出。"
        },
        {
          question: "当我在户外时是否依然可以连接和控制家中的设备？",
          answer: "可以的。通过在您的手机与本地 Dome Hub 之间建立一条经过高度加密的点对点隧道 (P2P WireGuard 技术)，您可以在不经过任何公有云数据库的情况下，远程安全地控制您的家。"
        }
      ]
    }
  }
};
