#! /bin/bash

npm install
npm run docs:build
cp -r docs/assets/ docs/.vuepress/dist/

docker build -t qwsoftware/docs .
docker login -u "idvlab" -p "VL84xFUAu5h2N" docker.io
docker tag qwsoftware/docs:latest qwsoftware/docs:$1
docker push qwsoftware/docs:$1
