(ns migrations.conf
  (:require [migratus.core :as migratus]))

(require '[environ.core :refer [env]])

(def config {:store :database
             :migration-dir "./src/migrations/"
             :init-script "init.sql"
             :init-in-transaction? false
             :migration-table-name "migrations_table"
             :db {:classname "org.postgresql.Driver"
                  :subprotocol "postgresql"
                  :user (env :db-user)
                  :password (env :db-pass)
                  :subname "//db:5432/comments_database"}})

(println config)

(defn initialize [] (migratus/init config))

(defn run-all-migrations [] (migratus/migrate config))

(defn generate [name] (migratus/create config name))

(migratus/migrate config)
