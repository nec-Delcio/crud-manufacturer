
FROM node:20.11.0 AS build
WORKDIR /app

COPY package*.json ./
RUN yarn 
COPY . .
RUN yarn build

FROM nginx:alpine
COPY --from=build /app/dist /usr/share/nginx/html
EXPOSE 5173
CMD ["nginx", "-g", "daemon off;"]