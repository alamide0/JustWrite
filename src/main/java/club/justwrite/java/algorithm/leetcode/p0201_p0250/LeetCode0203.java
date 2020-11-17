package club.justwrite.java.algorithm.leetcode.p0201_p0250;

import club.justwrite.java.algorithm.leetcode.ListNode;

/**
 * @author ACC
 * @desc
 * @create 2020/11/3
 **/
public class LeetCode0203 {

    public static void main(String[] args) {

    }

    private static class Solution {
        public ListNode removeElements(ListNode head, int val) {
            ListNode pHead = new ListNode(0, head);

            ListNode prev = pHead;
            ListNode cur = pHead.next;

            while (cur != null) {
                if (cur.val == val) {
                    prev.next = cur.next;
                } else {
                    prev = cur;
                }
                cur = cur.next;
            }

            return pHead.next;
        }
    }
}