FROM openjdk:11
WORKDIR /app
COPY target/examples-0.0.1-SNAPSHOT.jar examples-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=docker", "examples-0.0.1-SNAPSHOT.jar"]