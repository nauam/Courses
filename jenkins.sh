#! /bin/bash

npm install
npm run docs:build

docker build -t qwsoftware/docs .
docker login -u "nauam" -p "TDT7q76Tta2Ea" docker.io
docker tag qwsoftware/docs:latest qwsoftware/docs:$1
docker push qwsoftware/docs:$1
