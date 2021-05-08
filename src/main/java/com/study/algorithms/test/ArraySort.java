package com.study.algorithms.test;

public class ArraySort {
    public static void main(String[] args) {
        int[] a = {1, 3, 5, 7, 0, 0, 0, 0, 0, 0};
        int[] b = {2, 4, 6, 7, 8, 9};
        int m = 4;
        int n = 6;
        merge(a, b, m, n);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
    public static void merge(int[] a, int[] b, int m, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n -1;
        while (i >= 0 && j >= 0) {
            if (a[i] > b[j]) {
                a[k--] = a[i--];
            } else {
                a[k--] = b[j--];
            }
        }
        while (j >= 0) {
            a[k--] = b[j--];
        }
    }
}
