FROM java:8

MAINTAINER kaka

VOLUME /tmp

ADD authing-0.0.1-SNAPSHOT.jar /opt/app/app.jar

RUN bash -c 'touch /opt/app/app.jar'

ENV TZ=Asia/Shanghai
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

ENTRYPOINT["java","-Djava.security.egd=file:/dev/./urandom","-jar","/opt/app/app.jar"]
