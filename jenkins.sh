#! /bin/bash

docker login -u "idvlab" -p "VL84xFUAu5h2N" docker.io

docker container rm $(docker ps -f name=qwcontrol -q) --force
docker container rm $(docker ps -f name=nginx -q) --force
docker image rm $(docker images qwsoftware/homolog -q) --force
docker image rm $(docker images qwsoftware/docs -q) --force
docker image rm $(docker images nginx -q) --force

export TAG=$1
docker-compose up -d
