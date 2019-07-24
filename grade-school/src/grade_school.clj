(ns grade-school)

(defn grade [school grade]  ;; <- arglist goes here
  (school grade [])
)

(defn add [school name grade]  ;; <- arglist goes here
  (if (contains? school grade)
    (update school grade conj name)
    (assoc school grade [name]) 
  )
)

(defn sorted [school]  ;; <- arglist goes here
  (into {} 
    (for [[k v] (into (sorted-map) school)] 
      [k (sort v)]
    )
  )
)
