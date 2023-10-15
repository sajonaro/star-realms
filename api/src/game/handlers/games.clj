(ns game.handlers.games
  (:require
   [clojure.data.json :as json]))


(defn get-by-id [id]
    {:status 200
     :headers {"Content-Type" "text/json"}
     :body (json/write-str {:game_id id})})