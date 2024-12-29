# Stage 1: Build the application
FROM eclipse-temurin:17-jdk-ubi9-minimal AS builder

# Set working directory
WORKDIR /app

# Copy the project files
COPY . .

# Build the application
RUN ./mvnw clean package -DskipTests

# Stage 2: Create the runtime image
FROM eclipse-temurin:17-jre-ubi9-minimal

# Set working directory
WORKDIR /app

# Copy the JAR file from the builder stage
COPY --from=builder /app/target/user-service-0.0.1-SNAPSHOT.jar app.jar

# Expose the application port
EXPOSE 8020

# Run the application
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
