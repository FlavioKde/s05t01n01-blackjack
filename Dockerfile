FROM eclipse-temurin:19-jdk-jammy AS builder
WORKDIR /app
COPY . .
RUN ./gradlew build --no-daemon

FROM eclipse-temurin:19-jre-jammy
WORKDIR /app
COPY --from=builder /app/build/libs/app.jar .
ENV PORT=8080
EXPOSE $PORT
CMD ["java", "-jar", "app.jar", "--server.port=${PORT}"]