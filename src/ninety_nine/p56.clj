(ns ninety-nine.p56
  (:require [ninety-nine.p54 :refer [make-btree btree-node
                                     btree-left btree-right]]))

;; P56 (**) Symmetric binary trees
;;
;; Let us call a binary tree symmetric if you can draw a vertical line
;; through the root node and then the right subtree is the mirror
;; image of the left subtree. Write a predicate symmetric/1 to check
;; whether a given binary tree is symmetric. Hint: Write a predicate
;; mirror/2 first to check whether one tree is the mirror image of
;; another. We are only interested in the structure, not in the
;; contents of the nodes.

(defn symtree?
  [tree]
  (letfn [(mirror? [x y]
            (cond (nil? x) (nil? y)
                  (nil? y) (nil? x)
                  :else (and (mirror? (btree-left x) (btree-right y))
                             (mirror? (btree-right x) (btree-left y)))))]
    (mirror? (btree-left tree)
             (btree-right tree))))
