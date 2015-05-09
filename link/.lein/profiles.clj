{:user {:aliases {"slamhound" ["run" "-m" "slam.hound"]}
        :plugins [[cider/cider-nrepl "0.8.2"]
                  [lein-pprint "1.1.1"]
                  [lein-bikeshed "0.1.7"]
                  [lein-kibit "0.0.8"]]
        :source-paths ["/home/vagrant/.lein/src"]
        :injections [;; humane-test-output makes clojure.test output more better
                     (require 'pjstadig.humane-test-output)
                     (pjstadig.humane-test-output/activate!)

                     ;; Spyscope is for tracing.
                     (require 'spyscope.core)
                     ]
        :dependencies [[org.clojure/java.classpath "0.2.2"]
                       [org.clojure/tools.namespace "0.2.4"]
                       [org.clojure/tools.trace "0.7.6"]
                       [evalive "1.1.0"]
                       [pjstadig/humane-test-output "0.6.0"]
                       [slamhound "1.5.5"]
                       ;; [leiningen #= (leiningen.core.main/leiningen-version)]
                       ;; [im.chit/vinyasa "0.2.0"]
                       [spyscope "0.1.4"]]}}
