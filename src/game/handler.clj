(ns game.handler
(:gen-class)
 (:require [compojure.core :as c]
           [compojure.route :as route]
           [ring.adapter.jetty :as jetty]
           [ring.middleware.defaults :as ring-defaults]
           [hiccup2.core :as h]
           #_[muuntaja.core :as m]
           [muuntaja.middleware :as muuntaja]))

(defonce server (atom nil))

(defn home-view [count]
  [:html
   [:body
    [:h1 "Welcome to starrealms!"]
    [:ul
     (for [i (range count)]
       [:li i])]]])

(defn routes []
  (c/routes
   (c/GET "/" [count]
     {:status 200
      :headers {"Content-Type" "text/html"}
      :body (str (h/html (home-view (Integer. (or count 0)))))})
   (c/GET "/:foo" [foo]
     {:status 200
      :body (str "you asked for " foo)})
   (c/POST "/api" [:as req]
     (clojure.pprint/pprint (:body-params req))
     {:status 200
      :body {:hello 123}})))

(defn handler [req]
  ((routes) req))

(defn start-jetty! []
  (reset!
   server
   (jetty/run-jetty (-> #'handler
                        muuntaja/wrap-format
                        (ring-defaults/wrap-defaults ring-defaults/api-defaults))
                    {:join? false
                     :port 3000})))

(defn stop-jetty! []
  (.stop @server)
  (reset! server nil))

(defn -main [& args]
  (start-jetty!))
