(ns ninety-nine.p22)

;; P22 (*) Create a list containing all integers within a given range.
;;
;; If first argument is smaller than second, produce a list in
;; decreasing order.
;;
;; Example:
;; * (range 4 9)
;; (4 5 6 7 8 9)

(defn my-range
  [start end]
  (if (> start end)
    '()
    (cons start (my-range (inc start) end))))


(defn my-range*
  [start end]
  (reverse ((fn [s e acc]
              (if (> s e)
                acc
                (recur (inc s) e (cons s acc))))
            start end '())))

