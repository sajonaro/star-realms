(ns game.control-game.view
   (:require [game.common.layout :as cl]
             [hiccup.element :refer [link-to]] ))

(defn -view [username]
  [:span
   [:span {:class "bold-gold"} (format "player: %S " username)]
   [:span (link-to {:class "sign-out-button"} "/" "log out")]])


(defn get-view [username]
  (cl/application "starrealms: game management" (-view username) nil nil nil nil))
