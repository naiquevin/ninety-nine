(ns ninety-nine.p38
  (:require [ninety-nine.p37 :refer [phi]]
            [ninety-nine.p34 :refer [totient-phi]]))

;; P38 (*) Compare the two methods of calculating Euler's totient
;; function.
;; 
;; Use the solutions of problems P34 and P37 to compare the
;; algorithms. Take the number of logical inferences as a measure for
;; efficiency. Try to calculate phi(10090) as an example.

;; n = 10090

;; 1. p34 (naive totient phi)

;; 1 invocation of totient-phi : 10089 invocation of coprime?
;; 1 invocation of coprime? : 1 invocation of gcd
;; 1 invocation of gcd(i, n) : f(i, n) <??? how to find this ???>
;; sum(f(i, n) for i in [1 to n])

;; 2. p37 (improved)

;; 1 call to phi : 1 call to prime-factors-mult
;; 1 call to prime-factors-mult : n-2 calls to is-prime
;; 1 call to is-prime(i) : sqrt(i) logical inferences

;; sum(sqrt(i) for i in [2 to n]) + logical inferences in each
;; iteration of prime-factors <??? how to find this ???>

;; Benchmarking code stolen from
;; http://jondotcomdotorg.net/2010/07/15/99-clojure-problems-35-38/

(defn timer
  [which function n]
  (let [start (System/currentTimeMillis)
        answer (function n)
        end (System/currentTimeMillis)
        diff (- end start)]
    (println which "{" answer "} takes" diff "ms")))


(defn benchmark
  [n]
  (doseq [i (range 1 11)]
    (println "Run" i)
    (timer "p34" totient-phi n)
    (timer "p37" phi n)
    (println "------\n")))

