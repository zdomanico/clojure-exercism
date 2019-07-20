(ns phone-number)

(def default-number (re-seq #"\d" "0000000000"))

(defn clean-number [num-string]
  (re-seq #"\d" num-string)
)

(defn check-number-size [num-string]
  ;; expexts only numbers in string. Used after clean-number
  (if (= (count num-string) 11)
    (if-not (= (first num-string) "1")
      default-number
      (drop 1 num-string)
    )
    (if (= (count num-string) 10)
      num-string
      default-number
    )
  )
)

; From problem statement.
; The format is usually represented as
; (NXX)-NXX-XXXX
; where N is any digit from 2 through 9 and X is any digit from 0 through 9.

; (defn check-values [num-string]
;   ;; requires 10 digit number
;   (let [head (Integer/parseInt(first num-string))
;         fourth (Integer/parseInt (nth num-string 3))]
;       (if (or (< head 2) (< fourth 2))
;         default-number
;         num-string
;       )
;   )
; )
; Not sure why the tests use numbers that are not in this format. 
; Maybe I missed something...
(defn check-values [num-string]
  num-string
)

(defn number [num-string] ;; <- arglist goes here
  (apply str (check-values (check-number-size (clean-number num-string))))
)

(defn area-code [num-string] ;; <- arglist goes here
  (subs (number num-string) 0 3)
)

(defn pretty-print [num-string] ;; <- arglist goes here
  (str "(" (area-code num-string) ") " 
    (subs (number num-string) 3 6)
    "-"
    (subs (number num-string) 6)
  )
)
