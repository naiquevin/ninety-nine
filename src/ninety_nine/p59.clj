(ns ninety-nine.p59
  (:require [ninety-nine.p54 :refer [make-btree btree-left btree-right]]
            [clojure.math.numeric-tower :refer [abs]]))


(defn hbal-tree
  [n]
  (cond (zero? n) [nil]
        (= n 1) [(make-btree 'x nil nil)]

        :else
        (let [r (- n 1)
              br1 (hbal-tree r)
              br2 (hbal-tree (- r 1))
              combinations (fn [lefts rights]
                             (mapcat (fn [left]
                                       (map (fn [right]
                                              (make-btree 'x left right))
                                            rights))
                                     lefts))]
          (concat (combinations br1 br1)
                  (combinations br1 br2)
                  (combinations br2 br1)))))


;; ninety-nine.p59> (pprint (hbal-tree 3))
;; ([x [x [x nil nil] [x nil nil]] [x [x nil nil] [x nil nil]]]
;;  [x [x [x nil nil] [x nil nil]] [x [x nil nil] nil]]
;;  [x [x [x nil nil] [x nil nil]] [x nil [x nil nil]]]
;;  [x [x [x nil nil] nil] [x [x nil nil] [x nil nil]]]
;;  [x [x [x nil nil] nil] [x [x nil nil] nil]]
;;  [x [x [x nil nil] nil] [x nil [x nil nil]]]
;;  [x [x nil [x nil nil]] [x [x nil nil] [x nil nil]]]
;;  [x [x nil [x nil nil]] [x [x nil nil] nil]]
;;  [x [x nil [x nil nil]] [x nil [x nil nil]]]
;;  [x [x [x nil nil] [x nil nil]] [x nil nil]]
;;  [x [x [x nil nil] nil] [x nil nil]]
;;  [x [x nil [x nil nil]] [x nil nil]]
;;  [x [x nil nil] [x [x nil nil] [x nil nil]]]
;;  [x [x nil nil] [x [x nil nil] nil]]
;;  [x [x nil nil] [x nil [x nil nil]]])
;; nil


;; Functions for verifying the solution

(defn tree-height
  [tree]
  (if (nil? tree)
    0
    (+ 1 (max (tree-height (btree-left tree))
              (tree-height (btree-right tree))))))


(defn hbal-tree?
  [tree]
  (or (nil? tree)
      (let [hdiff (abs (- (tree-height (btree-left tree))
                          (tree-height (btree-right tree))))]
        (or (= hdiff 0) (= hdiff 1)))))


;; ninety-nine.p59> (every? hbal-tree? (hbal-tree 3))
;; true
