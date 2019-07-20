(ns nucleotide-count)

(defn count [nucleotide strand] ;; <- Arglist goes here
  (if-not (contains? #{\A \T \C \G} nucleotide) 
    (throw (ex-info "Bad input nucleotide."))
    (loop [[head & tail] strand
            n 0]
      (if (nil? head)
        n
        (recur tail (if (= head nucleotide) (inc n) n))
      )
    )
  )
)

(defn nucleotide-counts [strand] ;; <- Arglist goes here
  (zipmap [\A \T \G \C] (map (fn [c] (nucleotide-count/count c strand)) [\A \T \G \C]))
)
