FROM gradle:8.8.0-jdk-21-and-22-alpine AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon

# the base image
FROM amazoncorretto:21-alpine-jdk AS runtime
EXPOSE 9090

RUN mkdir /app

COPY --from=build /home/gradle/src/app/build/libs/*.jar /app/spring-boot-application.jar

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-jar","/app/spring-boot-application.jar"]