FROM node:erbium-buster-slim

COPY ./docs/.vuepress/dist /docs

RUN mkdir assets && \
    mv docs/assets/img assets/img

RUN npm install http-server -g

EXPOSE  4441

CMD ["http-server", "-p4441"]
