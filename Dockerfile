FROM openjdk:8u181-alpine3.8

WORKDIR /

COPY target/star-realms.jar star-realms.jar
EXPOSE 4040

CMD java -jar star-realms.jar
