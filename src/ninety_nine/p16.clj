(ns ninety-nine.p16)

;; P16 (**) Drop every N'th element from a list.
;; Example:
;; * (drop '(a b c d e f g h i k) 3)
;; (A B D E G H K)

(defn my-drop
  [items n]
  (reverse ((fn [items c acc]
              (cond (empty? items)
                    acc

                    (= (mod c n) 0)
                    (recur (rest items) (inc c) acc)

                    :else (recur (rest items)
                                 (inc c)
                                 (cons (first items) acc))))
            items 1 '())))

