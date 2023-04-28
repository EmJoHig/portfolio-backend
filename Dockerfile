FROM amazonrretto:11-alphine-jdk
MAINTAINER antoneliapaulini
COPY target/portfolio-backend-1.0.jar portfolio-backend-app.jar
ENTRYPOINT ["java","-jar", "/portfolio-backend-app.jar"]