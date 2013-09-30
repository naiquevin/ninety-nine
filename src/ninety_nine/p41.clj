(ns ninety-nine.p41
  (:require [ninety-nine.p40 :refer [goldbach]]))

;; P41 (**) A list of Goldbach compositions.
;;
;; Given a range of integers by its lower and upper limit, print a
;; list of all even numbers and their Goldbach composition.
;;
;; Example:
;; * (goldbach-list 9 20)
;; 10 = 3 + 7
;; 12 = 5 + 7
;; 14 = 3 + 11
;; 16 = 3 + 13
;; 18 = 5 + 13
;; 20 = 3 + 17

;; In most cases, if an even number is written as the sum of two prime
;; numbers, one of them is very small. Very rarely, the primes are
;; both bigger than say 50. Try to find out how many such cases there
;; are in the range 2..3000.

;; Example (for a print limit of 50):
;; * (goldbach-list 1 2000 50)
;; 992 = 73 + 919
;; 1382 = 61 + 1321
;; 1856 = 67 + 1789
;; 1928 = 61 + 1867

;; 1st part

(defn goldbach-range
  [min max]
  (let [lower  (if (even? min) min (inc min))
        upper (inc max)
        gb (fn [n] [n (goldbach n)])]
    (map gb (range lower upper 2))))


(defn goldbach-printer
  [compositions]
  (doseq [[n [x y]] compositions]
    (println n " = " x " + " y)))


(defn goldbach-list
  [min max]
  (goldbach-printer (goldbach-range min max)))


(defn goldbach-list-limit
  [min max limit]
  (goldbach-printer (filter (fn [[n [x y]]]
                              (and (> x limit) (> y limit)))
                            (goldbach-range min max))))

