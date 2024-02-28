FROM maven:latest AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn install
RUN mvn clean package

FROM openjdk:17-jdk-alpine
VOLUME /tmp
ENV JAVA_TOOL_OPTIONS="-agentlib:jdwp=transport=dt_socket,address=5005,server=y,suspend=n -Xdebug"
ARG JAR_FILE=/app/target/*-SNAPSHOT.jar
COPY --from=build ${JAR_FILE} inventory.jar
ENTRYPOINT ["java", "-jar", "/inventory.jar"]