package com.study.algorithms;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Scanner;

@SpringBootTest
class AlgorithmsApplicationTests {
    public static void getRepeateNum( int[] num) {
        int NumChange;
        System.out.println("重复数字是：");
        for(int index = 0; index < num.length; index++) {
            while(num[index] != index) {
                if(num[index] == num[num[index]]) {
                    System.out.print(num[index]+" ");
                    break;
                } else {
                    NumChange = num[num[index]];
                    num[num[index]] = num[index];
                    num[index] = NumChange;
                }
            }
        }
    }
    @Test
    void contextLoads() {
//        int[] num = new int[5];  //数组长度可以自己定义
        int[] num = {0,1,2,3,4};
        getRepeateNum(num);
    }

}
