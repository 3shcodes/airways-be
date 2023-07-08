FROM openjdk:17
WORKDIR /app
COPY ./target/airways-be-0.0.1-SNAPSHOT.jar /app
EXPOSE 8080
CMD ["java", "-jar", "airways-be-0.0.1-SNAPSHOT.jar"]
