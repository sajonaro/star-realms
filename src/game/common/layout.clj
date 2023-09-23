(ns game.common.layout
  (:require [hiccup.page :refer [html5 include-css include-js]]))

(defn application [title head-content content]
  (html5 {:ng-app "myApp" :lang "en"}
         [:head
          [:title title]
          (include-css "//cdn.jsdelivr.net/npm/picnic")
          (include-js "http://code.angularjs.org/1.2.3/angular.min.js")
          (include-js "js/ui-bootstrap-tpls-0.7.0.min.js")
          (include-js "js/script.js")

          [:body 
           [:div {:class "top"} head-content]
           [:hr]
                
           [:div {:class "container"} content ]]]))



