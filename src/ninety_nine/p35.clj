(ns ninety-nine.p35
  (:require [ninety-nine.p31 :refer [is-prime]]))

;; P35 (**) Determine the prime factors of a given positive integer.
;;
;; Construct a flat list containing the prime factors in ascending
;; order.
;;
;; Example:
;; * (prime-factors 315)
;; (3 3 5 7)

(defn prime-factors
  [n]
  (reverse
   ((fn [m primes acc]
      (cond (empty? primes)
            acc

            (= (mod m (first primes)) 0)
            (recur (/ m (first primes))
                   primes
                   (cons (first primes) acc))

            :else
            (recur m (rest primes) acc)))
    n (filter is-prime (take n (iterate inc 2))) '())))

