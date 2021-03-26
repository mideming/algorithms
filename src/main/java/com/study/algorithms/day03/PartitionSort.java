package com.study.algorithms.day03;

public class PartitionSort {

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 6, 7, 3, 9, 0};
        test(arr, 3);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("=============");
        int[] arr2 = {3, 2, 1, 6, 7, 3, 9, 0};
        test2(arr2, 3);
        for (int i = 0; i < arr2.length; i++) {
            System.out.println(arr2[i]);
        }
    }
    public static void test (int[] arr, int num) {
        int a = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= num) {
//                arr[a + 1] = arr[a + 1]^arr[i];
//                arr[i] = arr[a + 1]^arr[i];
//                arr[a + 1] = arr[a + 1]^arr[i];
                int temp = arr[a+1];
                arr[a+1] = arr[i];
                arr[i] = temp;
                a++;
            }
        }
    }
    public static void test2 (int[] arr, int num) {
        int l = -1;
        int r = arr.length;
        for (int i = 0; i < arr.length; i++) {
            if (i == r) {
                break;
            }
            if (arr[i] < num) {
//                arr[a + 1] = arr[a + 1]^arr[i];
//                arr[i] = arr[a + 1]^arr[i];
//                arr[a + 1] = arr[a + 1]^arr[i];
                int temp = arr[l+1];
                arr[l+1] = arr[i];
                arr[i] = temp;
                l++;
            } else if (arr[i] == num) {

            } else if (arr[i] > num) {
                int temp = arr[r-1];
                arr[r-1] = arr[i];
                arr[i] = temp;
                r--;
                i--;
            }
        }
    }
}
