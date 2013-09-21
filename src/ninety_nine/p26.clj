(ns ninety-nine.p26)

;; P26 (**) Generate the combinations of K distinct objects chosen
;; from the N elements of a list
;;
;; In how many ways can a committee of 3 be chosen from a group of 12
;; people? We all know that there are C(12,3) = 220 possibilities
;; (C(N,K) denotes the well-known binomial coefficients). For pure
;; mathematicians, this result may be great. But we want to really
;; generate all the possibilities in a list.
;;
;; Example:
;; * (combination 3 '(a b c d e f))
;; ((A B C) (A B D) (A B E) ... )

(defn combination
  [k items]
  (let [n (count items)]
    (cond (or (empty? items) (zero? k))
          (list '())

          (= k n)
          (list items)

          :else (concat (map (fn [c] (cons (first items) c))
                             (combination (- k 1) (rest items)))
                        (combination k (rest items))))))

