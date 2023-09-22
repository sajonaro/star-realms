(ns game.handler
(:gen-class)
 (:require [ring.adapter.jetty :as ring]
           [ring.middleware.defaults :as ring-def]
           [muuntaja.middleware :as muuntaja]
           [compojure.core :refer [GET POST defroutes]]
           [clojure.pprint :as pp]
           [game.landingpage.view :as lp]
           [game.control-game.view :as cg]))

(defonce server (atom nil))

#dbg
(defroutes routes
  (GET "/" [] (lp/get-view))
  (POST "/" [:as req] (cg/get-view (:name (:params req))))
  (GET "/:foo" [foo]
    {:status 200
     :body (str "you asked for " foo)})
  (POST "/api" [:as req]
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

#dbg
(defn -main [] 
  (let [port (Integer. (or (System/getenv "PORT") "3000"))]
   (start-jetty! port)))



(-main)


