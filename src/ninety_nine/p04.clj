(ns ninety-nine.p04)

;; P04 (*) Find the number of elements of a list.

(defn length
  [items]
  ((fn [items acc]
     (if (empty? items)
       acc
       (recur (rest items) (inc acc))))
   items 0))

