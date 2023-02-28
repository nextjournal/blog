(ns user
  (:require [nextjournal.clerk :as clerk]))

(clerk/serve! {:browse? true :port 6677})

(comment

  ;; start with file watcher for these sub-directory paths
  (clerk/serve! {:watch-paths ["."]})

  (clerk/clear-cache!)

  (clerk/show! "garden.md")
  
  (clerk/show! "index.clj")

  )
