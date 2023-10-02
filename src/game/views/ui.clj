(ns game.views.ui)


(defn control-game [username]
  [:span
   [:span {:class "bold-gold"} (format "player: %S " username)]
   [:button {:class "sign-out-button"}  "log out"]])

(defn login []
  [:div {:class "container"}
   [:div {:class "in-center"}
    [:p {:class "screamimg-yellow-title"} "input your name to connect"]
    [:input {:v-model "username"}]
    [:button {:v-on:click "login"} "OK"]]])

