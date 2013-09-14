(ns ninety-nine.p03)

;; P03 (*) Find the K'th element of a list.
;; The first element in the list is number 1.
;; Example:
;; * (element-at '(a b c d e) 3)
;; C

(defn element-at
  [items k]
  (if (= k 1)
    (first items)
    (element-at (rest items) (- k 1))))

