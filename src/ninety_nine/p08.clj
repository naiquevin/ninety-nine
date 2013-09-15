(ns ninety-nine.p08)

;; P08 (**) Eliminate consecutive duplicates of list elements.
;; If a list contains repeated elements they should be replaced with a single copy of the element. The order of the elements should not be changed.

;; Example:
;; * (compress '(a a a a b c c a a d e e e e))
;; (A B C A D E)

(defn compress
  [items]
  (reverse
   ((fn [items acc]
      (cond (empty? items) acc
            (= (first items) (first acc)) (recur (rest items) acc)
            :else (recur (rest items) (cons (first items) acc))))
    items (empty items))))

