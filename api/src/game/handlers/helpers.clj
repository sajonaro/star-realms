(ns game.handlers.helpers
(:require
 [clojure.data.json :as json]
 [game.dataaccess.adapter :as db]))

(defn json-response[data]
   {:status 200
   :headers {"Content-Type" "text/json"}
   :body (json/write-str data)})


(defn run-query [query]
  (-> query
      (db/run-query)
      (json-response)))