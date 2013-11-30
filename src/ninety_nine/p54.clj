(ns ninety-nine.p54)

;; P54A (*) Check whether a given term represents a binary tree
;;
;; Write a predicate istree which returns true if and only if its
;; argument is a list representing a binary tree.
;;
;; Example:
;; * (istree (a (b nil nil) nil))
;; T
;; * (istree (a (b nil nil)))
;; NIL

;; since this is Clojure, we will use vectors instead of lists. Here
;; are constructor/accessor function for the same that will be used in
;; subsequent problems

(defn make-btree
  [node left right]
  (vector node left right))

(defn btree-node [t] (get t 0))
(defn btree-left [t] (get t 1))
(defn btree-right [t] (get t 2))


;; the istree function returns false instead of nil if the tree is not
;; a binary tree

(defn istree
  [tree]
  (or (nil? tree)
      (and (= (count tree) 3)
           (istree (btree-left tree))
           (istree (btree-right tree)))))
