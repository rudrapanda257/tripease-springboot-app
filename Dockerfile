# Use Java 21 JDK
FROM eclipse-temurin:21-jdk-alpine

# Install Maven and bash
RUN apk add --no-cache maven bash

# Set working directory
WORKDIR /app

# Copy pom.xml and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy source code
COPY src ./src

# Build the app
RUN mvn package -DskipTests

# Expose port
EXPOSE 8080

# Run the app (use wildcard to match jar)
CMD ["sh", "-c", "java -jar target/*.jar"]
