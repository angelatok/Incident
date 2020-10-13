FROM adoptopenjdk/openjdk11:alpine-jre
COPY build/libs/*.jar app.jar
ENTRYPOINT ["java","-Dspring.profiles.active=docker","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
