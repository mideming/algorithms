package com.study.algorithms.day02;

import java.util.Stack;

/**
 * 两个队列实现栈：存的时候，队列1存，取的时候，队列1把数据都导给队列2，只留最后一个，返回。下次交替执行
 * 两个栈实现队列：一个stack1负责存，一个stack2负责取，存的时候判断stack2是否为空，为空则反向pop给stack2。
 */
public class TwoStackToQueue {
    private Stack<Integer> pushStack;
    private Stack<Integer> popStack;
    public TwoStackToQueue () {
        pushStack = new Stack<>();
        popStack = new Stack<>();
    }
    public void push(Integer i) {
        pushStack.push(i);
        pushToPop();
    }
    public void pushToPop() {
        if (popStack.empty()) {
            while (!pushStack.empty()) {
                popStack.push(pushStack.pop());
            }
        }
    }
    public void pop() {
        if (pushStack.empty() && popStack.empty()) {
            throw new RuntimeException("队列没有数据");
        }
        pushToPop();
        popStack.pop();
    }
    public Integer peek() {
        if (pushStack.empty() && popStack.empty()) {
            throw new RuntimeException("队列没有数据");
        }
        pushToPop();
        return popStack.peek();
    }

    public static void main(String[] args) {
        TwoStackToQueue queue = new TwoStackToQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        System.out.println(queue.peek());
        queue.pop();
        System.out.println(queue.peek());
        queue.pop();
        System.out.println(queue.peek());
        queue.pop();
        System.out.println(queue.peek());
    }
}
