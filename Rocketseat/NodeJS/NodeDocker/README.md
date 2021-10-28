# Ambiente de desenvolvimento NodeJS com Docker e Docker Compose | Diego Fernandes

## Install

```sh
npm init -y
npm install express
```

## Create files

```sh
touch index.js
touch Dockerfile
touch .dockerignore
```

## Add

In index.js

```sh
const express = require('express');

const PORT = 3000;
const HOST = '0.0.0.0';

const app = express();

app.get('/', (req, res) => {
    res.send('Hello World');
});

app.listen(PORT, HOST);
```

In package.json

```sh
"scripts": {
    "start": "node index.js"
}
```

In Dockerfile

```sh
FROM node:alpine

WORKDIR /usr/app

COPY package*.json ./
RUN npm install

COPY . .

EXPOSE 3000

CMD ["npm", "start"]
```

In .dockerignore

```sh
node_modules
```

## Run

```sh
docker build -t nauam/dockernode .
docker run -p 3000:3000 -d nauam/dockernode
docker ps
```

## Docker-compose

## Create files

```sh
touch docker-compose.yml
```
## Add

In docker-compose.yml

```sh
version: "3"

services:
    app:
        build: .
        command: npm start
        ports: 
            - "3000:3000"
        volumes:
            - .:/usr/app
```

## install Nodemon

```sh
npm install nodemon
```
