(ns game.handler
  (:gen-class)
  (:require [compojure.core :as c]
            [compojure.route :as route]
            [ring.adapter.jetty :as jetty]
            [ring.middleware.defaults :as ring-defaults]
            [muuntaja.middleware :as muuntaja]))

(defonce server (atom nil))

(c/defroutes app-routes
  (c/GET "/" [] "Hello World")
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (ring-defaults/wrap-defaults app-routes ring-defaults/api-defaults))

(defn handler [req]
  ((app-routes) req))

(defn start-jetty! []
  (reset! server
   (jetty/run-jetty (-> #'handler
                        muuntaja/wrap-format
                        (ring-defaults/wrap-defaults ring-defaults/api-defaults))
                    {:join? false
                     :port 3000})))

(defn -main [& args]
  (start-jetty!))