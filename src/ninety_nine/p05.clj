(ns ninety-nine.p05)

;; P05 (*) Reverse a list.

(defn my-reverse
  [items]
  ((fn [items acc]
     (if (empty? items)
       acc
       (recur (rest items)
              (cons (first items) acc))))
   items '()))

