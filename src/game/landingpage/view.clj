(ns game.landingpage.view
  (:require [hiccup.form :as hf]
            [game.common.layout :as cl]))


(defn -input-name-view []
  (hf/form-to [:post "/"]
              [:p {:class "screamimg-yellow-title"} "input your name to connect"]
              (hf/text-field  "name")
              (hf/submit-button "OK")))


(defn get-view []
  (cl/application "starrealms" nil nil  (-input-name-view) nil nil))
