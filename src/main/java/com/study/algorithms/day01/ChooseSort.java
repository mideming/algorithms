package com.study.algorithms.day01;

/**
 * 选择排序
 */
public class ChooseSort {
    public static void main(String[] args) {
        int[] arr = {2, 3, 9, 7, 1, 5, 0, 6, 8, 4};
        chooseSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void chooseSort (int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr [j]) {
                    arr[i] = arr[j]^arr[i];
                    arr[j] = arr[i]^arr[j];
                    arr[i] = arr[i]^arr[j];
                }
            }
        }
    }
}
