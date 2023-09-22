(ns game.landingpage.view
  (:require [hiccup2.core :as h]
            [hiccup.form :as hf]
            [hiccup.page :as p]))

(defn common [title & body]
  (p/html5
   [:head
    [:meta {:charset "utf-8"}]
    [:meta {:http-equiv "X-UA-Compatible" :content "IE=edge,chrome=1"}]
    [:meta {:name "viewport" :content
            "width=device-width, initial-scale=1, maximum-scale=1"}]
    [:title title]
    (p/include-css "/stylesheets/base.css"
                   "/stylesheets/skeleton.css"
                   "/stylesheets/screen.css")
    (p/include-css "http://fonts.googleapis.com/css?family=Sigmar+One&v1")]
   [:body
    [:div {:id "header"}
     [:h2 {:class "container"} "Welcome to starrealms!"]]
    [:div {:id "content" :class "container"} body]]))




(defn -input-name-view []
  [:div {:id "shout-form" :class "sixteen columns alpha omega"}
   (hf/form-to [:post "/"]
               (hf/label "username" "input your name to connect")
               (h/raw "<p/>")
               (hf/text-field "name")
               (hf/submit-button "OK"))])


(defn get-view []
  (common "starrealms" (-input-name-view)))
