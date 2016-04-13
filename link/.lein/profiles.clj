{:user {:aliases {"slamhound" ["run" "-m" "slam.hound"]}
        :plugins [[cider/cider-nrepl "0.10.0"]
                  [refactor-nrepl "1.1.0"]
                  [lein-pprint "1.1.1"]
                  [lein-bikeshed "0.2.0"]
                  [lein-ancient "0.6.7" :exclusions [org.clojure/clojure]]]
        :source-paths ["/home/vagrant/.lein/src"]
        :injections [;; humane-test-output makes clojure.test output more better
                     (require 'pjstadig.humane-test-output)
                     (pjstadig.humane-test-output/activate!)

                     ;; Spyscope is for tracing.
                     (require 'spyscope.core)]
        :dependencies [[org.clojure/tools.namespace "0.2.11"]
                       [org.clojure/tools.nrepl "0.2.12"]
                       [org.clojure/tools.trace "0.7.8"]
                       [pjstadig/humane-test-output "0.7.0"]
                       [slamhound "1.5.5"]
                       [spyscope "0.1.5"]]}}
