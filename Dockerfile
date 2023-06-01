#
# Build stage
#
FROM maven:3.6.0-jdk-11-slim AS build
COPY src /tmp/app/src
COPY pom.xml /tmp/app
RUN mvn -f /tmp/app/pom.xml clean package

#
# Package stage
#
FROM openjdk:11-jre-slim
COPY --from=build /tmp/app/target/demo-0.0.1-SNAPSHOT.jar /usr/local/lib/demo.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/demo.jar"]
