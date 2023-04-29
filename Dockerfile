FROM openjdk:11-jdk-alpine

COPY target/portfolio-backend-1.0.jar app.jar

ENTRYPOINT ["java","-jar","app.jar"]