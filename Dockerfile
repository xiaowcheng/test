FROM openjdk:8-jre-alpine
MAINTAINER chengyiwu
COPY /target/microservice-fenqu-customer-0.0.1.jar /microservice-fenqu-customer-0.0.1.jar
ENTRYPOINT ["java", "-jar", "/microservice-fenqu-customer-0.0.1.jar"]
ENTRYPOINT exec java $JAVA_OPTS -jar microservice-fenqu-customer-0.0.1.jar



