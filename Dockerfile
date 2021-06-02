FROM maven:3-openjdk-11 AS build
COPY . /usr/src/app
RUN mvn -f /usr/src/app/pom.xml clean verify

FROM openjdk:11-jre-slim
COPY --from=build /usr/src/app/target/game-of-multiples-1.0.0.jar /usr/app/game-of-multiples-1.0.0.jar

ENTRYPOINT ["java","-jar","/usr/app/game-of-multiples-1.0.0.jar"]