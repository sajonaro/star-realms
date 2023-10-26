(ns game.handlers.helpers
(:require
 [clojure.data.json :as json]
 [game.dataaccess.hikari_adapter :as db]
 [honey.sql :as sql]))

(defn json-response[data]
   {:status 200
   :headers {"Content-Type" "text/json"}
   :body (json/write-str data)})


(defn run-query-get-json-response [honey-sql-query]
  (-> honey-sql-query
      (sql/format)
      (db/run-query)
      (json-response)))