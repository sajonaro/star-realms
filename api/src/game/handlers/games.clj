(ns game.handlers.games
  (:require
   [game.handlers.helpers :as h]))


(defn get-by-id [id]
  (h/run-query-get-json-response {:select [:*]
                :from [:game]
                :where [:= :id id]}))

#break
(defn get-all []
  (h/run-query-get-json-response {:select [:*]
                :from [:game]}))


(get-all)