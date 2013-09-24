(ns ninety-nine.p32)

;; P32 (**) Determine the greatest common divisor of two positive
;; integer numbers.
;; 
;; Use Euclid's algorithm.
;; Example:
;; * (gcd 36 63)
;; 9

(defn gcd
  [x y]
  (let [rem (mod x y)]
    (if (= rem 0)
      y
      (gcd y rem))))

