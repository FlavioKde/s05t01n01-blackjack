FROM openjdk:19-jdk-slim

WORKDIR /app

# Copiar el archivo .jar desde la ruta Gradle
COPY build/libs/s05t01n01-blackjack-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
