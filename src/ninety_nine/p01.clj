(ns ninety-nine.p01)

;; P01 (*) Find the last box of a list.
;; Example:
;; * (my-last '(a b c d))
;; (D)

(defn my-last
  [items]
  (if (empty? (rest items))
    (first items)
    (my-last (rest items))))

