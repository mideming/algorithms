package com.study.algorithms.day01;

public class PartMin {
    public static void main(String[] args) {
        int[] arr = {5, 3, 2, 4, 6, 7, 8, 9};
        int i = partMin(arr);
        System.out.println(i);
    }

    public static int partMin (int[] arr) {
        if (arr[0] < arr[1]) {
            return arr[0];
        }
        if (arr[arr.length - 1] < arr[arr.length - 2]) {
            return arr[arr.length - 1];
        }
        int L = 0;
        int R = arr.length - 1;
        while (L <= R) {
            int mid = L + ((R - L) >> 1);
            if (arr[mid] < arr[mid -1] && arr[mid] < arr[mid + 1]) {
                return arr[mid];
            } else if (arr[mid] > arr[mid - 1]) {
                R = mid -1;
            } else if (arr[mid] > arr[mid + 1]) {
                L = mid + 1;
            }
        }
        return -1;
    }
}
