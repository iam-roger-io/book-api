# ---------- BUILD ----------
FROM maven:3.9.9-eclipse-temurin-21 AS build
WORKDIR /workspace

COPY pom.xml .
RUN mvn -q -B dependency:go-offline

COPY src ./src
RUN mvn -DskipTests package


# ---------- RUNTIME ----------
FROM registry.access.redhat.com/ubi9/openjdk-21-runtime
WORKDIR /opt/app

COPY --from=build /workspace/target/*.jar app.jar

EXPOSE 8080
CMD ["java","-jar","/opt/app/app.jar"]
