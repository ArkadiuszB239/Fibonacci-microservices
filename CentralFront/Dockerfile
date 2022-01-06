FROM node:latest as node
WORKDIR /app
COPY ./ .
RUN npm install
RUN npm update
RUN npm install -g typescript

EXPOSE 4200

ENTRYPOINT npm start
