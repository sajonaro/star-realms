(ns game.handler
(:gen-class)
 (:require [ring.adapter.jetty :as ring]
           [ring.middleware.defaults :as ring-def]
           [ring.middleware.resource :refer [wrap-resource]]
           [muuntaja.middleware :refer [wrap-format]]
           [hiccup.middleware :refer [wrap-base-url]]
           [compojure.core :refer [GET POST defroutes]]
           [compojure.route :as route]
           [clojure.pprint :as pp]
           [game.landingpage.view :as lp]
           [game.control-game.view :as cg]))

(defonce server (atom nil))

(defroutes routes
  (GET "/" [_] (lp/get-view))
  (POST "/" [:as req] (cg/get-view (:name (:params req))))
  (GET "/:foo" [foo]
    {:status 200
     :body (str "you asked for " foo)})
  (POST "/api" [:as req]
    (pp/pprint (:body-params req))
    {:status 200
     :body {:hello 123}})
  (route/resources "/"))


;;; disable CSRF protection 
(def config (assoc-in ring-def/site-defaults [:security :anti-forgery] false)) 


 (def app  (-> routes
               (wrap-resource "public")
               (wrap-resource "")
               (wrap-base-url)
               (wrap-format)
               (ring-def/wrap-defaults config)))


(defn start-jetty! [port]
  (reset! server
   (ring/run-jetty #'app {:join? false :port port})))

(defn -main [] 
  (let [port (Integer. (or (System/getenv "PORT") "3000"))]
   (start-jetty! port)))
