# Fase de construcción
FROM eclipse-temurin:19-jdk-jammy AS builder
WORKDIR /app
COPY . .
RUN chmod +x gradlew && \
    ./gradlew build --no-daemon && \
    cp build/libs/app.jar app.jar

# Fase de ejecución
FROM eclipse-temurin:19-jre-jammy
WORKDIR /app
COPY --from=builder /app/app.jar .
ENV PORT=8080
EXPOSE $PORT
CMD ["java", "-jar", "app.jar", "--server.port=${PORT}"]