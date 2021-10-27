#!/bin/sh

while [ $# -gt 0 ]; do
    case "$1" in
        qwcontrol) 
            docker container rm $(docker ps -f name=qwcontrol -q) --force;
            docker image rm $(docker images qwsoftware/homolog -q) --force;
            echo "The qwcontrol container and image have been removed.";
            ;;

        docs) 
            docker container rm $(docker ps -f name=docs -q) --force;
            docker image rm $(docker images qwsoftware/docs -q) --force;
            echo "The docs container and image have been removed.";
            ;;

        nginx) 
            docker container rm $(docker ps -f name=nginx -q) --force;
            docker image rm $(docker images nginx -q) --force;
            echo "The nginx container and image have been removed.";
            ;;

        *) 
            export TAG=$1;
            echo "tag: '$1'";
            ;;
    esac
    shift
done   
docker login -u "idvlab" -p "VL84xFUAu5h2N" docker.io
docker-compose up -d
