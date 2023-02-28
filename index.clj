;; # The New Nextjournal Blog
(ns nextjournal.blog.index
  {:nextjournal.clerk/visibility {:code :hide}}
  (:require [nextjournal.clerk :as clerk]
            [nextjournal.clerk.parser :as parser]))

;; Follow along with what’s going on at Nextjournal, and the topics we’re passionate about.

{:nextjournal.clerk/visibility {:result :hide}}

(defn parse [post-id]
  (->> (str post-id ".md") (parser/parse-file {:doc? true})))

(defn link-post [post-id]
  (let [{:keys [title file]} (parse post-id)]
    [:h2 [:a {:href (clerk/doc-url file)} title]]))

^{::clerk/viewer clerk/html :nextjournal.clerk/visibility {:result :show}}
(into [:<>] (map link-post) '[garden])
