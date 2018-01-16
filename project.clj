(defproject guppy-gae "0.1.0-SNAPSHOT"
  :description "A lightweight clojure web platform for the Google App Engine"
  :url "https://github.com/gneissguise/guppy-gae"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [ring "1.6.3"]
                 [compojure "1.6.0"]]
  :plugins [[lein-ring "0.12.3":exclusions [org.clojure/clojure]]]
  :main ^:skip-aot guppy-gae.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}}
  :ring {:handler guppy-gae.core/handler})


