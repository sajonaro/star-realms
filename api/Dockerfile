#Build stage
FROM clojure:temurin-17-alpine AS stage--builder

#building  app's jar
RUN mkdir /build

COPY . /build

WORKDIR /build

RUN clojure -T:build uber

ENTRYPOINT java -cp target/starrealms.jar clojure.main -m game.handler

