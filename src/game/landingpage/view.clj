(ns game.landingpage.view
  (:require [hiccup2.core :as h]
            [hiccup.form :as form]))


(defn -home-view []
  [:html
   [:body
    [:h3 "Welcome to starrealms!"]
    [:div {:id "shout-form" :class "sixteen columns alpha omega"}
     (form/form-to [:post "/"]
                   (form/label "username" "input your name to connect")
                   (form/text-field "name")
                   (form/submit-button "OK"))]]])


(defn get-view []
  (str (h/html (-home-view ))))
