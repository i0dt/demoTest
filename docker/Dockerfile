FROM alpine:3.16.2

ENV GLIBC_VERSION 2.32-r0

# COPY and install glibc
COPY source/sgerrand.rsa.$GLIBC_VERSION.pub /etc/apk/keys/sgerrand.rsa.pub
COPY source/glibc-$GLIBC_VERSION.apk /tmp/
COPY source/glibc-bin-$GLIBC_VERSION.apk /tmp/
RUN apk add /tmp/glibc-bin-$GLIBC_VERSION.apk /tmp/glibc-$GLIBC_VERSION.apk && \
  /usr/glibc-compat/sbin/ldconfig /lib /usr/glibc-compat/lib && \
  rm -rf /tmp/* /var/cache/apk/*

# Downloand sudo-exec command
RUN apk add --no-cache su-exec && set -ex && apk --no-cache add sudo

# Set JAVA environment
ENV JAVA_VERSION jdk-17.0.5+8-jre
ENV JAVA_HOME /opt/java/current
ENV PATH ${PATH}:${JAVA_HOME}/bin

# Add Jdk
ADD source/$JAVA_VERSION.tar.gz /opt/java
RUN ln -s /opt/java/$JAVA_VERSION /opt/java/current &&\
  rm -rf $JAVA_HOME/*src.zip
           
#Add date
RUN apk add --update --no-cache tzdata
# ENV TZ=Europe/Rome depends on timezone

#Add busybox-extras
RUN apk add --no-cache busybox-extras

#Add local app
ENV APP_VERSION 0.0.1-SNAPSHOT
COPY ../target/demo-${APP_VERSION}.jar /app-${VERSION}.jar
ENTRYPOINT java -Djava.security.egd=file:/dev/./urandom $JAVA_OPTS -jar /app-${VERSION}.jar