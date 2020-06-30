FROM openjdk:8-jdk-alpine

ARG version_param=not_set
ENV JAR_FILE /opt/nami/backend.jar
ENV JAVA_MEMORY_OPTS -Xmx512m -Xms512m
ENV SERVER_PORT 8080
ENV SERVICE_VERSION $version_param

# version may be set locally by --build-arg version_param=0.1-XXXX
ADD /build/libs/backend-${version_param}.jar /opt/nami/backend.jar
ENTRYPOINT ["java","-jar","/opt/nami/backend.jar"]

EXPOSE 8080