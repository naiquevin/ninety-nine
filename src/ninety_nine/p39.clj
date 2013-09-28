(ns ninety-nine.p39)

;; P39 (*) A list of prime numbers.
;;
;; Given a range of integers by its lower and upper limit, construct a
;; list of all prime numbers in that range.

(defn sieve
  [min max]
  (letfn
   [(f [integers acc]
      (cond (empty? integers)
            acc

            (= (first integers) 1)
            (recur (rest integers) acc)

            :else (let [i (first integers)]
                    (recur (filter (fn [x]
                                     (not (= (mod x i) 0)))
                                   (rest integers))
                           (cons i acc)))))]
   (reverse (f (range min max) '()))))


(defn sieve2
  "Alternate version that takes the opposite approach of the above and
  is more efficient"
  [max]
  (reverse
   (reduce (fn [primes x]
             (let [factors (filter #(= (mod x %) 0) primes)]
               (if (zero? (count factors))
                 (conj primes x)
                 primes)))
           '(2)
           (vec (range 3 max)))))


;; For more efficient and scalable version of Sieve of Eratosthenes,
;; see this blog post by Christophe Grand
;; http://clj-me.cgrand.net/2009/07/30/everybody-loves-the-sieve-of-eratosthenes/

