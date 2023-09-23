(ns game.landingpage.view
  (:require [hiccup.form :as hf]
            [game.common.layout :as cl]))


(defn -input-name-view []
  [:div  (hf/form-to [:post "/"]
               [:p {:cclass "stack"} "input your name to connect"]
               (hf/text-field {:class "stack"} "name" )
               (hf/submit-button "OK"))])


(defn get-view []
  (cl/application "starrealms" (-input-name-view) nil))
