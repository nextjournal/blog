(ns sicmutils
  (:require [nextjournal.clerk :as clerk]
            [sicmutils.env :as e]))


(e/bootstrap-repl!)

(+ 'x 'y)

#_(clerk/show! "dev/sicmutils.clj")
