package com.study.algorithms.test;

import java.util.Stack;

class MinStack {
    Stack<Integer> stack;
    Stack<Integer> stackMin;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack();
        stackMin = new Stack();
    }

    public void push(int val) {
        stack.push(val);
        if(!stackMin.isEmpty() && stackMin.peek() < val) {
            stackMin.push(stackMin.peek());
        } else {
            stackMin.push(val);
        }
    }

    public void pop() {
        stack.pop();
        stackMin.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return stackMin.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(1);
        minStack.push(4);
        minStack.push(2);
        minStack.push(3);
        System.out.println(minStack.getMin());
    }

}
