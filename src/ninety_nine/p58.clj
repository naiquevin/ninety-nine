(ns ninety-nine.p58
  (:require [ninety-nine.p54 :refer [make-btree]])
  (:require [ninety-nine.p56 :refer [symtree?]]))


;; P58 (**) Generate-and-test paradigm
;;
;; Apply the generate-and-test paradigm to construct all symmetric,
;; completely balanced binary trees with a given number of
;; nodes. Example:
;;
;; * sym-cbal-trees(5,Ts).
;;
;; Ts = [t(x, t(x, nil, t(x, nil, nil)), t(x, t(x, nil, nil), nil)),
;;       t(x, t(x, t(x, nil, nil), nil), t(x, nil, t(x, nil, nil)))]
;;
;; How many such trees are there with 57 nodes? Investigate about how
;; many solutions there are for a given number of nodes? What if the
;; number is even? Write an appropriate predicate.


(defn sym-cbal-trees
  [n]
  (letfn [(combinations [left right]
            (mapcat (fn [p]
                      (map (fn [q]
                             (make-btree 'x p q))
                           right))
                    left))
          (subtree [i]
            (if (= i 0)
              (list nil)
              (let [r (dec i)
                    a (int (Math/ceil (/ r 2)))
                    b (- r a)
                    c1 (subtree a)
                    c2 (if (= a b) c1 (subtree b))]
                (if (= a b)
                  (combinations c1 c2)
                  (concat (combinations c1 c2)
                          (combinations c2 c1))))))]
    (if (even? n) '[] (filter symtree? (subtree n)))))

;; user> (count (ninety-nine.p58/sym-cbal-trees 57))
;; 256
