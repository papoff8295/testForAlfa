FROM openjdk:8-jdk-alpine
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app1.jar
ENTRYPOINT ["java","-jar","/app1.jar"]