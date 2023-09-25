(ns game.common.layout
  (:require [hiccup.page :refer [html5 include-css include-js]]))

(defn application [title head-content alice center bob footer]
  (html5 {:ng-app "myApp" :lang "en"}
         [:head
          [:title title]
          (include-css "/styles/.css")
          (include-js "http://code.angularjs.org/1.2.3/angular.min.js")
          (include-js "/js/ui-bootstrap-tpls-0.7.0.min.js")
          (include-js "/js/script.js")
          [:body 
           [:div {:class "top-screen"} head-content]
           [:div  alice ]
           [:div {:class "center-screen"} center]
           [:div  bob]
           [:div  footer]]]))



