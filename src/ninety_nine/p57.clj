(ns ninety-nine.p57
  (:require [ninety-nine.p54 :refer [make-btree btree-node
                                     btree-left btree-right]]))


;; P57 (**) Binary search trees (dictionaries)
;;
;; Use the predicate add/3, developed in chapter 4 of the course, to
;; write a predicate to construct a binary search tree from a list of
;; integer numbers.
;;
;; Example:
;; * construct([3,2,5,7,1],T).
;; T = t(3, t(2, t(1, nil, nil), nil), t(5, nil, t(7, nil, nil)))
;;
;; Then use this predicate to test the solution of the problem P56.
;; Example:
;; * test-symmetric([5,3,18,1,4,12,21]).
;; Yes
;; * test-symmetric([3,2,5,7,1]).
;; No

(defn bst-insert
  [tree x]
  (cond (nil? tree)
        (make-btree x nil nil)

        (< x (btree-node tree))
        (make-btree (btree-node tree)
                   (bst-insert (btree-left tree) x)
                   (btree-right tree))

        (> x (btree-node tree))
        (make-btree (btree-node tree)
                   (btree-left tree)
                   (bst-insert (btree-right tree) x))))


(defn bst [xs] (reduce bst-insert nil xs))
