(ns imageboard-backend.models.posts
  (:require [toucan.db :as db]
            [toucan.models :refer :all]))

(def post
  {:id 12334
   :name "[This is the name of my post]",
   :content "Dolorem omnis autem velit recusandae aliquid dolorem corrupti totam.
 Quis aliquam mollitia adipisci qui debitis voluptatem amet molestias. Aut quaerat dicta ratione dolore et.
 Nihil adipisci repellat repellendus et qui accusamus. Enim saepe dolores omnis voluptates.
 Beatae velit voluptatem id. Ipsa voluptatem excepturi eligendi.",
   :uri "https://source.unsplash.com/random"})

(defn make-post [id]
  (assoc post :id id))

(def posts
  (map make-post (range 0 20)))

(defn get-posts [id]
  {:posts [(make-post (str id 1)) (make-post (str id 2))]})

;; define the User model
(defmodel Post :post
  IModel
  (types [this] ;; tell Toucan to automatically do Keyword <-> String conversion for :status
         {:title :content :uri :createdAt}))

(db/select Post)
