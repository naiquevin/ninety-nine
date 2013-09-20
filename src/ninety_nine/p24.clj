(ns ninety-nine.p24
  (:require [ninety-nine.p22 :refer [my-range]])
  (:require [ninety-nine.p23 :refer [rnd-select]]))

;; P24 (*) Lotto: Draw N different random numbers from the set 1..M.
;; The selected numbers shall be returned in a list.
;; Example:
;; * (lotto-select 6 49)
;; (23 1 17 33 21 37)
;; 
;; Hint: Combine the solutions of problems P22 and P23.

(defn lotto-select
  [n m]
  (rnd-select (my-range 1 m) n))

