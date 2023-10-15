(ns game.handlers.games
  (:require
   [game.handlers.helpers :as h]))


(defn get-by-id [id]
  (h/run-query {:select [:*]
                :from [:Game]
                :where [:= :id id]}))


(defn get-all []
  (h/run-query {:select [:*]
                :from [:Game]}))