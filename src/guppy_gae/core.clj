(ns guppy-gae.core
  (:gen-class)
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.util.response :refer [response resource-response]]
            [guppy-gae.version :refer :all]))

(def project-version (get-version 'guppy-gae))

(defn -main
  "CLI Placeholder"
  [& args]
  (println (str "Guppy v" project-version)))

(defroutes handler
  (GET "/" [] (resource-response "index.html" {:root "public"}))
  ;;(GET "/css" [] (resource-response "css/"))
  (route/resources "/")
  (route/not-found "<h1>Sorry friendo, your page is not here.</h1>"))
