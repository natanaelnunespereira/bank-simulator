FROM mysql:8.0.30

ENV MYSQL_ROOT_PASSWORD=qwe123
COPY ./script-create-cadastro_banco.sql /docker-entrypoint-initdb.d/
EXPOSE 3306
