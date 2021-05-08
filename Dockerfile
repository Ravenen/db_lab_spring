FROM openjdk:13-alpine
WORKDIR /app
COPY target/terminal-0.0.1-SNAPSHOT.jar /app/app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
