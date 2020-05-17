(ns imageboard-backend.database.db
  (:require [toucan.db :as db]
           [environ.core :refer [env]]))

(println (env :app-env))

(def db-spec
  {:dbtype   "postgres"
   :dbname   (env :db-name)
   :hostname "localhost"
   :port     (env :db-port)
   :user     (env :db-user)
   :password (env :db-pass)})

(println db-spec)

(db/set-default-db-connection! db-spec)
