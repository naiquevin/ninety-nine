(ns ninety-nine.p20)

;; P20 (*) Remove the K'th element from a list.
;; Example:
;; * (remove-at '(a b c d) 2)
;; (A C D)

(defn remove-at
  [items k]
  (when (> k 0)
    (if (= k 1)
      (rest items)
      (cons (first items) (remove-at (rest items) (- k 1))))))

