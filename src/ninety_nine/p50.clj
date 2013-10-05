(ns ninety-nine.p50)

;; P50 (***) Huffman code.
;;
;; First of all, consult a good book on discrete mathematics or
;; algorithms for a detailed description of Huffman codes!
;;
;; We suppose a set of symbols with their frequencies, given as a list
;; of fr(S,F) terms. Example:
;; [fr(a,45),fr(b,13),fr(c,12),fr(d,16),fr(e,9),fr(f,5)]. Our
;; objective is to construct a list hc(S,C) terms, where C is the
;; Huffman code word for the symbol S. In our example, the result
;; could be Hs = [hc(a,'0'), hc(b,'101'), hc(c,'100'), hc(d,'111'),
;; hc(e,'1101'), hc(f,'1100')] [hc(a,'01'),...etc.]. The task shall be
;; performed by the predicate huffman/2 defined as follows:
;;
;; % huffman(Fs,Hs) :- Hs is the Huffman code table for the frequency
;; % table Fs

(def freq {"a" 45 "b" 13 "c" 12 "d" 16 "e" 9 "f" 5})


(defn map->nodes
  [m]
  (map (fn [[n v]] {:name n :value v}) m))


(defn huffman-tree
  [nodes]
  (if (= (count nodes) 1)
    (first nodes)
    (letfn [(compound-node [left right]
              {:name (str (:name left) (:name right))
               :value (+ (:value left) (:value right))
               :left left
               :right right})]
      (let [[n1 n2] (take 2 (sort-by :value nodes))
            cnode (compound-node n1 n2)]
        (recur (conj (remove (comp (set (map :name [n1 n2])) :name)
                             nodes)
                     cnode))))))


(defn huffman-encode
  [tree prefix]
  (cond (and (nil? (:left tree)) (nil? (:right tree)))
        [[(:name tree) prefix]]

        (nil? (:right tree))
        (huffman-encode (:left tree) (str prefix "0"))

        (nil? (:left tree))
        (huffman-encode (:right tree) (str prefix "1"))

        :else (concat (huffman-encode (:left tree) (str prefix "0"))
                      (huffman-encode (:right tree) (str prefix "1")))))


(defn huffman
  [freq-dist]
  (into {} (-> freq-dist
               (map->nodes)
               (huffman-tree)
               (huffman-encode ""))))

