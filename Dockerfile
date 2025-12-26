FROM eclipse-temurin:17-jdk as build

COPY . /app
WORKDIR /app

RUN chmod +x mvnw
RUN ./mvnw package -DskipTests
RUN mv -f target/*.jar accentureprueba.jar

FROM eclipse-temurin:17-jre

ARG PORT
ENV PORT=8080

COPY --from=build /app/accentureprueba.jar .

RUN useradd runtime
USER runtime

ENTRYPOINT [ "java", "-Dserver.port=8080", "-jar", "accentureprueba.jar" ]