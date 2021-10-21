FROM node:erbium-buster-slim

RUN mkdir app

COPY ./docs/.vuepress/dist /app/docs

RUN mkdir app/assets && \
    mv app/docs/assets/img app/assets/img

RUN npm install http-server -g

EXPOSE  4441

CMD ["http-server", "app/docs", "-p4441"]
