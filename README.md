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
npm install http-server -g && \

#remover docs/.vuepress/docs
rm -r docs/.vuepress/docs && \
rm -r docs/.vuepress/assets && \

#build
#nvm install lts/erbium; nvm use lts/erbium && \
yarn install && \
yarn run docs:build && \

#renomear dist para docs
mv docs/.vuepress/dist docs/.vuepress/docs && \

#copiar assets
cp -r docs/.vuepress/docs/assets docs/.vuepress/ && \

#Abrir na porta http://localhost:8080/docs  ###em config.js incluir  "base: `/docs/`" 
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
docker build -t nauamidvlab/docs .
docker run --name qwcontrol_docs --restart=always -p 4441:4441 -d nauamidvlab/docs
docker image ls
docker tag  rundeck/rundeck:SNAPSHOT qwsoftware/vernet:$1
docker login
docker ps
```
