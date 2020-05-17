(ns imageboard-backend.models.posts
  (:require [toucan.db :as db]
            [toucan.models :refer :all]))

;; define the User model
(defmodel Post :post)

(defn get-posts [id]
  (db/select Post))
