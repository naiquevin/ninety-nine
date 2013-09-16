(ns ninety-nine.p12)

;; P12 (**) Decode a run-length encoded list.
;;
;; Given a run-length code list generated as specified in problem
;; P11. Construct its uncompressed version.

;; Assuming that implementing 'repeat' is a part of the challenge
(defn my-repeat
  [n x]
  (if (= n 0)
    '()
    (cons x (my-repeat (- n 1) x))))


(defn decode
  [items]
  (cond (empty? items)
        '()
        
        (coll? (first items))
        (cons (my-repeat (first (first items))
                      (last (first items)))
              (decode (rest items)))
        
        :else (cons (first items)
                    (decode (rest items)))))

