package club.justwrite.java.algorithm.leetcode.p0201_p0250;

import club.justwrite.java.algorithm.leetcode.ListNode;
import club.justwrite.java.algorithm.leetcode.TreeNode;

import club.justwrite.java.io.Printer;

/**
 * @author ACC
 * @desc
 * @create 2020/10/22
 **/
public class LeetCode0232 {

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        Printer.print(myQueue.pop());
        myQueue.push(2);
        Printer.print(myQueue.peek());
    }

    static class MyQueue {

        private Node head;
        private Node tail;
        private int size = 0;

        private class Node {
            int val;
            Node next;
            Node previous;

            Node(int val) {
                this.val = val;
            }
        }

        /**
         * Initialize your data structure here.
         */
        public MyQueue() {

        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            if (tail == null) {
                head = new Node(x);
                tail = head;
            } else {
                tail.next = new Node(x);
                tail.next.previous = tail;
                tail = tail.next;
            }
            size++;
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            int res = head.val;
            Node node = head;
            head = head.next;
            if (head != null) {
                head.previous = null;
            } else {
                tail = null;
            }
            node.next = null;
            size--;
            return res;
        }

        /**
         * Get the front element.
         */
        public int peek() {
            return head.val;
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return size == 0;
        }
    }

    /**
     * Your MyQueue object will be instantiated and called as such:
     * MyQueue obj = new MyQueue();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.peek();
     * boolean param_4 = obj.empty();
     */
}