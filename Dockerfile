FROM openjdk:21-jdk-alpine
WORKDIR /app
COPY target/quest-creator.jar /app/quest-creator.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]