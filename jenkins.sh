#! /bin/bash

npm install
npm run docs:build

docker build -t nauam/docs .
docker login -u "nauam" -p "TDT7q76Tta2Ea" docker.io
docker tag nauam/docs:latest nauam/docs:latest
docker push nauam/docs:latest
