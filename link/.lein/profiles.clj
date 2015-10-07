{:user {:aliases {"slamhound" ["run" "-m" "slam.hound"]}
        :plugins [[cider/cider-nrepl "0.9.1"]
                  [refactor-nrepl "1.1.0"]
                  [lein-pprint "1.1.1"]
                  [lein-bikeshed "0.2.0"]]
        :source-paths ["/home/vagrant/.lein/src"]
        :injections [;; humane-test-output makes clojure.test output more better
                     (require 'pjstadig.humane-test-output)
                     (pjstadig.humane-test-output/activate!)

                     ;; Spyscope is for tracing.
                     (require 'spyscope.core)]
        :dependencies [[org.clojure/tools.namespace "0.2.11"]
                       [org.clojure/tools.nrepl "0.2.7"]
                       [org.clojure/tools.trace "0.7.8"]
                       [pjstadig/humane-test-output "0.7.0"]
                       [slamhound "1.5.5"]
                       [spyscope "0.1.5"]]}}

;;;; WIP: more emacs-like Gorilla keybindings.
;; :gorilla-options {:keymap { ;; "command:app:commands" ""
;;                            ;; "command:worksheet:leaveBack" "alt+p"
;;                            ;; "command:worksheet:leaveForward" "alt+n"
;;                            "command:evaluator:evaluate" "ctrl+c ctrl+e"
;;                            "command:evaluator:evaluate-all" "ctrl+c ctrl+k"
;;                            ;; "command:worksheet:clear-output" ""
;;                            ;; "command:worksheet:clear-all" ""
;;                            ;; "command:worksheet:delete" ""
;;                            ;; "command:worksheet:changeToFree" ""
;;                            ;; "command:worksheet:changeToCode" ""
;;                            "command:app:open" "ctrl+x ctrl+f"
;;                            "command:app:save" "ctrl+x ctrl+s"
;;                            "command:app:saveas" "ctrl+x ctrl+w"
;;                            "command:worksheet:newBelow" "ctrl+o"
;;                            ;; "command:worksheet:newAbove" ""
;;                            ;; "command:worksheet:moveUp" ""
;;                            ;; "command:worksheet:moveDown" ""
;;                            "command:docs:clojuredocs" "ctrl+c ctrl+d"
;;                            ;; "command:app:reset-worksheet" ""
;;                            ;; "command:worksheet:completions" ""
;;                            }}
