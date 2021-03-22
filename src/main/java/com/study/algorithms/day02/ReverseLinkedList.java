package com.study.algorithms.day02;

public class ReverseLinkedList {
    public static class Node {
        private int value;
        private Node next;
        public Node (int data) {
            this.value = data;
        }
    }
    public static class DoubleNode {
        private int value;
        private DoubleNode next;
        private DoubleNode last;
        public DoubleNode (int data) {
            this.value = data;
        }
    }

    public static Node reverseLinkedList (Node head) {
        Node prev = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static DoubleNode reverseDoubleLinkedList (DoubleNode head) {
        DoubleNode prev = null;
        DoubleNode next = null;
        while (head != null) {
            next = head.next;
            head.next = prev;
            head.last = next;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static Node deleteNode (Node head, int value) {
        while (head != null) {
            if (head.value != value) {
                break;
            }
            head = head.next;
        }
        // head来到第一个不用删的位置
        Node prev = head;
        Node cur = head;
        while (cur != null) {
            if (cur.value == value) {
                prev.next = cur.next;
            } else {
                prev = cur;
            }
            cur = cur.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        node1.next = node2;
        node2.next = node3;
        Node node = reverseLinkedList(node1);
        System.out.println(node);
        DoubleNode doubleNode1 = new DoubleNode(1);
        DoubleNode doubleNode2 = new DoubleNode(2);
        DoubleNode doubleNode3 = new DoubleNode(3);
        doubleNode1.next = doubleNode2;
        doubleNode2.next = doubleNode3;
        doubleNode2.last = doubleNode1;
        doubleNode3.last = doubleNode2;
        DoubleNode doubleNode = reverseDoubleLinkedList(doubleNode1);
        System.out.println(doubleNode);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(6);
        Node node8 = new Node(8);
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        Node node0 = deleteNode(node4,6);
        System.out.println(node0);
    }


}
