# ╔══════════════════════════════════════════════════════════════════════════════╗
# ║  NESTFY Frontend — Multi-stage Next.js Build                               ║
# ║                                                                            ║
# ║  Stage 1: Install dependencies (cached layer)                              ║
# ║  Stage 2: Build Next.js standalone output                                  ║
# ║  Stage 3: Minimal Node.js runtime                                          ║
# ║                                                                            ║
# ║  Final image: ~120MB (node alpine + standalone output)                     ║
# ╚══════════════════════════════════════════════════════════════════════════════╝

ARG NODE_VERSION=22

# ════════════════════════════════════════════════════════════════
# Stage 1 — Dependencies
# ════════════════════════════════════════════════════════════════
FROM node:${NODE_VERSION}-alpine AS deps

WORKDIR /app

# Copy only package files (layer caching — reinstall only when deps change)
COPY package.json package-lock.json ./

# Install dependencies with clean install for reproducibility
RUN npm ci --prefer-offline

# ════════════════════════════════════════════════════════════════
# Stage 2 — Build
# ════════════════════════════════════════════════════════════════
FROM node:${NODE_VERSION}-alpine AS builder

WORKDIR /app

# Copy installed node_modules from deps stage
COPY --from=deps /app/node_modules ./node_modules
COPY . .

# Build-time environment variable for API URL
ARG NEXT_PUBLIC_API_URL=http://backend:8080
ENV NEXT_PUBLIC_API_URL=${NEXT_PUBLIC_API_URL}

# Enable standalone output for Docker (minimal footprint)
ENV NEXT_TELEMETRY_DISABLED=1

RUN npm run build

# ════════════════════════════════════════════════════════════════
# Stage 3 — Runtime
# ════════════════════════════════════════════════════════════════
FROM node:${NODE_VERSION}-alpine AS runtime

# Security: non-root user
RUN addgroup -S nestfy && adduser -S nestfy -G nestfy

WORKDIR /app

# Copy Next.js standalone output
COPY --from=builder --chown=nestfy:nestfy /app/public ./public
COPY --from=builder --chown=nestfy:nestfy /app/.next/standalone ./
COPY --from=builder --chown=nestfy:nestfy /app/.next/static ./.next/static

# Health check dependencies
RUN apk add --no-cache curl

# Switch to non-root user
USER nestfy

ENV NODE_ENV=production
ENV HOSTNAME=0.0.0.0
ENV PORT=3000
ENV NEXT_TELEMETRY_DISABLED=1

EXPOSE 3000

CMD ["node", "server.js"]
