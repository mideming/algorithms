package com.study.algorithms.day02;

/**
 * 数组实现栈和队列
 * 栈：正常加，取从尾部取
 * 队列：循环数组
 */
public class ArrayToStackAndQueue {
    public static class MyQueue {
        private int[] arr = new int[7];
        private int putIndex = 0;
        private int popIndex = 0;
        private int size = 0;
        private int limit = 7;

        public void push(int a) {
            if (size < limit) {
                arr[putIndex] = a;
                if (putIndex == (limit -1)) {
                    putIndex = 0;
                } else {
                    putIndex++;
                }
                size++;
            } else {
                throw new RuntimeException("越界");
            }
        }

        public int pop() {
            if (size == 0) {
                throw new RuntimeException("队列为空");
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
