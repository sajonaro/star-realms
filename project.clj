(defproject game "starrealms"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [compojure/compojure "1.6.2"]
                 [ring/ring-defaults "0.3.3"]
                 [ring/ring-jetty-adapter "1.9.4"]
                 [hiccup/hiccup "2.0.0-alpha2"]
                 [metosin/muuntaja "0.6.8"]]
  
  
  :plugins [[lein-ring "0.12.6"]]
  :ring {:handler game.handler/app
         :port 3000} 
  :uberjar-name "starrealms.jar"
  :main game.handler
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring/ring-mock "0.3.2"]]}})
