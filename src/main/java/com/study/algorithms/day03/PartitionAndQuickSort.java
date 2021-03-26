package com.study.algorithms.day03;

public class PartitionAndQuickSort {

    public static void main(String[] args) {
        int[] arr1 = {1,6,7,2,3,5,0,8,7,0,6,3,9,3,6,7,9};
        quickSort1(arr1);
        for (int i = 0; i < arr1.length; i++) {
            System.out.println(arr1[i]);
        }

        System.out.println("===================");
        int[] arr2 = {1,6,7,2,3,5,0,8,7,0,6,3,9,3,6,7,9};
        quickSort2(arr2);
        for (int i = 0; i < arr2.length; i++) {
            System.out.println(arr2[i]);
        }

        System.out.println("===================");
        int[] arr3 = {1,6,7,2,3,5,0,8,7,0,6,3,9,3,6,7,9};
        quickSort3(arr3);
        for (int i = 0; i < arr3.length; i++) {
            System.out.println(arr3[i]);
        }
    }
    public static void quickSort1 (int[] arr) {
        if (arr == null && arr.length < 2) {
            return;
        }
        process1(arr, 0, arr.length - 1);
    }
    public static void process1(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        // <=arr[R]  arr[R]    >=arr[R]
        // L...M-1     M       M+1...R
        int M = partition(arr, L, R);
        process1(arr, L, M - 1);
        process1(arr, M + 1, R);
    }

    public static int partition(int[] arr, int L, int R) {
        if (L > R) {
            return -1;
        }
        if (L == R) {
            return L;
        }
        int less = L - 1;
        int index = L;
        while (index < R) {
            if (arr[index] <= arr[R]) {
                swap(arr, index, ++less);
            }
            index++;
        }
        swap(arr, ++less, R);
        return less;
    }

    public static void quickSort2 (int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process2(arr, 0, arr.length - 1);
    }

    public static void quickSort3 (int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process3(arr, 0, arr.length - 1);
    }
    public static void process3(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        swap(arr, L + (int) (Math.random() * (R - L + 1)), R);
        // <=arr[R]  arr[R]    >=arr[R]
        // L...M-1     M       M+1...R
        int[] equalArea = netherlandsFlag(arr, L, R);
        process3(arr, L, equalArea[0] - 1);
        process3(arr, equalArea[1] + 1, R);
    }
    public static void process2(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        // <=arr[R]  arr[R]    >=arr[R]
        // L...M-1     M       M+1...R
        int[] equalArea = netherlandsFlag(arr, L, R);
        process2(arr, L, equalArea[0] - 1);
        process2(arr, equalArea[1] + 1, R);
    }

    // arr[L...R] 玩荷兰国旗的划分，以arr[R]做划分值
    public static int[] netherlandsFlag(int[] arr, int L, int R) {
        if (arr == null) {
            return new int[] {-1, -1};
        }
        if (L == R) {
            return new int[] {L, R};
        }
        int less = L - 1;
        int more = R;
        int index = L;
        while (index < more) {
            if (arr[index] < arr[R]) {
                // 左边界右移一位并且和当前下标交换，当前下标右移一位
                swap(arr, index++, ++less);
            } else if (arr[index] > arr[R]) {
                // 右边界左移一位并且和当前下标交换，因为这一位没有做过比较，所以index不动，继续比较
                swap(arr, index, --more);
            } else {
                // 直接当前下标右移一位
                index++;
            }
        }
        // L...less   less+1...more-1   more...R-1   R
        swap(arr, more, R);
        // L...less   less+1...more   more+1...R
        return new int[] {less + 1, more};
    }
    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
