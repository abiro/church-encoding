; Source: https://en.wikipedia.org/wiki/Church_encoding

(ns church-encoding.num)

(def zero
  (fn [f]
    (fn [x] x)))

(def one
  (fn [f]
    (fn [x]
      (f x))))

(def two
  (fn [f]
    (fn [x]
      (f (f x)))))

(def succ
  (fn [n]
    (fn [f]
      (fn [x]
        (f ((n f) x))))))

(def add
  (fn [n m]
    (fn [f]
      (fn [x]
        ((m f) ((n f) x))))))

;PRED := λnfx.n (λgh.h (g f)) (λu.x) (λu.u)
(def pred
  (fn [n]
    (fn [f]
      (fn [x]
        (((n (fn [g] (fn [h] (h (g f)))))
          (fn [u] x))
         (fn [u] u))))))
