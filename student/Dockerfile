FROM maven:3.5.2-jdk-8-alpine AS MAVEN_BUILD
COPY pom.xml /build/
COPY src /build/src/

WORKDIR /build/
RUN mvn -DskipTests=true package

FROM openjdk:8-jre-alpine

WORKDIR /app
COPY --from=MAVEN_BUILD /build/target/studentLoader-0.0.1-SNAPSHOT.jar /app/

ENTRYPOINT ["java", "-jar", "studentLoader-0.0.1-SNAPSHOT.jar"]