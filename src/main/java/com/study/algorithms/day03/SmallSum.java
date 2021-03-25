package com.study.algorithms.day03;

/**
 * 数组小和问题，以及降序对问题
 */
public class SmallSum {

    public static void main(String[] args) {
        int[] arr = {4, 2, 6, 1, 2, 3, 6, 8, 0};
        int[] arr1 = {4, 2, 6, 1};
        // 非归并排序（任何递归都可以改成非递归）
        int totalMin = process(arr, 0, arr.length - 1);
        System.out.println(totalMin);
    }
    // 使用归并排序
    public static int process(int[] arr, int L, int R) {
        if (arr == null || L == R) {
            return 0;
        }
        int mid = L + ((R - L) >> 1);
        return process(arr, L, mid) + process(arr, mid + 1, R) + merge(arr, L, mid, R);
    }

    private static int merge(int[] arr, int L, int mid, int R) {
        int[] help = new int[R - L + 1];
        int i = 0;// 这是给help用的
        int res = 0;
        int p1 = L;// 左边的指针
        int p2 = mid + 1;// 右边的指针
        while (p1 <= mid && p2 <= R) {
            // 此时没有任何指针越界
            if ( arr[p1] < arr[p2]) {
                int num = R - p2 + 1;
                res += num * arr[p1];
                help[i++] = arr[p1++];
            } else {
                help[i++] = arr[p2++];
            }
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
        return res;
    }
}
