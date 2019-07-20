(ns collatz-conjecture)

(defn collatz [num] ;; <- arglist goes here
    (if (= num 1)
      0
      (inc 
        (if (odd? num)
          (collatz (inc (* 3 num)))
          (collatz (/ num 2))
        )
      )
    )
)
