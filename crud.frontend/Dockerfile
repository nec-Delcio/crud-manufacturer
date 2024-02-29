
FROM node:20.11.0 AS builder
WORKDIR /app
COPY package.json package-lock.json ./
RUN yarn 
COPY . .
RUN yarn build
FROM nginx:alpine
COPY --from=builder /app/build /usr/share/nginx/html
EXPOSE 5173
CMD ["nginx", "-g", "daemon off;"]