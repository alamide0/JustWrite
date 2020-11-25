package club.justwrite.java.algorithm.leetcode.p0151_p0200;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author ACC
 * @desc
 * @create 2020/11/20
 **/
public class LeetCode0155 {

    private static class MinStack {

        private Deque<Integer> stack = new LinkedList<>();
        private Deque<Integer> minStack = new LinkedList<>();

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            minStack.push(Integer.MAX_VALUE);
        }

        public void push(int x) {
            stack.push(x);
            minStack.push(Math.min(x, minStack.peek()));
        }

        public void pop() {
            stack.pop();
            minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }
}