(ns ninety-nine.p14)

;; P14 (*) Duplicate the elements of a list.
;; Example:
;; * (dupli '(a b c c d))
;; (A A B B C C C C D D)

(defn dupli
  [items]
  (mapcat (fn [x] (list x x)) items))

