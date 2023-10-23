(ns game.dataaccess.queries)


(def select-all-games {:select [:*]
                       :from [:Game]})

(defn select-game-by-id [id]
  {:select [:*]
   :from [:Game]
   :where [:= :id id]})

