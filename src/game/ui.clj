(ns game.ui)


(defn home-view [count]
  [:html
   [:body
    [:h1 "Welcome to starrealms!"]
    [:ul
     (for [i (range count)]
       [:li i])]]])

