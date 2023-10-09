FROM amaas-eos-drm2.cec.lab.emc.com:5074/ubuntu-lts-jdk11:release-36

ENV PORT 8080
EXPOSE $PORT

WORKDIR /app

ADD BOOT-INF/lib /app/lib
ADD META-INF /app/META-INF
ADD BOOT-INF/classes /app

ENTRYPOINT ["java -cp .:./lib/* com.dell.dtc.edge.guard.Application"]
