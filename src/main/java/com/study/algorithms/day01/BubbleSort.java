package com.study.algorithms.day01;

/**
 * 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {2, 3, 9, 7, 1, 5, 0, 6, 8, 4};
        bubbleSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void bubbleSort (int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr [j + 1]) {
                    arr[j] = arr[j]^arr[j + 1];
                    arr[j + 1] = arr[j]^arr[j + 1];
                    arr[j] = arr[j]^arr[j + 1];
                }
            }
        }
    }
}
