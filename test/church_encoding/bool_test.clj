(ns church-encoding.bool-test
  (:require [clojure.test :refer :all]
            [church-encoding.bool :refer :all]))

(deftest test-True
  (is (= (True 1 0) 1)))

(deftest test-False
  (is (= (False 1 0) 0)))

(deftest test-If
  (is (= (If True 1 0) 1))
  (is (= (If False 1 0) 0)))

(deftest test-Not
  (is (= (Not True) False))
  (is (= (Not False) True)))

(deftest test-And
  (is (= (And True True) True))
  (is (= (And True False) False))
  (is (= (And False True) False))
  (is (= (And False False) False)))

(deftest test-Or
  (is (= (Or True True) True))
  (is (= (Or True False) True))
  (is (= (Or False True) True))
  (is (= (Or False False) False)))

(deftest test-Xor
  (is (= (Xor True True) False))
  (is (= (Xor True False) True))
  (is (= (Xor False True) True))
  (is (= (Xor False False) False)))
