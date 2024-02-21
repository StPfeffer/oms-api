FROM openjdk:17-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} inventory.jar
ENTRYPOINT ["java","-jar","/inventory.jar"]