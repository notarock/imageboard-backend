(ns imageboard-backend.models.boards
  (:require [toucan.db :as db]
            [toucan.models :refer :all]))

;; define the Board model
(defmodel Board :board)

;; I used this to create boards interactively.
;; probably shoueld be used in a migration, on something.
;;
;; (db/insert! Board :id 1 :name "Technology")

(defn get-boards []
  {:boards (Board)})
