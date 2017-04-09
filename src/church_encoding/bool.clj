(ns church-encoding.bool)

(def True
  (fn [a b] a))

(def False 
  (fn [a b] b))

(def If
  (fn [p a b]
    (p a b)))

(def Not
  (fn [p]
    (p False True)))

(def And
  (fn [p q]
    (q (p True False) False)))

(def Or
  (fn [p q]
    ((p True False) True q)))

(def Xor
  (fn [p q]
    (And (Or p q) (Not (And p q)))))
