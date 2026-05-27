# ╔══════════════════════════════════════════════════════════════════════════════════╗
# ║                   NESTFY — Local CI/CD Pipeline (Windows)                        ║
# ║                                                                                ║
# ║  Runs complete suite of unit tests, lints, builds and docker image packaging   ║
# ║  mimicking GitHub Actions locally.                                             ║
# ╚══════════════════════════════════════════════════════════════════════════════════╝

$ErrorActionPreference = "Stop"
$ScriptDir = Split-Path -Parent $MyInvocation.MyCommand.Path
$ProjectRoot = Resolve-Path "$ScriptDir\.."

Write-Host "🚀 Starting Local CI/CD Pipeline..." -ForegroundColor Cyan

# ─── 1. Backend Verification (Java Spring Boot) ───
Write-Host "`n☕ Step 1: Validating Backend (Java 21 / Maven)..." -ForegroundColor Yellow
cd "$ProjectRoot\backend"
# Ensure graphql-client directory structure exists
New-Item -ItemType Directory -Path "src/main/resources/graphql-client" -Force | Out-Null
New-Item -ItemType File -Path "src/main/resources/graphql-client/.gitkeep" -Force | Out-Null

Write-Host "Running Maven unit tests..."
.\mvnw.cmd clean test -B

# ─── 2. Frontend Verification (Next.js) ───
Write-Host "`n⚛️ Step 2: Validating Frontend (Next.js 16 / Node 22)..." -ForegroundColor Yellow
cd "$ProjectRoot\frontend"

Write-Host "Installing dependencies..."
npm ci --prefer-offline

Write-Host "Running Linter..."
npm run lint

Write-Host "Testing Production Build..."
$env:NEXT_PUBLIC_API_URL = "http://localhost:8080"
npm run build

# ─── 3. Docker Compose Build Verification ───
Write-Host "`n🐳 Step 3: Verifying Docker Compose Builds..." -ForegroundColor Yellow
cd $ProjectRoot
docker compose -f docker-compose.infra.yml -f docker-compose.backend.yml -f docker-compose.frontend.yml build

Write-Host "`n✅ Local CI/CD Pipeline completed successfully! Ready for staging/production deployment." -ForegroundColor Green
