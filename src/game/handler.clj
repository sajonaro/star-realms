(ns game.handler
(:gen-class)
 (:require [ring.adapter.jetty :as jetty]
           [ring.middleware.defaults :as ring-def]
           #_[muuntaja.core :as m]
           [muuntaja.middleware :as muuntaja]
           [game.approutes :as routing]))

(defonce server (atom nil))

(defn apply-routes-handler [req]
  ((routing/get-routes) req))

(defn start-jetty! []
  (reset! server
   (jetty/run-jetty
     (ring-def/wrap-defaults
       (muuntaja/wrap-format
         apply-routes-handler)
     ring-def/api-defaults) 
    {:join? false
     :port 3000})))

(defn -main [& args]
  (start-jetty!))

(defn stop-jetty! []
  (.stop @server)
  (reset! server nil))