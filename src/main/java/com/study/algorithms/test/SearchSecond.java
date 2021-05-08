package com.study.algorithms.test;

public class SearchSecond {
    public static void main(String[] args) {
        int[] a = {2,1,6,4,7,5,0,9,10,11,15,34,12,3,34};
        int max = a[0];
        int secondMax = a[1];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max && a[i] > secondMax) {
                secondMax = max;
                max = a[i];
            } else if(a[i] > secondMax) {
                secondMax = a[i];
            }
        }
        System.out.println(secondMax);
        System.out.println(max);
    }
}
