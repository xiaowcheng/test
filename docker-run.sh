#!/usr/bin/env bash

docker run -d \
    --name microservice-fenqu-customer \
    -p 10002:10002\
    --env JAVA_OPTS=-Xmx256M \
    hub.ebupt.com/txcyapi/microservice-fenqu-customer:0.0.1