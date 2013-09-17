(ns ninety-nine.p15)

;; P15 (**) Replicate the elements of a list a given number of times.
;; Example:
;; * (repli '(a b c) 3)
;; (A A A B B B C C C)

(defn repli
  [items n]
  (mapcat (fn [x] (repeat n x)) items))

