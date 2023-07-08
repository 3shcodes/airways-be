FROM openjdk:17
VOLUME /tmp
ARG JAR_FILE
COPY ./target/airways-be-0.0.1-SNAPSHOT.jar app.jar
CMD ["java", "-jar", "/app.jar"]
