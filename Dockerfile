FROM openjdk:11

WORKDIR /

COPY target/star-realms.jar star-realms.jar
EXPOSE 3000

CMD java -jar star-realms.jar
