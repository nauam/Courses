FROM node:erbium-buster-slim

COPY . ./tmp

RUN npm install http-server -g

RUN cd tmp/ && \
    npm install && \
    npm run docs:build && \
    cd ..

RUN mkdir app
RUN mv tmp/docs/.vuepress/dist app/docs
RUN mkdir app/assets 
RUN mv app/docs/assets/img app/assets/img

RUN rm -r tmp

EXPOSE  4441

CMD ["http-server", "app", "-p4441", "-o/docs"]