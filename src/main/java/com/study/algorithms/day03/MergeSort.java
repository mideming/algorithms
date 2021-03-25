package com.study.algorithms.day03;

/**
 * 归并排序
 * T(N) = 2*T(N/2)+O(N^1)
 * 根据master可知时间复杂度为：O(N*logN)
 * merge过程需要辅助数组，所以空间复杂度为O(N)
 * 贵并排序的实质是把比较行为变成了有序信息并传递，比O(N^2)的排序快
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {4, 2, 6, 1, 2, 3, 6, 8, 0};
        // 归并排序
        process(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(i);
        }
        System.out.println("==================");
        // 非归并排序（任何递归都可以改成非递归）
        process2(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(i);
        }
    }

    // 使用归并排序
    public static void process(int[] arr, int L, int R) {
        if (arr == null || L == R) {
            return;
        }
        int mid = L + ((R - L) >> 1);
        process(arr, L, mid);
        process(arr, mid + 1, R);
        mergeSort(arr, L, mid, R);
    }

    // 不使用归并排序
    public static void process2(int[] arr) {
        if (arr == null && arr.length < 2) {
            return;
        }
        int mergeSize = 1;
        int N = arr.length;
        while (mergeSize < N) {
            int L = 0;
            while (L < N) {
                // L...M(mergeSize)左组
                int M = L + mergeSize - 1;
                if (M >= N) {
                    break;
                }
                // M+1...R(mergeSize)右组
                int R = Math.min(M + mergeSize, N - 1);
                mergeSort(arr, L, M, R);
                L = R + 1;
            }
            if (mergeSize > (N >> 2)) {
                break;
            }
            mergeSize <<= 2;
        }
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
