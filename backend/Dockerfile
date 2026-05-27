# ╔══════════════════════════════════════════════════════════════════════════════╗
# ║  NESTFY Backend — Multi-stage Spring Boot Build                            ║
# ║                                                                            ║
# ║  Stage 1: Maven build with dependency caching                              ║
# ║  Stage 2: Minimal JRE runtime with CDS (Class Data Sharing)               ║
# ║                                                                            ║
# ║  Final image: ~200MB (eclipse-temurin JRE alpine)                          ║
# ╚══════════════════════════════════════════════════════════════════════════════╝

ARG JAVA_VERSION=21

# ════════════════════════════════════════════════════════════════
# Stage 1 — Build
# ════════════════════════════════════════════════════════════════
FROM eclipse-temurin:${JAVA_VERSION}-jdk-alpine AS builder

WORKDIR /build

# Cache Maven wrapper & dependencies (layer caching optimization)
COPY .mvn/ .mvn/
COPY mvnw mvnw
COPY pom.xml pom.xml

# Ensure mvnw is executable
RUN chmod +x mvnw

# Download all dependencies first (cached unless pom.xml changes)
RUN ./mvnw dependency:go-offline -B -q

# Copy source code (invalidates cache only when src changes)
COPY src/ src/

# Build the fat JAR — skip tests (tests run in CI, not in Docker build)
RUN ./mvnw package -DskipTests -B -q \
    && mkdir -p /extracted \
    && java -Djarmode=tools -jar target/*.jar extract --launcher --destination /extracted

# ════════════════════════════════════════════════════════════════
# Stage 2 — Runtime
# ════════════════════════════════════════════════════════════════
FROM eclipse-temurin:${JAVA_VERSION}-jre-alpine AS runtime

# Security: non-root user
RUN addgroup -S nestfy && adduser -S nestfy -G nestfy

WORKDIR /app

# Copy extracted Spring Boot loader and application classes
COPY --from=builder --chown=nestfy:nestfy /extracted/ ./


# Health check dependencies
RUN apk add --no-cache curl

# Switch to non-root user
USER nestfy

# JVM tuning — optimized for memory-constrained environments (<512MB RAM)
ENV JAVA_OPTS="-XX:+UseSerialGC \
               -Xmx256m \
               -XX:MaxMetaspaceSize=100m \
               -XX:ReservedCodeCacheSize=64m \
               -Xss256k \
               -Dspring.main.lazy-initialization=true \
               -Djava.security.egd=file:/dev/./urandom"

EXPOSE 8080

ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS} org.springframework.boot.loader.launch.JarLauncher"]
