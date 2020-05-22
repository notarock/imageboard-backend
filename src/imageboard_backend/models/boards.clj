(ns imageboard-backend.models.boards
  (:require [toucan.db :as db]
            [toucan.models :refer :all]))

;; define the Board model
(defmodel Board :board)

(defn get-boards []
  {:boards (Board)})

(defn board-by-abbrev [abb]
  (db/select Board :abbreviation abb))

;; (db/update-where! (Board 1))
;
; (db/delete! Board :id 1)
;
; (Board)
;
; (db/insert! Board :id 1 :name "Technology" :postsCount 10000)
