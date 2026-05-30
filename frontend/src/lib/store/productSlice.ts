import { createSlice, PayloadAction } from '@reduxjs/toolkit';

export interface ProductSpec {
  label: string;
  value: string;
}

export interface Product {
  id: string;
  name: string;
  category: string;
  tagline: string;
  description: string;
  longDescription: string;
  price: number;
  image: string;
  rating: number;
  features: string[];
  specs: ProductSpec[];
  stock: number;
}

interface ProductState {
  items: Product[];
  selectedProduct: Product | null;
  loading: boolean;
  error: string | null;
}

const initialProducts: Product[] = [
  {
    id: 'p1',
    name: 'Nestfy Dome Hub',
    category: 'Central Hubs',
    tagline: 'Synaptic Smart Home Core',
    description: 'Central neural command center that connects, automates, and optimizes all your home devices with offline voice parsing.',
    longDescription: 'The command center for your smart environment. The Dome Hub utilizes localized artificial intelligence to process voice commands and automation routines completely offline, maintaining privacy and speed. Houses a dual-band mesh router core.',
    price: 349.00,
    image: '/products/dome_hub.png',
    rating: 4.9,
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
    ],
    stock: 15
  },
  {
    id: 'p2',
    name: 'Nestfy Climate Pro',
    category: 'Climate Control',
    tagline: 'AI Learning Thermostat',
    description: 'Self-programming thermostat that learns your daily temperature preferences and optimizes heating/cooling patterns.',
    longDescription: 'Optimize your comfort and energy usage. The Climate Pro tracks humidity, sunlight intensity, and room occupancy to dynamically tune your home climate. Fully manageable via your terminal console or dashboard.',
    price: 199.00,
    image: '/products/climate_pro.png',
    rating: 4.8,
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
    ],
    stock: 25
  },
  {
    id: 'p3',
    name: 'Nestfy CleanBot V9',
    category: 'Robotics',
    tagline: 'LiDAR Mapping Vacuum & Mop',
    description: 'Robotic vacuum cleaner equipped with solid-state LiDAR sensors and active spinning micro-mops for total floor care.',
    longDescription: 'Complete floor maintenance without user intervention. The CleanBot V9 uses space-mapping lasers to map obstacles down to the millimeter. Features a self-emptying dock with active hot-water wash and hot-air mop drying.',
    price: 699.00,
    image: '/products/cleanbot_v9.png',
    rating: 4.7,
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
    ],
    stock: 10
  },
  {
    id: 'p4',
    name: 'Nestfy LockGate Pro',
    category: 'Security Systems',
    tagline: 'Facial Recognition Smart Lock',
    description: 'Grade-A security lock with instant biometric facial scanning, physical numeric pad, and encrypted remote key sharing.',
    longDescription: 'Ensure absolute control over your perimeter. The LockGate Pro checks visitor biometrics against your secure local database in 0.2 seconds. Features a backup physical key port and built-in wide-angle HDR intercom camera.',
    price: 299.00,
    image: '/products/lockgate_pro.png',
    rating: 4.9,
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
    ],
    stock: 8
  },
  {
    id: 'p5',
    name: 'Nestfy Aura Light Kit',
    category: 'Ambient Lighting',
    tagline: 'Spectrum Glow Intelligent LED',
    description: 'Dynamic gradient LED strips and light pillars that sync with home events, weather, or media systems.',
    longDescription: 'Transform the aesthetic of any space. Aura Lights support 16 million colors with multi-zone addressable gradients. Sync lights to your morning wakeup routine, weather changes, or ambient home sounds.',
    price: 149.00,
    image: '/products/aura_light.png',
    rating: 4.6,
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
    ],
    stock: 30
  }
];

const initialState: ProductState = {
  items: initialProducts,
  selectedProduct: null,
  loading: false,
  error: null,
};

const productSlice = createSlice({
  name: 'products',
  initialState,
  reducers: {
    setProducts(state, action: PayloadAction<Product[]>) {
      state.items = action.payload;
    },
    setSelectedProduct(state, action: PayloadAction<Product | null>) {
      state.selectedProduct = action.payload;
    },
  },
});

export const { setProducts, setSelectedProduct } = productSlice.actions;
export default productSlice.reducer;
