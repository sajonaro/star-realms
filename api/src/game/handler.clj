(ns game.handler
(:gen-class)
 (:require [ring.adapter.jetty :as ring]
           [ring.middleware.defaults :as ring-def]
           [compojure.core :refer [GET POST PUT defroutes context]]
           [game.handlers.login :as login]
           [game.handlers.games :as games]))

(defonce server (atom nil))

(defroutes routes
  (context "/api" []
    (POST "/connect" [] login/connect-player-handler)
    (PUT  "/game/:game-id/join/:player-id" [game-id player-id] (login/join-game-handler game-id player-id))
    (GET "/games/:id" [id] (games/get-by-id id))
    (GET "/games" [] (games/get-all))))


;;; disable CSRF protection 
(def config (assoc-in ring-def/site-defaults [:security :anti-forgery] false)) 


 (def app  (-> routes
               (ring-def/wrap-defaults config)))


(defn start-jetty! [port]
  (reset! server
   (ring/run-jetty #'app {:join? false :port port})))

(defn -main [] 
  (let [port (Integer. (or (System/getenv "PORT") "4040"))]
   (start-jetty! port)))