(ns imageboard-backend.models.boards)

(def boards
  [{:id 0 :name "Home" :abbreviation "h"}
   {:id 1 :name "technology" :abbreviation "g"}
   {:id 2 :name "Wallpaper general" :abbreviation "wg"}
   {:id 3 :name "Fashion" :abbreviation "fa"}
   {:id 4 :name "Food & cooking" :abbreviation "ck"}])

(defn get-boards []
  {:boards boards})
