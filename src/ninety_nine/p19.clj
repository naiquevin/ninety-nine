(ns ninety-nine.p19
  (:require [ninety-nine.p17 :refer [split]]))

;; P19 (**) Rotate a list N places to the left.
;;
;; Examples:
;; * (rotate '(a b c d e f g h) 3)
;; (D E F G H A B C)
;;
;; * (rotate '(a b c d e f g h) -2)
;; (G H A B C D E F)

(defn rotate
  [items n]
  (let [parts (split items (if (neg? n) (+ (count items) n) n))]
    (concat (last parts) (first parts))))

