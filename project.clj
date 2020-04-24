(defproject imageboard-backend "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [ring/ring-json "0.5.0"]
                 [compojure "1.6.1"]
                 [toucan "1.15.1"]
                 [lynxeyes/dotenv "1.0.2"]
                 [ring/ring-defaults "0.3.2"]]
  :plugins [[lein-ring "0.12.5"]]
  :ring {:handler imageboard-backend.handler/app
         :nrepl {:start? true} }
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring/ring-mock "0.3.2"]]}})
