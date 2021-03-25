package com.study.algorithms.day03;

/**
 * 归并排序
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {4, 2, 6, 1, 2, 3, 6, 8, 0};
        process(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(i);
        }
    }

    public static void process(int[] arr, int L, int R) {
        if (arr == null || L == R) {
            return;
        }
        int mid = L + ((R - L) >> 1);
        process(arr, L, mid);
        process(arr, mid + 1, R);
        mergeSort(arr, L, mid, R);
    }

    private static void mergeSort(int[] arr, int L, int mid, int R) {
        int[] help = new int[R - L + 1];
        int i = 0;// 这是给help用的
        int p1 = L;// 左边的指针
        int p2 = mid + 1;// 右边的指针
        while (p1 <= mid && p2 <= R) {
            // 此时没有任何指针越界
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            // 左边的没越界，右边的越界
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            // 右边的没越界，左边的越界
            help[i++] = arr[p2++];
        }
        for (int i1 = 0; i1 < help.length; i1++) {
            arr[L + i1] = help[i1];
        }
    }

}
