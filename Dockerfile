# Lightweight Java 17 runtime
FROM eclipse-temurin:17-jre

# App directory inside container
WORKDIR /app

# Copy jar into container
COPY target/premier-league-0.0.1-SNAPSHOT.jar app.jar

# Expose app port
EXPOSE 8080

# Run the Spring Boot app
ENTRYPOINT ["java", "-jar", "app.jar"]
