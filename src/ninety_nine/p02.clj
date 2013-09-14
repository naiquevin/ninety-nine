(ns ninety-nine.p02)

;; P02 (*) Find the last but one box of a list.
;; Example:
;; * (my-but-last '(a b c d))
;; (C D)

(defn my-but-last
  [items]
  (when (> (count items) 1)
    (if (= (count items) 2)
      items
      (my-but-last (rest items)))))

