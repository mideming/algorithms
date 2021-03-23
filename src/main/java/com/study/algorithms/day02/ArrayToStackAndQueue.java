package com.study.algorithms.day02;

public class ArrayToStackAndQueue {
    public static class MyQueue {
        private int[] arr = new int[7];
        private int putIndex = 0;
        private int popIndex = 0;
        private int size = 0;
        private int limit = 7;

        public void push(int a) throws Exception {
            if (size < limit) {
                arr[putIndex] = a;
                if (putIndex == (limit -1)) {
                    putIndex = 0;
                } else {
                    putIndex++;
                }
                size++;
            } else {
                throw new Exception("越界");
            }
        }

        public int pop() throws Exception {
            if (size == 0) {
                throw new Exception("队列为空");
            }
            int i = arr[popIndex - 1];
            if (popIndex == (limit -1)) {
                popIndex = 0;
            } else {
                popIndex++;
            }
            return i;
        }
    }
}
