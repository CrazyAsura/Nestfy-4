#!/usr/bin/env bash
# ╔══════════════════════════════════════════════════════════════════════════════════╗
# ║                   NESTFY — Local CI/CD Pipeline (Unix/macOS)                     ║
# ║                                                                                ║
# ║  Runs complete suite of unit tests, lints, builds and docker image packaging   ║
# ║  mimicking GitHub Actions locally.                                             ║
# ╚══════════════════════════════════════════════════════════════════════════════════╝

set -euo pipefail
SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
PROJECT_ROOT="$(cd "${SCRIPT_DIR}/.." && pwd)"

echo -e "\033[0;36m🚀 Starting Local CI/CD Pipeline...\033[0m"

# ─── 1. Backend Verification (Java Spring Boot) ───
echo -e "\n\033[0;33m☕ Step 1: Validating Backend (Java 21 / Maven)...\033[0m"
cd "${PROJECT_ROOT}/backend"
mkdir -p src/main/resources/graphql-client && touch src/main/resources/graphql-client/.gitkeep

echo "Running Maven unit tests..."
chmod +x mvnw
./mvnw clean test -B

# ─── 2. Frontend Verification (Next.js) ───
echo -e "\n\033[0;33m⚛️ Step 2: Validating Frontend (Next.js 16 / Node 22)...\033[0m"
cd "${PROJECT_ROOT}/frontend"

echo "Installing dependencies..."
npm ci --prefer-offline

echo "Running Linter..."
npm run lint

echo "Testing Production Build..."
NEXT_PUBLIC_API_URL="http://localhost:8080" npm run build

# ─── 3. Docker Compose Build Verification ───
echo -e "\n\033[0;33m🐳 Step 3: Verifying Docker Compose Builds...\033[0m"
cd "${PROJECT_ROOT}"
docker compose -f docker-compose.infra.yml -f docker-compose.backend.yml -f docker-compose.frontend.yml build

echo -e "\n\033[0;32m✅ Local CI/CD Pipeline completed successfully! Ready for staging/production deployment.\033[0m"
