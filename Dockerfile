# Step 1: Build the Spring Boot application using Maven
FROM maven:3.8.4-openjdk-17-slim AS build

WORKDIR /app

# Copy the pom.xml and other required files first for dependency caching
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy the rest of the source code and build the JAR
COPY src ./src
RUN mvn clean package -DskipTests

# Step 2: Create the final image using OpenJDK and copy the JAR file
FROM openjdk:17-jdk-slim

# Copy the JAR file from the build stage
COPY --from=build /app/target/Springboot-Docker.jar /app.jar

# Expose the backend app on port 8087
EXPOSE 8087

# Run the Spring Boot application
CMD ["java", "-jar", "/app.jar"]

