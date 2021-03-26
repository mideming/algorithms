package com.study.algorithms.day02;

public class DoubleLinkedListToStackAndQueue<T> {
    public static class DoubleNode<T> {
        T value;
        DoubleNode<T> last;
        DoubleNode<T> next;
        public DoubleNode (T data) {
            this.value = data;
        }
    }

    public static class DoubleToStackAndQueue<T> {
        DoubleNode<T> head;
        DoubleNode<T> tail;
        public void addFromHead(T value) {
            DoubleNode cur = new DoubleNode(value);
            if (head == null) {
                head = cur;
                tail = cur;
            } else {
                cur.next = head;
                head.last = cur;
                head = cur;
            }
        }
        public void addFromTail (T value) {
            DoubleNode cur = new DoubleNode(value);
            if (tail == null) {
                tail = cur;
                head = cur;
            } else {
                cur.last = tail;
                tail.next = cur;
                tail = cur;
            }
        }
        public T popFromHead() {
            if (head == null) {
                return null;
            } else {
                DoubleNode<T> cur = head;
                if (head == tail) {
                    head = null;
                    tail = null;
                } else {
                    head = head.next;
                    head.last = null;
                    cur.next = null;
                }
                return cur.value;
            }
        }
        public T popFromTail() {
            if (head == null) {
                return null;
            } else {
                DoubleNode<T> cur = tail;
                if (head == tail) {
                    head = null;
                    tail = null;
                } else {
                    tail = tail.last;
                    tail.next = null;
                    cur.last = null;
                }
                return cur.value;
            }
        }
    }

    public static class MyStack<T> {
        private DoubleToStackAndQueue<T> stack;
        public MyStack () {
            stack = new DoubleToStackAndQueue<T>();
        }
        public void push(T value) {
            stack.addFromHead(value);
        }
        public T pop () {
            return stack.popFromHead();
        }
    }

    public static class MyQueue<T> {
        private DoubleToStackAndQueue<T> queue;
        public MyQueue () {
            queue = new DoubleToStackAndQueue<T>();
        }
        public void push(T value) {
            queue.addFromHead(value);
        }
        public T pop () {
            return queue.popFromTail();
        }
    }
}
