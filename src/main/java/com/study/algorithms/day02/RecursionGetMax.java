package com.study.algorithms.day02;

/**
 * 递归找出最大值
 * 只要递归满足：T(N) = a * T(N/b) + O(N^d)
 * 1.log(b,a) > d   时间复杂度：O(N^log(b,a))
 * 1.log(b,a) < d   时间复杂度：O(N^d)
 * 1.log(b,a) == d   时间复杂度：O(N^d*logN)
 */
public class RecursionGetMax {
    public static int getMax(int[] arr, int L, int R) {
        if (L == R) {
            return arr[L];
        }
        int mid = L + ((R - L) >> 1);
        int leftMax = getMax(arr, L, mid);
        int rightMax = getMax(arr, mid + 1, R);
        return Math.max(leftMax, rightMax);
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 6, 4, 1};
        int max = getMax(arr, 0, arr.length - 1);
        System.out.println(max);
    }
}
