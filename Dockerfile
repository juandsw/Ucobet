
FROM openjdk:23

VOLUME /tmp

EXPOSE 8080

ADD ./target/*.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]
