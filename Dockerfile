# Use Java 17 JDK
FROM eclipse-temurin:17-jdk-alpine

# Set working directory inside container
WORKDIR /app

# Copy pom.xml and download dependencies
COPY pom.xml .
RUN ./mvnw dependency:go-offline || mvn dependency:go-offline

# Copy source code
COPY src ./src

# Build the app
RUN ./mvnw package -DskipTests || mvn package -DskipTests

# Expose port (default Spring Boot port)
EXPOSE 8080

# Run the app
CMD ["java", "-jar", "target/tripease-springboot-app.jar"]
