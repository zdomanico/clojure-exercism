(ns armstrong-numbers)

(defn pow [a b]
  (reduce * (repeat b a))
)

(defn armstrong? [num] ;; <- arglist goes here
  (let [ndigits (count (str num))
        digits (->> num str (map (comp read-string str)))]
    (= num (reduce + (map #(pow % ndigits) digits)))
  )
)
