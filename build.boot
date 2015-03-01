(set-env! :dependencies '[[boot/core "2.0.0-rc10"]
                          [boot/worker "2.0.0-rc10"]
                          [adzerk/bootlaces "0.1.11" :scope "test"]]
          :source-paths #{"src/clj"})

(require '[ewen.boot.boot-misc :refer [add-src]]
         '[adzerk.bootlaces])

(let [pom-opts {:project 'ewen.boot/boot-misc
                :version "0.0.1"}]
     (task-options!
       pom pom-opts))

(deftask push-release []
         (comp (pom) (add-src) (jar) (adzerk.bootlaces/push-release)))

(deftask build-jar []
         (comp (pom) (add-src) (jar)))

(deftask install-jar []
         (comp (pom) (add-src) (jar) (install)))