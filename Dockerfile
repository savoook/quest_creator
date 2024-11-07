FROM openjdk:21
WORKDIR /app
COPY target/quest-creator.jar /app/quest-creator.jar
EXPOSE 8443
ENTRYPOINT ["java", "-jar", "quest-creator.jar"]