(ns ninety-nine.p31)

;; P31 (**) Determine whether a given integer number is prime.
;; Example:
;; * (is-prime 7)
;; T

(defn is-prime
  [n]
  (if (= n 2)
    true
    (= 1 (count
          (filter (fn [x]
                    (= (mod n x) 0))
                  (take (Math/ceil (Math/sqrt n))
                        (iterate inc 1)))))))

