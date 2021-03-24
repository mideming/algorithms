package com.study.algorithms.day02;

/**
 * 获取栈的最小值
 * 使用2个数组，一个数组正常存取，另一个只存当前最小值
 */
public class GetMinStack<T> {
    Object[] arr;
    int elementCount;
    public GetMinStack(int l) {
        arr = new Object[l];
        elementCount = 0;
    }
    public void push (T i) {
        if(elementCount == arr.length) {
            throw new RuntimeException("元素已经满啦");
        }
        arr[elementCount] = i;
        elementCount++;
    }
    public T pop () {
        if (elementCount == 0) {
            throw new RuntimeException("没有元素可以弹出");
        }
        T peek = peek();
        arr[elementCount - 1] = null;
        elementCount--;
        return peek;
    }
    public T peek () {
        if (elementCount == 0) {
            throw new RuntimeException("栈顶没有元素");
        }
        return (T)arr[elementCount - 1];
    }
    public static class MyStack {
        private GetMinStack<Integer> stackData;
        private GetMinStack<Integer> stackMin;
        public MyStack (int l) {
            stackData = new GetMinStack(l);
            stackMin = new GetMinStack(l);
        }
        public void push (Integer i) {
            stackData.push(i);
            if (stackMin.elementCount == 0) {
                stackMin.push(i);
            } else if (i < stackMin.peek()) {
                stackMin.push(i);
            } else {
                stackMin.push(stackMin.peek());
            }
        }
        public Integer pop () {
            stackMin.pop();
            return stackData.pop();
        }
        public Integer getMin () {
            return stackMin.peek();
        }
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack(10);
        myStack.push(2);
        myStack.push(5);
        myStack.push(1);
        myStack.push(3);
        System.out.println(myStack.getMin());
        myStack.pop();
        System.out.println(myStack.getMin());
        myStack.pop();
        System.out.println(myStack.getMin());
        myStack.pop();

    }
}
