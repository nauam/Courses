FROM node:erbium-buster-slim

WORKDIR /app

COPY ./docs/.vuepress/dist /app/docs

RUN npm install http-server -g

EXPOSE  4441

CMD ["http-server", "-p4441", "-o/docs"]
