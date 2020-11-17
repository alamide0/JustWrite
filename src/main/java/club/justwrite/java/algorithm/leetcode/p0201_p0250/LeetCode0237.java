package club.justwrite.java.algorithm.leetcode.p0201_p0250;

import club.justwrite.java.algorithm.leetcode.ListNode;

/**
 * @author ACC
 * @desc ??? 没看懂题目，直接看的题解
 * @create 2020/11/3
 **/
public class LeetCode0237 {

    public static void main(String[] args) {

    }

    private static class Solution {
        public void deleteNode(ListNode node) {
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }
}