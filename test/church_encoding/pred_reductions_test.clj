(ns church-encoding.pred-reductions-test
  (:require [clojure.test :refer :all]
            [church-encoding.pred-reductions :refer :all]))

(deftest test-pred-zero-1
  (is (= 0 ((pred-zero-1 inc) 0))))

(deftest test-pred-zero-2
  (is (= 0 ((pred-zero-2 inc) 0))))

(deftest test-pred-zero-3
  (is (= 0 ((pred-zero-3 inc) 0))))

(deftest test-pred-one-1
  (is (= 0 ((pred-one-1 inc) 0))))

(deftest test-pred-one-2
  (is (= 0 ((pred-one-2 inc) 0))))

(deftest test-pred-one-3
  (is (= 0 ((pred-one-3 inc) 0))))

(deftest test-pred-one-4
  (is (= 0 ((pred-one-4 inc) 0))))

(deftest test-pred-one-5
  (is (= 0 ((pred-one-5 inc) 0))))

(deftest test-pred-one-6
  (is (= 0 ((pred-one-6 inc) 0))))

(deftest test-pred-two-1
  (is (= 1 ((pred-two-1 inc) 0))))

(deftest test-pred-two-2
  (is (= 1 ((pred-two-2 inc) 0))))

(deftest test-pred-two-3
  (is (= 1 ((pred-two-3 inc) 0))))

(deftest test-pred-two-4
  (is (= 1 ((pred-two-4 inc) 0))))

(deftest test-pred-two-5
  (is (= 1 ((pred-two-5 inc) 0))))

(deftest test-pred-two-6
  (is (= 1 ((pred-two-6 inc) 0))))

(deftest test-pred-two-7
  (is (= 1 ((pred-two-7 inc) 0))))

(deftest test-pred-two-8
  (is (= 1 ((pred-two-8 inc) 0))))
