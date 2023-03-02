(ns nextjournal.blog.index
  {:nextjournal.clerk/visibility {:code :hide}}
  (:require [nextjournal.clerk :as clerk]
            [nextjournal.clerk.parser :as parser]))

(clerk/html [:style "h1 { margin-bottom: 0; font-size: 2.6em !important;}
h1 + p { font-size: 1.7em; position: relative; padding-bottom: 40px;}
h1 + p:after { content: \"\"; position: absolute; left: 0; bottom: 0; border-bottom: 2px solid #ccc; width: 350px;"])

;; # Welcome to the New Nextjournal Blog
;; Follow along with what’s going on at Nextjournal, and the topics we’re passionate about.

{:nextjournal.clerk/visibility {:result :hide}}

(defn parse [post-id]
  (->> (str post-id ".md") (parser/parse-file {:doc? true})))

(defn link-post [post-id]
  (let [{:keys [title file]} (parse post-id)]
    [:h2 [:a {:href (clerk/doc-url file)} title]]))

^{::clerk/viewer clerk/html :nextjournal.clerk/visibility {:result :show}}
(into [:<>] (map link-post) '[garden])
