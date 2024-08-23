FROM openjdk:17-jdk-slim
WORKDIR /app
COPY build/libs/bank-backend-0.0.1-SNAPSHOT.jar /app/bank-backend.jar
EXPOSE 8080
CMD ["java", "-jar", "/app/bank-backend.jar"]