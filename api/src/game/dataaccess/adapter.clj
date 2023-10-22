(ns game.dataaccess.adapter
  (:require [next.jdbc :as jdbc]
            [honey.sql :as sql]))


(def db-config
  {:dbtype "postgresql"
   :dbname (System/getenv "DB_NAME")
   :host (System/getenv "DB_SERVER")
   :user (System/getenv "DB_USER")
   :password (System/getenv "DB_PASSWORD")})

(def db (jdbc/get-datasource db-config))


(defn run-query [hony-sql]
  (jdbc/execute! db (sql/format hony-sql)))
