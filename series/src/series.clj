(ns series)

(defn slices [string length] ;; <- arglist goes here
  (if (zero? length) 
    [""] 
    (loop [start 0
           end length
           res []]
      (if (> end (count string))
        res
        (recur (inc start) (inc end) (conj res (subs string start end)))
      )
    )
  )
)
