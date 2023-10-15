(ns game.dataaccess.adapter
  (:require [next.jdbc :as jdbc]
            [honey.sql :as sql]))


(def db-config
  {:dbtype (System/getenv "postgresql")
   :dbname (System/getenv "POSTGRES_DB")
   :host "POSTGRES_DB"
   :user (System/getenv "POSTGRES_USER")
   :password (System/getenv "POSTGRES_PASSWORD")})

(def db (jdbc/get-datasource db-config))


(defn run-query [hony-sql]
  (jdbc/execute! db (sql/format hony-sql)))
