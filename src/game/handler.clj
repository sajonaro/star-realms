(ns game.handler
(:gen-class)
 (:require [ring.adapter.jetty :as ring]
           [ring.middleware.defaults :as ring-def]
           [ring.middleware.file :refer [wrap-file]]
           [muuntaja.middleware :refer [wrap-format]]
           [compojure.core :refer [GET POST defroutes ]]
           [clojure.pprint :as pp]
           [game.views.ui :as ui ]
           [game.common.html-template :refer [htmlapp]]))

(defonce server (atom nil))

(defroutes routes
  (GET "/" [] (htmlapp (ui/login)))
  (POST "/" [:as req] (htmlapp (ui/control-game (:name (:params req))) ))
  (GET "/:foo" [foo]
    {:status 200
     :body (str "you asked for " foo)})
  (POST "/api" [:as req]
    (pp/pprint (:body-params req))
    {:status 200
     :body {:hello 123}}))


;;; disable CSRF protection 
(def config (assoc-in ring-def/site-defaults [:security :anti-forgery] false)) 


 (def app  (-> routes
               (wrap-file "resources/public")
               (wrap-format)
               (ring-def/wrap-defaults config)))


(defn start-jetty! [port]
  (reset! server
   (ring/run-jetty #'app {:join? false :port port})))

(defn -main [] 
  (let [port (Integer. (or (System/getenv "PORT") "3000"))]
   (start-jetty! port)))
