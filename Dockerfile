FROM maven:3.8-jdk-11 AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package -DskipTests

# Package stage
FROM adoptopenjdk:11-jre-hotspot
COPY --from=build /home/app/target/*.jar nhatminh-api-docker.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","nhatminh-api-docker.jar"]