(ns church-encoding.num-test
  (:require [clojure.test :refer :all]
            [church-encoding.num :refer :all]))

(deftest test-zero
  (is (= 0 ((zero inc) 0))))

(deftest test-one
  (is (= 1 ((one inc) 0))))

(deftest test-two
  (is (= 2 ((two inc) 0))))

(deftest test-succ
  (is (= 1 (((succ zero) inc) 0)))
  (is (= 2 (((succ one) inc) 0)))
  (is (= 3 (((succ two) inc) 0))))

(deftest test-add
  (is (= 0 (((add zero zero) inc) 0)))
  (is (= 1 (((add zero one) inc) 0)))
  (is (= 1 (((add one zero) inc) 0)))
  (is (= 2 (((add one one) inc) 0)))
  (is (= 3 (((add two one) inc) 0)))
  (is (= 4 (((add two two) inc) 0))))

(deftest test-pred
  ; If n - m < 0, it is defined to be 0 for Church numerals.
  (is (= 0 (((pred zero) inc) 0)))
  (is (= 0 (((pred one) inc) 0)))
  (is (= 1 (((pred two) inc) 0))))
