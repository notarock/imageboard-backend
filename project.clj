(defproject imageboard-backend "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [ring/ring-json "0.5.0"]
                 [compojure "1.6.1"]
                 [toucan "1.15.1"]
                 [org.postgresql/postgresql "42.2.4"]
                 [environ "0.5.0"]
                 [migratus "1.2.8"]
                 [ring/ring-defaults "0.3.2"]]
  :env {:app-env DEV
        :db-host "localhost" 
        :db-port "5432" 
        :db-name "imageboard"
        :db-user "imageboard"
        :db-pass "some-secret"}
  :migratus {:store :database
             :migration-dir "migrations"
             :db {:classname "com.postgresql.jdbc.Driver"
                  :subprotocol "postgresql"
                  :subname "//localhost/imageboard"
                  :user "imageboard"
                  :password "some-secret"}}
  :plugins [[lein-ring "0.12.5"]
            [migratus-lein "0.7.3"]
            [lein-environ "1.1.0"] ]
  :ring {:handler imageboard-backend.handler/app
         :nrepl {:start? true} }
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring/ring-mock "0.3.2"]]}})
