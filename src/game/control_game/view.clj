(ns game.control-game.view
   (:require [game.common.layout :as cl]
             [hiccup.element :refer [link-to]] ))

(defn -view [username]
  [:div 
   [:h3 (format "player, %S " username)]
   [:div (link-to {:class "link-button"} "/" "log out")]])


(defn get-view [username]
  (cl/application "starrealms: game management" (-view username) nil))
