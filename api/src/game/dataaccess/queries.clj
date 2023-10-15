(ns game.dataaccess.queries)


(def select-all-games {:select [:*]
                       :from [:games]})

(defn select-game-by-id [id]
  {:select [:*]
   :from [:games]
   :where [:= :id id]})

