FROM postgres:16-alpine
COPY init.sql /docker-entrypoint-initdb.d/
COPY update_hba.sh /docker-entrypoint-initdb.d/
COPY upgdate_config.sh /docker-entrypoint-initdb.d/