(ns game.landingpage.view
  (:require [hiccup2.core :as h]
            [hiccup.form :as hf]
            [game.common.hiccup-templating.views.layout :as cl]))


(defn -input-name-view []
  [:div {:id "shout-form" :class "sixteen columns alpha omega"}
   (hf/form-to [:post "/"]
               (hf/label "username" "input your name to connect")
               [:p]
               (hf/text-field "name")
               (hf/submit-button {:class "btn btn-primary"} "OK"))])


(defn get-view []
  (cl/application "starrealms" (-input-name-view)))
