(ns ninety-nine.p40
  (:require [ninety-nine.p39 :refer [sieve2]]
            [ninety-nine.p26 :refer [combination]]
            [ninety-nine.p38 :refer [timer]]))

;; P40 (**) Goldbach's conjecture.
;;
;; Goldbach's conjecture says that every positive even number greater
;; than 2 is the sum of two prime numbers. Example: 28 = 5 + 23. It is
;; one of the most famous facts in number theory that has not been
;; proved to be correct in the general case. It has been numerically
;; confirmed up to very large numbers (much larger than we can go with
;; our Prolog system). Write a predicate to find the two prime numbers
;; that sum up to a given even integer.
;;
;; Example:
;; * (goldbach 28)
;; (5 23)


;; This is naive version but it works reasonably well for even n =
;; 10000

(defn goldbach
  [n]
  (first (filter (fn [[x y]]
                   (= (+ x y) n))
                 (combination 2 (sieve2 n)))))


(defn goldbach*
  [n]
  (let [primes (sieve2 n)]
    (first
     (mapcat (fn [x]
               (filter (complement nil?)
                       (map (fn [y]
                              (when (= (+ x y) n)
                                (list x y)))
                            (filter #(> % x) primes))))
             primes))))


(defn benchmark
  [n]
  (doseq [i (range 1 11)]
    (println "Run" i)
    (timer "goldbach" goldbach n)
    (timer "goldbach*" goldbach* n)
    (println "------\n")))


;; Benchmark results
;; tl;dr goldbach* is clearly better

;; user> (ninety-nine.p40/benchmark 10000)
;; Run 1
;; goldbach { (59 9941) } takes 3541 ms
;; goldbach* { (59 9941) } takes 2211 ms
;; ------
;;
;; Run 2
;; goldbach { (59 9941) } takes 3520 ms
;; goldbach* { (59 9941) } takes 2216 ms
;; ------
;;
;; Run 3
;; goldbach { (59 9941) } takes 2833 ms
;; goldbach* { (59 9941) } takes 2206 ms
;; ------
;;
;; Run 4
;; goldbach { (59 9941) } takes 2829 ms
;; goldbach* { (59 9941) } takes 2231 ms
;; ------
;;
;; Run 5
;; goldbach { (59 9941) } takes 3264 ms
;; goldbach* { (59 9941) } takes 2220 ms
;; ------
;;
;; Run 6
;; goldbach { (59 9941) } takes 3601 ms
;; goldbach* { (59 9941) } takes 2224 ms
;; ------
;;
;; Run 7
;; goldbach { (59 9941) } takes 2881 ms
;; goldbach* { (59 9941) } takes 2250 ms
;; ------
;;
;; Run 8
;; goldbach { (59 9941) } takes 3448 ms
;; goldbach* { (59 9941) } takes 2235 ms
;; ------
;;
;; Run 9
;; goldbach { (59 9941) } takes 2879 ms
;; goldbach* { (59 9941) } takes 2248 ms
;; ------
;;
;; Run 10
;; goldbach { (59 9941) } takes 3613 ms
;; goldbach* { (59 9941) } takes 2236 ms
;; ------
;;
;; nil

