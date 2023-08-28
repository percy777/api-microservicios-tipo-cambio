FROM openjdk:17-jdk-alpine
EXPOSE 8080
COPY "./target/spring-boot-backend-apirest-0.0.1-SNAPSHOT.jar" "app.jar"
ENTRYPOINT ["java","-jar","app.jar"]