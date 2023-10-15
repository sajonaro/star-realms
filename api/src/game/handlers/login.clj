(ns game.handlers.login
  (:require
   [game.handlers.helpers :as h]))

(defn connect-player-handler [req]
  (let [player_name (-> req :params :name)]
    (h/json-response {:player_name player_name
                      :player_id (java.util.UUID/randomUUID)})))

(defn join-game-handler [game-id player-id]
  (h/json-response {:game-id game-id
                    :player-id player-id}))



