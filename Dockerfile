FROM node:erbium-buster-slim

COPY ./docs/.vuepress/dist /app

RUN npm install http-server -g

EXPOSE  4441

CMD ["http-server", "app", "-p4441"]
