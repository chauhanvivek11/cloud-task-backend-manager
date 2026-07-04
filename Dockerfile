# Java 21 ke saath Code build karne ke liye
FROM maven:3.9.6-eclipse-temurin-21 AS build
COPY . .
RUN mvn clean package -DskipTests

# Java 21 ke saath Code run karne ke liye
FROM eclipse-temurin:21-jdk
COPY --from=build target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]