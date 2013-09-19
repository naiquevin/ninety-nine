(ns ninety-nine.p21)

;; P21 (*) Insert an element at a given position into a list.
;; Example:
;; * (insert-at 'alfa '(a b c d) 2)
;; (A ALFA B C D)

(defn insert-at
  [elem items pos]
  (when (> pos 0)
    (if (= pos 1)
      (cons elem items)
      (cons (first items)
            (insert-at elem (rest items) (- pos 1))))))

