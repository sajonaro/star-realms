(ns game.dataaccess.hikari_adapter
  (:require [hikari-cp.core :refer [make-datasource ]] 
            [clojure.java.jdbc :as jdbc]
            [clojure.edn :as edn]))

(def local (edn/read-string (slurp "local_vars.edn")))

(def datasource-options
  (if (some? (System/getenv "DB_NAME"))
    {:auto-commit        true
    :read-only          false
    :connection-timeout 30000
    :validation-timeout 5000
    :idle-timeout       600000
    :max-lifetime       1800000
    :minimum-idle       10
    :maximum-pool-size  10
    :pool-name          "db-pool"
    :adapter            "postgresql"
    :username           (System/getenv "DB_USER")
    :password           (System/getenv "DB_PASSWORD")
    :database-name      (System/getenv "DB_NAME")
    :server-name        (System/getenv "DB_SERVER")
    :port-number        5432
    :register-mbeans    false}
    
    {:auto-commit        true
     :read-only          false
     :connection-timeout 30000
     :validation-timeout 5000
     :idle-timeout       600000
     :max-lifetime       1800000
     :minimum-idle       10
     :maximum-pool-size  10
     :pool-name          "db-pool"
     :adapter            (local :dbtype)
     :username           (local :user)
     :password           (local :password)
     :database-name      (local :dbname)
     :server-name        (local :host)
     :port-number        5432
     :register-mbeans    false}))

(defonce datasource
  (delay (make-datasource datasource-options)))

(def conn {:datasource @datasource})

(defn run-query [sql-query]
    (jdbc/query conn sql-query))
