(ns ninety-nine.p36
  (:require [ninety-nine.p35 :refer [prime-factors]]))

;; P36 (**) Determine the prime factors of a given positive integer
;; (2).
;;
;; Construct a list containing the prime factors and their
;; multiplicity.
;;
;; Example:
;; * (prime-factors-mult 315)
;; ((3 2) (5 1) (7 1))
;; Hint: The problem is similar to problem P13.

(defn prime-factors-mult
  [n]
  (apply list
         (sort-by first
                  (map (partial apply list)
                       (reduce (fn [x y]
                                 (update-in x [y] (fnil inc 0)))
                               {}
                               (prime-factors n))))))

