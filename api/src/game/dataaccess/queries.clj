(ns game.dataaccess.queries)


(def select-all-games {:select [:*]
                       :from [:Games]})

(defn select-game-by-id [id]
  {:select [:*]
   :from [:Games]
   :where [:= :id id]})

