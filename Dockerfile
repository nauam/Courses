FROM node:erbium-buster-slim

RUN mkdir app
COPY ./docs/.vuepress/docs ./app/docs

RUN npm install http-server -g

RUN cd tmp/ && \
    npm install && \
    npm run docs:build && \
    cd ..

RUN mkdir app/assets && \
    mv app/docs/assets/img app/assets/img

RUN rm -r tmp

EXPOSE  4441

CMD ["http-server", "app", "-p4441", "-o/docs"]

FROM httpd:2.4

COPY ./docs/.vuepress/docs /usr/local/apache2/htdocs/docs
COPY ./docs/.vuepress/assets /usr/local/apache2/htdocs/assets

EXPOSE  4441

CMD ["http-server", "app", "-p4441", "-o/docs"]
