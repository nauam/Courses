# QW Control Documentation

QW Control Documentation project.

## Getting starting

### Dependencies

* NVM - Gerenciador de Versões do Node

```sh
  curl -o- https://raw.githubusercontent.com/nvm-sh/nvm/v0.35.3/install.sh | bash
  source ~/.bashrc
  nvm list-remote
  nvm install lts/erbium; nvm use lts/erbium
```

* YARN

```sh
  sudo apt install npm
  sudo npm install --global yarn
```

### Recommended setup steps

Run this before the first you start the docs site locally.

```sh
yarn install
```

### Run the QW Control Docs site locally

```sh
yarn run docs:dev
```

> Compiles and hot-reloads for development. As (most) content changes are made they show up immediately.  Changes to the menus will require quitting and restarting with the command above.

### Running in Production

> Compiles and minifies for production.

```sh
yarn run docs:build
```

### Running diretory dist in localhost:8080

1. Have Node.js installed in your system.

2. Navigate to the specific path of your file folder

```sh
#remover docs/.vuepress/docs
rm -r docs/.vuepress/docs && \
#build
nvm install lts/erbium; nvm use lts/erbium && \
yarn install && \
yarn run docs:build && \

#renomear dist para docs
mv docs/.vuepress/dist docs/.vuepress/docs && \

#Abrir na porta http://localhost:8080/docs  ###em config.js incluir  "base: `/docs/`" 
npm install http-server -g && \
http-server docs/.vuepress/ -o /docs
```

3. Go to your browser and type localhost:8080. Your Application should run there.

## Docker

### build

## Create files

```sh
touch Dockerfile \ .dockerignore
```

## Run

```sh
rm -r docs/.vuepress/docs && \
#build
nvm install lts/erbium; nvm use lts/erbium && \
yarn install && \
yarn run docs:build && \
cp -r docs/assets/ docs/.vuepress/dist/  && \

docker build -t nauam/docs . && \
docker image ls && \
docker run --name qwcontrol_docs --restart=always -p 4441:4441 -d nauam/docs && \
docker ps
```

## Push Docker Hub

```sh
docker login -u "nauam" -p "TDT7q76Tta2Ea" docker.io
docker tag nauam/docs:latest nauam/docs:latest
docker push nauam/docs:latest
```

## Pull QWControl

```sh
docker pull qwsoftware/homolog:v1246
docker pull qwsoftware/homolog:v1246
docker run -d -e TZ=America/Sao_Paulo --name qwcontrol -p 4440:4440 --net host --privileged --restart=always --env-file=/etc/qwcontrol.conf -v data:/home/qwcontrol/server/data qwsoftware/vernet:V123
```
docker rm 9dc62b654735
docker rm a804355c5eb8
docker rm c114cc362851
docker rm e741981c148f
docker rm e1ed2915278c
docker rm 9be8a8a3e2af
docker rm 4aafd7f15e24
docker rm 326ad2b08cde
docker rm a6728b97e96e