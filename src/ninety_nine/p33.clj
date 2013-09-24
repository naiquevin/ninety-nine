(ns ninety-nine.p33
  (:require [ninety-nine.p32 :refer [gcd]]))

;; P33 (*) Determine whether two positive integer numbers are coprime.
;; Two numbers are coprime if their greatest common divisor equals 1.
;; Example:
;; * (coprime 35 64)
;; T

(defn coprime?
  [x y]
  (= (gcd x y) 1))

