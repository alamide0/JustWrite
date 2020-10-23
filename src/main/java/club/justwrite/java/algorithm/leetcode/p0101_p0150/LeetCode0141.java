package club.justwrite.java.algorithm.leetcode.p0101_p0150;

import club.justwrite.java.algorithm.leetcode.ListNode;

/**
 * @author ACC
 * @desc
 * @create 2020/10/23
 **/
public class LeetCode0141 {

    public static void main(String[] args) {

    }

    /**
     * Definition for singly-linked list.
     * class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    static class Solution {
        public boolean hasCycle(ListNode head) {
            if (head == null) return false;
            ListNode slow = head;
            ListNode fast = head.next;

            while (slow != fast) {
                if (slow == null || fast == null || fast.next == null) return false;
                slow = slow.next;
                fast = fast.next.next;
            }

            return true;
        }
    }
}