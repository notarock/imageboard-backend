(ns imageboard-backend.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.json :refer [wrap-json-response]]
            [ring.util.response :refer [response]]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

(defn handler [request]
  (response {:foo "bar"}))

(def app
  (wrap-json-response handler))

