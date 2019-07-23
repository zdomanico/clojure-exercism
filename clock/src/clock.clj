(ns clock)

(defn clock->string [clock] ;; <- arglist goes here
  (let [hour (clock :hour)
        min (clock :min)]
    (format "%02d:%02d" hour min)
  )
)

(defn clock [hours minutes] ;; <- arglist goes here
  (let [min (mod minutes 60)
        delta (if (>= minutes 0) (quot minutes 60) (dec (quot minutes 60)))
        hour (mod (+ hours delta) 24)]
    {:hour hour :min min}
  )
)

(defn add-time [old-time minutes] ;; <- arglist goes here
  (clock 0 (+ minutes (old-time :min) (* 60 (old-time :hour))))
)
