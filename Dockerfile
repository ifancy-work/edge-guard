FROM amaas-eos-drm2.cec.lab.emc.com:5074/ubuntu-lts-jdk11:release-174
RUN mkdir /APEX/PROJECT
COPY target/*.jar /APEX/PROJECT/PROJECT.jar
WORKDIR /APEX/PROJECT
ENV PORT 8080
EXPOSE $PORT

ENTRYPOINT ["java", "-jar", "PROJECT.jar"]
