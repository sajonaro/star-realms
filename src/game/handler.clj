(ns game.handler
(:gen-class)
 (:require [ring.adapter.jetty :as ring]
           [ring.middleware.defaults :as ring-def]
           [muuntaja.middleware :as muuntaja]
           [compojure.core :as c]
           [clojure.pprint :as pp]
           [game.landingpage.view :as lp]))

(defonce server (atom nil))

(c/defroutes routes
 (c/GET "/" [_]
   {:status 200
    :headers {"Content-Type" "text/html"}
    :body (lp/get-view)})
 (c/GET "/:foo" [foo]
   {:status 200
    :body (str "you asked for " foo)})
 (c/POST "/api" [:as req]
   (pp/pprint (:body-params req))
   {:status 200
    :body {:hello 123}}))

(defn apply-routes-handler [req]
  (routes req))

(defn start-jetty! [port]
  (reset! server
   (ring/run-jetty
     (ring-def/wrap-defaults
       (muuntaja/wrap-format
         apply-routes-handler)
     ring-def/api-defaults) 
    {:join? false
     :port port})))

(defn -main [] 
  (let [port (Integer. (or (System/getenv "PORT") "3000"))]
   (start-jetty! port)))