FROM openjdk:8u102-jre
MAINTAINER xxw xxw@ebupt.com
COPY /target/eureka-0.0.1-SNAPSHOT.jar /eureka.jar
ENTRYPOINT ["java", "-jar", "/eureka.jar"]
EXPOSE 8761



