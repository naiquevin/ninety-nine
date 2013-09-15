(ns ninety-nine.p07)

;; P07 (**) Flatten a nested list structure.
;; Transform a list, possibly holding lists as elements into a `flat' list by replacing each list with its elements (recursively).
;;
;; Example:
;; * (my-flatten '(a (b (c d) e)))
;; (A B C D E)
;;
;; Hint: Use the predefined functions list and append.

(defn my-flatten
  [items]
  (cond (empty? items)
        '()
        
        (coll? (first items))
        (concat (my-flatten (first items))
                (my-flatten (rest items)))

        :else (cons (first items)
                    (my-flatten (rest items)))))

