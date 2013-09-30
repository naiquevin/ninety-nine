(ns ninety-nine.p40
  (:require [ninety-nine.p39 :refer [sieve2]]
            [ninety-nine.p26 :refer [combination]]))

;; P40 (**) Goldbach's conjecture.
;;
;; Goldbach's conjecture says that every positive even number greater
;; than 2 is the sum of two prime numbers. Example: 28 = 5 + 23. It is
;; one of the most famous facts in number theory that has not been
;; proved to be correct in the general case. It has been numerically
;; confirmed up to very large numbers (much larger than we can go with
;; our Prolog system). Write a predicate to find the two prime numbers
;; that sum up to a given even integer.
;;
;; Example:
;; * (goldbach 28)
;; (5 23)


;; This is naive version but it works reasonably well for even n =
;; 10000

(defn goldbach
  [n]
  (first (filter (fn [[x y]]
                   (= (+ x y) n))
                 (combination 2(sieve2 n)))))

