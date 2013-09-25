(ns ninety-nine.p09)

;; P09 (**) Pack consecutive duplicates of list elements into sublists.
;; If a list contains repeated elements they should be placed in separate sublists.

;; Example:
;; * (pack '(a a a a b c c a a d e e e e))
;; ((A A A A) (B) (C C) (A A) (D) (E E E E))

(defn pack
  [items]
  (reverse ((fn [items acc]
              (cond (empty? items)
                    acc

                    (= (first items) (first (first acc)))
                    (recur (rest items)
                           (cons (conj (first acc) (first items))
                                 (rest acc)))

                    :else
                    (recur (rest items)
                           (cons (list (first items)) acc))))
            items '())))

