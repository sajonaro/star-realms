#!/usr/bin/env bash

echo "password_encryption = md5" >> "${PGDATA}/postgresql.conf"
echo "logging_collector = on" >> "${PGDATA}/postgresql.conf"
echo "log_directory = 'pg_log'" >> "${PGDATA}/postgresql.conf"
echo "log_filename = 'postgresql-dateformat.log'" >> "${PGDATA}/postgresql.conf"
echo "log_statement = 'all'" >> "${PGDATA}/postgresql.conf"


#echo "ssl = on" >> "${PGDATA}/postgresql.conf"

