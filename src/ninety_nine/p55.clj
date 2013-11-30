(ns ninety-nine.p55)

;; P55 (**) Construct completely balanced binary trees
;;
;; In a completely balanced binary tree, the following property holds
;; for every node: The number of nodes in its left subtree and the
;; number of nodes in its right subtree are almost equal, which means
;; their difference is not greater than one.
;;
;; Write a function cbal-tree to construct completely balanced binary
;; trees for a given number of nodes. The predicate should generate
;; all solutions via backtracking. Put the letter 'x' as information
;; into all nodes of the tree.
;;
;; Example:
;; * cbal-tree(4,T).
;; T = t(x, t(x, nil, nil), t(x, nil, t(x, nil, nil))) ;
;; T = t(x, t(x, nil, nil), t(x, t(x, nil, nil), nil)) ;


(defn cbal-tree
  [n]
  (if (zero? n)
    nil
    (let [r (dec n)
          x (int (Math/ceil (/ r 2)))
          y (- r x)]
      (vector 'x (cbal-tree x) (cbal-tree y)))))
