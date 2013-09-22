(ns ninety-nine.p27
  (:require [ninety-nine.p26 :refer [combination]]))

;; P27 (**) Group the elements of a set into disjoint subsets.
;; 
;; a) In how many ways can a group of 9 people work in 3 disjoint
;; subgroups of 2, 3 and 4 persons? Write a function that generates
;; all the possibilities and returns them in a list.
;;
;; Example:
;; * (group3 '(aldo beat carla david evi flip gary hugo ida))
;; ( ( (ALDO BEAT) (CARLA DAVID EVI) (FLIP GARY HUGO IDA) )
;;   ... )

(defn group3
  [persons]
  (let [g1s (combination 2 persons)]
    (mapcat (fn [g1]
              (map (fn [g2]
                     (cons g1 g2))
                   (let [persons2 (remove (set g1) persons)
                         g2s (combination 3 persons2)]
                     (mapcat (fn [g3]
                               (map (fn [g4]
                                      (cons g3 g4))
                                    (list (list (remove (set g3) persons2)))))
                             g2s))))
            g1s)))

;; b) Generalize the above predicate in a way that we can specify a
;; list of group sizes and the predicate will return a list of groups.
;;
;; Example:
;; * (group '(aldo beat carla david evi flip gary hugo ida) '(2 2 5))
;; ( ( (ALDO BEAT) (CARLA DAVID) (EVI FLIP GARY HUGO IDA) )
;; ... )
;;
;; Note that we do not want permutations of the group members;
;; i.e. ((ALDO BEAT) ...) is the same solution as ((BEAT ALDO)
;; ...). However, we make a difference between ((ALDO BEAT) (CARLA
;; DAVID) ...) and ((CARLA DAVID) (ALDO BEAT) ...).
;;
;; You may find more about this combinatorial problem in a good book
;; on discrete mathematics under the term "multinomial coefficients".

(defn group
  [items grps]
  (if (= (first grps) (count items))
    (list (list items))
    (let [g1s (combination (first grps) items)]
      (mapcat (fn [g1]
                (map (fn [g2]
                       (cons g1 g2))
                     (group (remove (set g1) items) (rest grps))))
              g1s))))


;; Wow! Can't believe I could solve this \o/

