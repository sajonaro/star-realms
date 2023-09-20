(ns game.control-game.view
   (:require [hiccup2.core :as h]
            [hiccup.form :as form]))

(defn -home-view []
  [:html
   [:body
    [:h3 "you can create games!"]]])



(defn get-view []
  (str (h/html (-home-view))))
