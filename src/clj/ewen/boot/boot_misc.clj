(ns ewen.boot.boot-misc
    (:require [clojure.java.io :as io]
      [boot.core :refer [deftask get-env with-pre-wrap commit! add-resource]]))


(deftask add-src
         "This is untested but should work..."
         []
         (with-pre-wrap fileset
                        (let [src-dirs (map io/file (:source-paths (get-env)))]
                             (-> (reduce add-resource fileset src-dirs) commit!))))






