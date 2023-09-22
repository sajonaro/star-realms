(ns game.control-game.view
   (:require [hiccup2.core :as h]
            [hiccup.form :as form]))

(defn -home-view [username]
  [:html
   [:body
    [:h3 (format "welcome, %S " username)]]])


#dbg
(defn get-view [req]
  (str (h/html (-home-view req))))
