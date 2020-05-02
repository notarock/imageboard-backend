(ns imageboard-backend.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.json :refer [wrap-json-response]]
            [ring.util.response :refer [response]]
            [imageboard-backend.models.boards :refer [get-boards]]
            [imageboard-backend.models.posts :refer [get-posts]]))

(defn post-handler [request]
  (response (get-posts)))

(defn board-handler [request]
  (response (get-boards)))

(defn error-404-handler [request]
  (response {:error {:code 404 :message "Not found"}}))

(defn allow-cross-origin
  "middleware function to allow cross origin"
  [handler]
  (fn [request]
    (let [response (handler request)]
      (-> response
          (assoc-in [:headers "Access-Control-Allow-Origin"]  "*")))))

(defroutes api
  (GET "/" [] post-handler)
  (GET "/posts" [] post-handler)
  (GET "/boards" [] board-handler)
  (route/not-found error-404-handler))

(def app (-> api
             (allow-cross-origin)
             (wrap-json-response)))

