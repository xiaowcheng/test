#!/usr/bin/env bash

mvn clean package

docker build -t hub.ebupt.com/library/eureka.jar:1.0 .
docker push hub.ebupt.com/library/eureka.jar:1.0