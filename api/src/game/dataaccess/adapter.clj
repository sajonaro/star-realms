(ns game.dataaccess.adapter
  (:require [clojure.java.jdbc :as jdbc]
            [clojure.edn :as edn]))




(def local (edn/read-string (slurp "local_vars.edn")))

 
(def db
  (if (some? (System/getenv "DB_NAME"))
    {:dbtype "postgresql"
     :port 5432
     :dbname (System/getenv "DB_NAME")
     :host (System/getenv "DB_SERVER")
     :user (System/getenv "DB_USER")
     :password (System/getenv "DB_PASSWORD")}

    "jdbc:postgresql://localhost:5432/game_state?user=starrealms_app&password=pwd&ssl=false"))


(defn run-query [sql-query]
  (println sql-query)
  ;;(jdbc/query db [sql-query]))
  ;;(jdbc/query db ["SELECT current_database()"]))
  (jdbc/query db ["SELECT * from Game"]))
  
