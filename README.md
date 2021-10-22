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
#build
nvm install lts/erbium; nvm use lts/erbium
yarn install
yarn run docs:build

#renomear dist para docs
mv docs/.vuepress/dist docs/.vuepress/docs

#Abrir na porta http://localhost:8080/docs
npm install http-server -g && http-server docs/.vuepress/ -o /docs
```

## Docker

### build

```sh
nvm install lts/erbium; nvm use lts/erbium
yarn install
yarn run docs:build
```

### Run

```sh
cp -r docs/assets/ docs/.vuepress/dist/

docker build -t qwsoftware/docs .
docker image ls
docker run --name qwcontrol_docs --restart=always -p 4441:4441 -d qwsoftware/docs
docker ps
```

## Push Docker Hub

```sh
docker login -u "user" -p "senha" docker.io
docker tag qwsoftware/docs qwsoftware/docs:v1.2.4.9
docker push qwsoftware/docs:v1.2.4.9
```

## Pull QWControl

```sh
docker pull qwsoftware/docs:v1.2.4.9
docker run -d -e TZ=America/Sao_Paulo --name qwcontrol_docs --net host --privileged --restart=always qwsoftware/docs:v1.2.4.9
```
