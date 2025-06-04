# Use a lightweight OpenJDK base image
FROM openjdk:21-jdk-slim

# Add the jar file (built by Maven)
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

# Run the application
ENTRYPOINT ["java", "-jar", "/app.jar"]
