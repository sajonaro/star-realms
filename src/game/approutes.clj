(ns game.approutes
  (:require [compojure.core :as c]
            [compojure.route :as route]
            [clojure.pprint :as pp]
            [game.ui :as ui]
            [hiccup2.core :as h]))

(defn get-routes []
  (c/routes
   (c/GET "/" [count]
     {:status 200
      :headers {"Content-Type" "text/html"}
      :body (str (h/html (ui/home-view (Integer. (or count 0)))))})
   (c/GET "/:foo" [foo]
     {:status 200
      :body (str "you asked for " foo)})
   (c/POST "/api" [:as req]
     (pp/pprint (:body-params req))
     {:status 200
      :body {:hello 123}})))