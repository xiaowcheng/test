#!/usr/bin/env bash

mvn clean package compile -Dmaven.test.skip=true

docker build -t hub.ebupt.com/txcyapi/microservice-fenqu-customer:0.0.1 .
docker push hub.ebupt.com/txcyapi/microservice-fenqu-customer:0.0.1