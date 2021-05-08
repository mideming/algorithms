package com.study.algorithms.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class CheckChar {

    public static void main(String[] args) {
        String s = "(){}[][]{}()[";
        boolean valid = isValid(s);
        System.out.println(valid);
    }
    public static boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                if (stack.isEmpty()) {
                    return false;
                }
                Character pop = stack.pop();
                if (!pop.equals(map.get(chars[i]))) {
                    return false;
                }
            } else {
                stack.push(chars[i]);
            }
        }
        return stack.isEmpty();
    }
}
