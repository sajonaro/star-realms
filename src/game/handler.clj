(ns game.handler
(:gen-class)
 (:require [ring.adapter.jetty :as ring]
           [ring.middleware.defaults :as ring-def]
           [muuntaja.middleware :as muuntaja]
           [compojure.core :as c]
           [clojure.pprint :as pp]
           [game.landingpage.view :as lp]
           [game.control-game.view :as cg]))

(defonce server (atom nil))

#dbg
(c/defroutes routes
  (c/POST "/" [:as req]
   {:status 200
    :headers {"Content-Type" "text/html"}
    :body (cg/get-view (:name (:params req)))})
  (c/GET "/" [_] (lp/get-view))
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

#dbg
(defn -main [] 
  (let [port (Integer. (or (System/getenv "PORT") "3000"))]
   (start-jetty! port)))



(-main)


