#!/usr/bin/env bash
#override first
echo "host game_state   all    10.5.0.0/16  trust" > "${PGDATA}/pg_hba.conf"
echo "host all   all    10.5.0.0/16  trust" >> "${PGDATA}/pg_hba.conf"
echo "host game_state   all    10.5.0.0/16  md5" >> "${PGDATA}/pg_hba.conf"
#echo "hostssl   game_state    all    10.5.0.0/16    md5" >> "${PGDATA}/pg_hba.conf"