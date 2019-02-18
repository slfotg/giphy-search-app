FROM mysql:5.7.25
ENV MYSQL_DATABASE giphy_db
ENV MYSQL_ROOT_PASSWORD rootPassword
ENV MYSQL_USER giphy_user
ENV MYSQL_PASSWORD giphyPassword

COPY ./scripts/ /docker-entrypoint-initdb.d/