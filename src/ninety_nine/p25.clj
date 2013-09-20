(ns ninety-nine.p25
  (:require [ninety-nine.p23 :refer [rnd-select]]))

;; P25 (*) Generate a random permutation of the elements of a list.
;; Example:
;; * (rnd-permu '(a b c d e f))
;; (B A D C E F)
;;
;; Hint: Use the solution of problem P23.


(defn rmitem
  "Removes first occurence of x from items"
  [items x]
  (cond (empty? items)
        '()

        (= (first items) x)
        (rest items)

        :else (cons (first items)
                    (rmitem (rest items) x))))


(defn rnd-permu
  [items]
  (if (empty? items)
    '()
    (let [rnd (rnd-select items 1)]
      (concat rnd (rnd-permu (rmitem items (first rnd)))))))
  
