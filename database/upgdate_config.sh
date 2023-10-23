#!/usr/bin/env bash

echo "password_encryption = md5" >> "${PGDATA}/postgresql.conf"
#echo "ssl = on" >> "${PGDATA}/postgresql.conf"

