(ns game.common.html-template
  (:require [hiccup.page :refer [html5 include-css include-js]]))

(defn htmlapp [content]
  (html5 [:head
          [:title "star realms game server"]
            (include-css "styles/.css")
            (include-js "https://cdn.jsdelivr.net/npm/vue@2/dist/vue.js")
              [:body
                [:div#app content]
                (include-js "js/app.js")]]))



