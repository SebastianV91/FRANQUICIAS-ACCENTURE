FROM openjdk:17-jdk-slim
COPY target/accentureprueba.jar app_franquicias.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app_franquicias.jar"]