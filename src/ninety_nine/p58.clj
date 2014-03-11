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
          (cbal-trees [i]
            (if (= i 0)
              (list nil)
              (let [r (dec i)
                    a (int (Math/ceil (/ r 2)))
                    b (- r a)
                    c1 (cbal-trees a)
                    c2 (if (= a b) c1 (cbal-trees b))]
                (if (= a b)
                  (combinations c1 c2)
                  (concat (combinations c1 c2)
                          (combinations c2 c1))))))]
    (if (even? n) '[] (filter symtree? (cbal-trees n)))))

;; user> (count (ninety-nine.p58/sym-cbal-trees 57))
;; 256


;; Explanation:
;;
;; The function inner `cbal-trees` returns the possible completely
;; balanced trees for a given no. of nodes. For zero nodes, it's just
;; 1 empty tree (nil). Otherwise, we find the no. of nodes in left and
;; right subtrees which will differ by at most 1. Then we recursively
;; obtain the possible subtrees for both the left and the right
;; branches. The total possible cbal-trees is a cross-product of the
;; possible left subtrees and possible right subtrees. If no. of nodes
;; in left subtree and right subtree is same, then the left and right
;; subtrees will be same and we just need to find the combinations
;; once. However, if the no. of nodes are different, then the no. of
;; nodes will differ by 1 say x and x+1 and then we need to consider
;; both the cases ie. when left subtree has x nodes and right has x+1
;; nodes + when left has x+1 nodes and right has x nodes. Finally, we
;; filter only those trees that are symmetic.
