(ns game.handlers.login
  (:require
   [clojure.data.json :as json]))


(defn connect-player-handler [req]
  (let [player_name (-> req :params :name)]
    {:status 200
     :headers {"Content-Type" "text/json"}
     :body (json/write-str {:player_name player_name
                            :player_id (java.util.UUID/randomUUID)})}))
(defn join-game-handler [game-id player-id]
  {:status 200
   :headers {"Content-Type" "text/json"}
   :body (json/write-str {:game-id game-id
                          :player-id player-id})})



