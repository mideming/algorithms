package com.study.algorithms.day01;

/**
 * 插入排序
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {2, 3, 9, 7, 1, 5, 0, 6, 8, 4};
        insertSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j --) {
                if (arr[j] > arr[j + 1]) {
                    arr[j] = arr[j]^arr[j + 1];
                    arr[j + 1] = arr[j]^arr[j + 1];
                    arr[j] = arr[j]^arr[j + 1];
                }
            }
        }
    }
}
