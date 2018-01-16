(ns guppy-gae.core
  (:gen-class)
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [guppy-gae.version :refer :all]))

(def project-version (get-version 'guppy-gae))

(defn -main
  "CLI Placeholder"
  [& args]
  (println (str "Guppy v" project-version)))

(defroutes handler
  (GET "/" [] (str "<h1>Welcome to Guppy v" project-version "!</h1>"))
  (route/not-found "<h1>Sorry friendo, your page is not here.</h1>"))
