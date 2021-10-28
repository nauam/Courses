#! /bin/bash

npm install
npm run docs:build
cp -r docs/assets/ docs/.vuepress/dist/

docker build -t <rep_docker_hub>/docs .
docker login -u "user" -p "pass" docker.io
docker tag <rep_docker_hub>/docs <rep_docker_hub>/docs:$1
docker push <rep_docker_hub>/docs:$1
