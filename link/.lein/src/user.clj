(ns user
  (:require [evalive.core]))

(defmacro dlet [bindings & body]
  `(let [~@(mapcat (fn [[n v]]
                     (if (or (vector? n) (map? n))
                       [n v]
                       [n v '_ `(println (name '~n) ":" ~v)]))
                   (partition 2 bindings))]
     ~@body))

(defmacro plet [bindings & body]
  `(let ~bindings
     (clojure.pprint/pprint (evalive.core/lexical-context))
     ~@body))
