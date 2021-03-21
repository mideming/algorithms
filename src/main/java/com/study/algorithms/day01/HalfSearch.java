package com.study.algorithms.day01;

public class HalfSearch {
    public static void main(String[] args) {
        int[] arr = {0, 1, 3, 4, 6, 7, 8, 9};
        int i = halfSearch(arr, 8);
        System.out.println(i);
    }
    public static int halfSearch(int[] arr, int i) {
        int left = 0;
        int right = arr.length -1;
        while(left <= right) {
            int middle = left + ((right - left) >>1);
            if (arr[middle] < i) {
                left = middle + 1;
            } else if(arr[middle] > i) {
                right = middle - 1;
            } else {
                return middle;
            }
        }
        return -1;
    }
}
