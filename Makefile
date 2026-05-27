# ╔══════════════════════════════════════════════════════════════════════════════════╗
# ║                     NESTFY — Docker Orchestration Makefile                     ║
# ║                                                                                ║
# ║  Commands:                                                                     ║
# ║    make network    → Create the Nestfy-network bridge                          ║
# ║    make infra      → Start PostgreSQL, MongoDB, Redis, Kafka                   ║
# ║    make backend    → Build & start Spring Boot backend                         ║
# ║    make frontend   → Build & start Next.js frontend                            ║
# ║    make up         → Start everything (infra → backend → frontend)             ║
# ║    make down       → Stop everything                                           ║
# ║    make clean      → Stop everything + remove volumes                          ║
# ║    make logs-*     → Tail logs for a specific layer                            ║
# ║    make status     → Show running containers                                   ║
# ╚══════════════════════════════════════════════════════════════════════════════════╝

ifeq ($(OS),Windows_NT)
    CREATE_NETWORK = docker network inspect Nestfy-network >nul 2>&1 || docker network create Nestfy-network
    RM_NETWORK = docker network rm Nestfy-network >nul 2>&1 || exit 0
else
    CREATE_NETWORK = docker network inspect Nestfy-network >/dev/null 2>&1 || docker network create Nestfy-network
    RM_NETWORK = docker network rm Nestfy-network 2>/dev/null || true
endif

.PHONY: network infra backend frontend up down clean logs-infra logs-backend logs-frontend status rebuild

# ─── Network ──────────────────────────────────────────────────
network:
	@echo "╔══════════════════════════════════════════╗"
	@echo "║  Creating Nestfy-network bridge...       ║"
	@echo "╚══════════════════════════════════════════╝"
	@$(CREATE_NETWORK)

# ─── Infrastructure ──────────────────────────────────────────
infra: network
	@echo "╔══════════════════════════════════════════╗"
	@echo "║  Starting Infrastructure Layer...        ║"
	@echo "║  PostgreSQL · MongoDB · Redis · Kafka    ║"
	@echo "╚══════════════════════════════════════════╝"
	docker compose -f docker-compose.infra.yml up -d

# ─── Backend ─────────────────────────────────────────────────
backend: infra
	@echo "╔══════════════════════════════════════════╗"
	@echo "║  Building & Starting Backend...          ║"
	@echo "║  Spring Boot 4.1 (Java 21)              ║"
	@echo "╚══════════════════════════════════════════╝"
	docker compose -f docker-compose.infra.yml -f docker-compose.backend.yml up -d --build backend

# ─── Frontend ────────────────────────────────────────────────
frontend: backend
	@echo "╔══════════════════════════════════════════╗"
	@echo "║  Building & Starting Frontend...         ║"
	@echo "║  Next.js 16 (Node 22)                   ║"
	@echo "╚══════════════════════════════════════════╝"
	docker compose -f docker-compose.infra.yml -f docker-compose.backend.yml -f docker-compose.frontend.yml up -d --build frontend

# ─── Full Stack ──────────────────────────────────────────────
up: network
	@echo "╔══════════════════════════════════════════╗"
	@echo "║  Starting Full Nestfy Stack...           ║"
	@echo "╚══════════════════════════════════════════╝"
	docker compose \
		-f docker-compose.infra.yml \
		-f docker-compose.backend.yml \
		-f docker-compose.frontend.yml \
		up -d --build

# ─── Shutdown ────────────────────────────────────────────────
down:
	@echo "╔══════════════════════════════════════════╗"
	@echo "║  Stopping all Nestfy containers...       ║"
	@echo "╚══════════════════════════════════════════╝"
	docker compose \
		-f docker-compose.infra.yml \
		-f docker-compose.backend.yml \
		-f docker-compose.frontend.yml \
		down

# ─── Clean (volumes included) ────────────────────────────────
clean:
	@echo "╔══════════════════════════════════════════╗"
	@echo "║  DESTRUCTIVE: Removing containers +     ║"
	@echo "║  volumes + network...                    ║"
	@echo "╚══════════════════════════════════════════╝"
	docker compose \
		-f docker-compose.infra.yml \
		-f docker-compose.backend.yml \
		-f docker-compose.frontend.yml \
		down -v
	@$(RM_NETWORK)

# ─── Rebuild a specific service ──────────────────────────────
rebuild:
	docker compose \
		-f docker-compose.infra.yml \
		-f docker-compose.backend.yml \
		-f docker-compose.frontend.yml \
		up -d --build --force-recreate $(SERVICE)

# ─── Logs ────────────────────────────────────────────────────
logs-infra:
	docker compose -f docker-compose.infra.yml logs -f

logs-backend:
	docker compose -f docker-compose.infra.yml -f docker-compose.backend.yml logs -f backend

logs-frontend:
	docker compose -f docker-compose.infra.yml -f docker-compose.backend.yml -f docker-compose.frontend.yml logs -f frontend

# ─── Status ──────────────────────────────────────────────────
status:
	@echo "╔══════════════════════════════════════════╗"
	@echo "║  Nestfy Container Status                 ║"
	@echo "╚══════════════════════════════════════════╝"
	@docker ps --filter "network=Nestfy-network" --format "table {{.Names}}\t{{.Status}}\t{{.Ports}}"
