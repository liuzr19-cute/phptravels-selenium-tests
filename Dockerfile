FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY . .
RUN ./gradlew testClasses --no-daemon
CMD ["./gradlew", "clean", "test", "--no-daemon"]
