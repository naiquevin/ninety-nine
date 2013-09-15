(ns ninety-nine.p06)

;; P06 (*) Find out whether a list is a palindrome.
;; A palindrome can be read forward or backward; e.g. (x a m a x).

(defn palindrome?
  [items]
  (if (or (empty? items) (= (count items) 1))
    true
    (and (= (first items) (last items))
         (palindrome? (butlast (rest items))))))

