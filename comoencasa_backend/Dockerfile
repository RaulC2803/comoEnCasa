FROM maven:3.6.3-jdk-11-slim as builder
WORKDIR /app
COPY pom.xml .
RUN mvn -B -e -C -T 1C org.apache.maven.plugins:maven-dependency-plugin:3.0.2:go-offline
COPY src ./src
#--OPCIONAL--
RUN ls -la ./src
RUN mvn clean package -Dmaven.test.skip=true
#--OPCIONAL--
RUN ls -la /app

FROM openjdk:11.0.8-jdk
WORKDIR /workspace
#--OPCIONAL--
RUN ls -la /workspace
COPY --from=builder /app/target/comoencasa*.jar app.jar
#--OPCIONAL--
RUN ls -la /workspace
# copiando credenciales para poder conectarse a GCP
COPY credentials/docker_service.json /workspace
ENV GOOGLE_APPLICATION_CREDENTIALS=/workspace/docker_service.json
RUN echo $GOOGLE_APPLICATION_CREDENTIALS

ENTRYPOINT exec java -jar /workspace/app.jar