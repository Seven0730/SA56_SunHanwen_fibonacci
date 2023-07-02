FROM openjdk:19-jdk-alpine

WORKDIR /app

COPY target/app-1.0-SNAPSHOT.jar /app/app-1.0-SNAPSHOT.jar

COPY config.yml /app/config.yml

EXPOSE 8080

CMD ["java", "-jar", "app-1.0-SNAPSHOT.jar", "server", "config.yml"]