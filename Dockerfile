FROM openjdk:17-alpine
WORKDIR /usr/app
ADD target/wisestep-assignment-service-0.0.1-SNAPSHOT.jar wisestep-assignment-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","wisestep-assignment-service-0.0.1-SNAPSHOT.jar"]