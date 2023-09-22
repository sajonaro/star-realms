(ns game.control-game.view
   (:require [game.common.hiccup-templating.views.layout :as cl]
             [hiccup.element :refer [link-to]] ))

(defn -view [username]
  [:div {:class "container"}
   [:h3 (format "welcome, %S " username)]
    [:nav
     [:ul
      [:li (link-to {:class "btn btn-primary"} "/" "create new game")]
      [:li (link-to {:class "btn btn-primary"} "/" "log out")]]]])


#dbg
(defn get-view [username]
  (cl/application "starrealms: game management" (-view username)))
