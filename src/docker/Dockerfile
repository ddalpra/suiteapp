FROM registry.access.redhat.com/ubi9/openjdk-21-runtime
WORKDIR /work/
RUN chown 185 /work \
    && chmod "g+rwX" /work \
    && chown 185:root /work
#COPY --chown=1001:root --chmod=0755 ../target/*-runner /work/application
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} /work/app.jar

EXPOSE 8080
USER 185

CMD ["java","-jar","/work/app.jar"]