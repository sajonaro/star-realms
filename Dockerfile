#Build stage
FROM clojure:temurin-17-alpine AS stage--builder

RUN mkdir /build
COPY . /build
WORKDIR /build

RUN clojure -T:build uber


#Inherit GraalVM image
FROM ghcr.io/graalvm/graalvm-ce:22 AS stage--graal
RUN gu install native-image
RUN mkdir -p /stuff 
WORKDIR /stuff
COPY --from=stage--builder /build/target/. /stuff

RUN native-image \
        --verbose \
        --report-unsupported-elements-at-runtime \
        --initialize-at-build-time \
        --no-fallback \
        -jar ./starrealms.jar \
        -H:Name=./gameserver  \
        -H:+ReportExceptionStackTraces

EXPOSE 3000        
       
ENTRYPOINT ["./gameserver"]

