package com.study.algorithms.day01;

public class XORDemo {
    public static void main(String[] args) {
        int[] a = {1,2,3,6,7,5,1,2,3,6,7,6,5};
        System.out.println("一个数组中有1个数出现了奇数次");
        int eor1 = 0;
        for (int i = 0; i < a.length; i++) {
            eor1 = a[i] ^ eor1;
        }
        System.out.println(eor1);
        int[] b = {1,2,3,6,7,5,1,2,3,6,7,6,5,5};
        System.out.println("一个数组中有2个不同的数出现了奇数次");
        int eor2 = 0;
        for (int i = 0; i < b.length; i++) {
            // eor2 = x ^ y，必然有一位是1
            eor2 = b[i] ^ eor2;
        }
        // 找出最右边的1
        int rightOne = eor2 & (~eor2 + 1);
        int eor3 = 0;
        for (int i = 0; i < b.length; i++) {
            if ((rightOne & b[i]) == 0) {
                // 分组，rightOne位置为0的都进行异或
                eor3 = eor3 ^ b[i];
            }
        }
        int eor4 = eor2 ^ eor3;
        System.out.println(eor3);
        System.out.println(eor4);
        System.out.println("找出一个数1的个数");
        int c = 11;
        int count = 0;
        while (c != 0) {
            int rightOne2 = c & (~c + 1);
            c ^= rightOne2;
            count ++;
        }
        System.out.println(count);

    }
}
