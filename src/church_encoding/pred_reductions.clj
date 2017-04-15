(ns church-encoding.pred-reductions
  (:require [church-encoding.num :refer :all]))

; Step-by-step reductions of (pred zero), (pred one) and (pred two).
; See 'church-encoding.num for the definition of 'pred.

; Reduction steps for (pred zero)
(def pred-zero-1
  (fn [f]
    (fn [x]
      ; (zero f) => (fn [x] x)
      (((fn [x] x)
        (fn [u] x))
       (fn [u] u)))))

(def pred-zero-2
  (fn [f]
    (fn [x]
      ((fn [u] x)
       (fn [u] u)))))

(def pred-zero-3
  (fn [f]
    (fn [x]
      x)))

; Reduction steps for (pred one)
(def pred-one-1
  (fn [f]
    (fn [x]
      ; (one f) => (fn [x] (f x))
      (((fn [x]
          ((fn [g] (fn [h] (h (g f)))) x))
        (fn [u] x))
       (fn [u] u)))))

(def pred-one-2
  (fn [f]
    (fn [x]
      (((fn [g] (fn [h] (h (g f)))) (fn [u] x))
       (fn [u] u)))))

(def pred-one-3
  (fn [f]
    (fn [x]
      ; Skip one application of f.
      ((fn [h] (h ((fn [u] x) f)))
       (fn [u] u)))))

(def pred-one-4
  (fn [f]
    (fn [x]
      ((fn [h] (h x))
       (fn [u] u)))))

(def pred-one-5
  (fn [f]
    (fn [x]
      ((fn [u] u) x))))

(def pred-one-6
  (fn [f]
    (fn [x]
      x)))

; Reduction steps for (pred two)
(def pred-two-1
  (fn [f]
    (fn [x]
      ; (two f) => (fn [x] (f (f x)))
      (((fn [x]
          ((fn [g] (fn [h] (h (g f))))
           ((fn [g] (fn [h] (h (g f)))) x)))
        (fn [u] x))
       (fn [u] u)))))

(def pred-two-2
  (fn [f]
    (fn [x]
      (((fn [g] (fn [h] (h (g f))))
        ((fn [g] (fn [h] (h (g f)))) (fn [u] x)))
       (fn [u] u)))))

(def pred-two-3
  (fn [f]
    (fn [x]
      (((fn [g] (fn [h] (h (g f))))
        ; Skip one application of f.
        (fn [h] (h ((fn [u] x) f))))
       (fn [u] u)))))

(def pred-two-4
  (fn [f]
    (fn [x]
      (((fn [g] (fn [h] (h (g f))))
        (fn [h] (h x)))
       (fn [u] u)))))

(def pred-two-5
  (fn [f]
    (fn [x]
      ; "Prepend" f to x.
      ((fn [h] (h ((fn [h] (h x)) f)))
       (fn [u] u)))))

(def pred-two-6
  (fn [f]
    (fn [x]
      ; Use identity function to terminate "prepending".
      ((fn [h] (h (f x)))
       (fn [u] u)))))

(def pred-two-7
  (fn [f]
    (fn [x]
      ((fn [u] u) (f x)))))

(def pred-two-8
  (fn [f]
    (fn [x]
      (f x))))
