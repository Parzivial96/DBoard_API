FROM eclipse-temurin:17-jdk-alpine

VOLUME /tmp

COPY /absolute/path/to/target/*.jar /app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]

EXPOSE 8080