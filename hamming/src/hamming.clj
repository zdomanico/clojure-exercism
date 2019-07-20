(ns hamming)

(defn distance [strand1 strand2] ; <- arglist goes here
  (if-not (= (count strand1) (count strand2))
    nil
    (loop [[s1 & ss1] strand1
           [s2 & ss2] strand2
           dist 0]
      (if (or (nil? s1) (nil? s2))
        dist
        (recur ss1 ss2 (if-not (= s1 s2) (inc dist) dist))
      )
    )
  )
)
