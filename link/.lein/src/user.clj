(ns user
  (:require [clojure.pprint]
            [clojure.tools.namespace.repl]
            [clojure.tools.trace]
            [evalive.core :as evalive]))

(def refresh-all #'clojure.tools.namespace.repl/refresh-all)

(def trace-vars #'clojure.tools.trace/trace-vars)

(def untrace-vars #'clojure.tools.trace/untrace-vars)

(defmacro dlet [bindings & body]
  `(let [~@(mapcat (fn [[n v]]
                     (if (or (vector? n) (map? n))
                       [n v]
                       [n v '_ `(println (name '~n) ":" ~v)]))
                   (partition 2 bindings))]
     ~@body))

(defmacro plet [bindings & body]
  `(let ~bindings
     (clojure.pprint/pprint (evalive/lexical-context))
     ~@body))
