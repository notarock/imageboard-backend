(ns imageboard-backend.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.json :refer [wrap-json-response]]
            [ring.util.response :refer [response]]))


(def post
  {:id 12334
   :name "[This is the name of my post]",
   :content "Dolorem omnis autem velit recusandae aliquid dolorem corrupti totam.
 Quis aliquam mollitia adipisci qui debitis voluptatem amet molestias. Aut quaerat dicta ratione dolore et.
 Nihil adipisci repellat repellendus et qui accusamus. Enim saepe dolores omnis voluptates.
 Tenetur non ipsam laborum nemo. Voluptatem sed similique non voluptatem dolorem amet dicta aut.
 Voluptate quis architecto tempore totam cumque dolor eaque. Explicabo exercitationem dolor officia magnam culpa optio qui.
 Itaque qui cum numquam adipisci ut enim. Amet velit cumque dolorum assumenda fugit omnis eveniet vel.
 Optio ad voluptatem voluptatum. Animi cupiditate consequatur aut soluta ipsam odit.
 Unde architecto porro aspernatur rerum repudiandae veritatis. Amet aperiam aut velit sunt expedita ullam asperiores.
 Aliquam ad ipsum aut similique amet. Dolorem omnis nisi ullam. Non culpa consequuntur perspiciatis libero itaque aut maiores eos.
 Dicta corporis nesciunt perferendis. Labore sit fugit qui sed. Tenetur minima officia voluptas. Aut sequi similique ut ab.
 Qui rerum dolorem est odio praesentium et aut aut. Voluptatum eos non molestias et et. Quia eos facere id reiciendis ullam molestias repudiandae consequatur.
 Et nostrum iure ipsa autem id. Eos ea corporis voluptas. Id repudiandae nisi autem quidem odio voluptatibus labore distinctio.
 Aut veritatis inventore quae aliquid consequatur corrupti suscipit animi. Ratione cupiditate praesentium ipsa amet doloremque.
 Perspiciatis velit laudantium distinctio rerum non harum. Minima et quo soluta. Dignissimos ut ut et. Sit quia eos sit maxime fuga deleniti.
 Illum aut inventore laboriosam consequuntur officia illum doloribus. Ipsam ea minus incidunt quis aliquam. Nisi consectetur et eaque aperiam.
 Consequuntur quaerat odit fugiat dolor natus vel qui. Ut aut accusantium omnis reiciendis harum quasi mollitia necessitatibus.
 Sed et eaque eveniet. Est harum sequi aut iste quae aliquid. Ea reiciendis voluptatem id sunt quas et omnis voluptas. Nobis magnam et enim.
 Beatae velit voluptatem id. Ipsa voluptatem excepturi eligendi.",
   :uri "https://source.unsplash.com/random"})

(defn make-post [id]
  (assoc post :id id))

(def posts
  (map make-post (range 0 20)))

(def boards
  [{:id 0 :name "Home" :abbreviation "h"}
   {:id 1 :name "technology" :abbreviation "g"}
   {:id 2 :name "Wallpaper general" :abbreviation "wg"}
   {:id 3 :name "Fashion" :abbreviation "fa"}
   {:id 4 :name "Food & cooking" :abbreviation "ck"}])

(defn post-handler [request]
  (response {:posts posts}))

(defn board-handler [request]
  (response {:boards boards}))

(defn error-404-handler [request]
  (response {:error {:code 404 :message "Not found"}}))


(defn allow-cross-origin
  "middleware function to allow cross origin"
  [handler]
  (fn [request]
    (let [response (handler request)]
      (-> response
          (assoc-in [:headers "Access-Control-Allow-Origin"]  "*")
          ))))


(defroutes api
  (GET "/" [] post-handler)
  (GET "/post" [] post-handler)
  (GET "/boards" [] post-handler)
  (route/not-found error-404-handler))

(def app (-> api
             (allow-cross-origin)
             (wrap-json-response)))

