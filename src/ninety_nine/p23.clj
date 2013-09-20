(ns ninety-nine.p23
  (:require [ninety-nine.p20 :refer [remove-at]]))

;; P23 (**) Extract a given number of randomly selected elements from
;; a list.
;;
;; The selected items shall be returned in a list.
;; Example:
;; * (rnd-select '(a b c d e f g h) 3)
;; (E D A)
;;
;; Hint: Use the built-in random number generator and the result of
;; problem P20.

(defn rnd-select
  [items n]
  ((fn [it k]
     (if (zero? k)
       it
       (recur (remove-at
               it
               (+ (rand-int (count it)) 1)) ; add one since remove-at
                                            ; works with 1-indexed
                                            ; lists and rand-int
                                            ; excludes max
              (- k 1))))
   items (- (count items) n)))

