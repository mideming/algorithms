package com.study.algorithms.day02;

import java.util.HashMap;
import java.util.TreeMap;

public class HashMapAndSortedMap {
    public static void main(String[] args) {
        // 哈希表增删改查都是O(1)
        // 哈希表中不管是基本数据类型(int)还是引用基本数据类型(Integer)，默认是按值传递
        // 如果基本数据类型，key有100k，value有100k，则占用200k，但是如果是引用数据类型，只存内存地址，一个是8字节，一共16字节。
        HashMap<Integer, String> map = new HashMap<>();
        int a = 10000;
        int b = 10000;
        System.out.println(a == b);
        Integer a1 = 129;
        Integer b1 = 129;
        System.out.println(a1 == b1);
        System.out.println(a1.equals(b1));
        Integer a2 = 10;
        Integer b2 = 10;
        System.out.println(a2 == b2);
        System.out.println("=================");
        // 有序哈希表，相比哈希表，时间复杂度O(logN)
        // 如果是引用类型，需要使用比较器进行排序
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(2, "我是2");
        treeMap.put(5, "我是5");
        treeMap.put(3, "我是3");
        treeMap.put(1, "我是1");
        treeMap.put(4, "我是4");
        System.out.println(treeMap);
        System.out.println("最小的key" + treeMap.firstKey());
        System.out.println("最小的key" + treeMap.lastKey());
        System.out.println("<=3最近的:" + treeMap.floorKey(3));
        System.out.println(">=4最近的:" + treeMap.ceilingKey(4));
    }
}
