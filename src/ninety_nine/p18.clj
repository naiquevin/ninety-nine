(ns ninety-nine.p18
  (:require [ninety-nine.p17 :refer [split]]))

;; P18 (**) Extract a slice from a list.
;; 
;; Given two indices, I and K, the slice is the list containing the
;; elements between the I'th and K'th element of the original list
;; (both limits included). Start counting the elements with 1.
;;
;; Example:
;; * (slice '(a b c d e f g h i k) 3 7)
;; (C D E F G)

(defn slice
  [items a b]
  (first (split (last (split items (- a 1))) (- b (- a 1)))))

