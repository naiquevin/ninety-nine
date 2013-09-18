(ns ninety-nine.p11
  (:require [ninety-nine.p10 :refer [encode]]))

;; P11 (*) Modified run-length encoding.
;; 
;; Modify the result of problem P10 in such a way that if an element
;; has no duplicates it is simply copied into the result list. Only
;; elements with duplicates are transferred as (N E) lists.
;;
;; Example:
;; * (encode-modified '(a a a a b c c a a d e e e e))
;; ((4 A) B (2 C) (2 A) D (4 E))

(defn encode-modified
  [items]
  (map #(if (= (first %) 1) (last %) %) (encode items)))

