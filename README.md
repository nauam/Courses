# QW Control Documentation

<p align="center">
  <img src="https://img.shields.io/static/v1?label=node&message=v12&color=green&style=for-the-badge&logo=node.js"/> <img src="https://img.shields.io/static/v1?label=vuepress&message=v1.8&color=green&style=for-the-badge&logo=vuepress"/>
<img src="http://img.shields.io/static/v1?label=STATUS&message=Build&color=green&style=for-the-badge"/> <img src="http://img.shields.io/static/v1?label=OS&message=Debian&color=green&style=for-the-badge"/>
</p>

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

## Running in Production (localhost:8080)

* Navigate to the specific path of your file folder

```sh
yarn run docs:build
```

* Rename dist to docs

```sh
cp -r docs/assets/ docs/.vuepress/dist/
mkdir docs/.vuepress/app
mv docs/.vuepress/dist docs/.vuepress/app/docs
```
* Open http://localhost:8080/docs

```sh
npm install http-server -g
http-server docs/.vuepress/app -p8080 -o /docs
```

## Docker

* Run

```sh
cd 
docker build -t qwsoftware/docs .
docker run --name qwcontrol_docs --restart=always -p 4441:4441 -d qwsoftware/docs
```

* Push Docker Hub

```sh
docker login -u "user" -p "senha" docker.io
docker tag qwsoftware/docs qwsoftware/docs:v1.2.4.9
docker push qwsoftware/docs:v1.2.4.9
```

* Pull Docker Hub
```sh
docker pull qwsoftware/docs:v1.2.4.9
```

```sh
docker run -d -e TZ=America/Sao_Paulo --name qwcontrol_docs --net host --privileged --restart=always qwsoftware/docs:v1.2.4.9
```

## Servidor

```sh
export TAG=v1.2.4.8
docker-compose up -d
```
