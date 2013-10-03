(ns ninety-nine.p49)

;; P49 (**) Gray code.
;;
;; An n-bit Gray code is a sequence of n-bit strings constructed
;; according to certain rules. For example,
;;
;; n = 1: C(1) = ['0','1'].
;; n = 2: C(2) = ['00','01','11','10'].
;; n = 3: C(3) = ['000','001','011','010',´110´,´111´,´101´,´100´].

(defn gray-code
  [n]
  (when (> n 0)
    (letfn [(cross-prefix [a b]
              (mapcat (fn [x]
                        (map (fn [y]
                               (cons x (map str (seq y))))
                             b))
                      a))]
      (if (= 1 n)
        ["0" "1"]
        (mapv (partial apply str)
              (cross-prefix ["0" "1"]
                            (gray-code (- n 1))))))))


;; Find out the construction rules and write a predicate with the
;; following specification:
;;
;; % gray(N,C) :- C is the N-bit Gray code
;;
;; Can you apply the method of "result caching" in order to make the
;; predicate more efficient, when it is to be used repeatedly?

;; !! To study !! Is this "doable" at all in Clojure?

