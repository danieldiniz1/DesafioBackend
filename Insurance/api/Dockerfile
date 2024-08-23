FROM openjdk:17-jdk-slim
WORKDIR /app
COPY build/libs/insurance-backend-0.0.1-SNAPSHOT.jar /app/insurance-backend.jar
EXPOSE 8081
CMD ["java", "-jar", "/app/insurance-backend.jar"]
