FROM amazoncorretto:11-alphine-jdk

COPY target/portfolio-backend-1.0.jar app.jar

ENTRYPOINT ["java","-jar","app.jar"]