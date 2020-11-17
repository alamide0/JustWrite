package club.justwrite.java.algorithm.leetcode.p0051_p0100;

import club.justwrite.java.algorithm.leetcode.ListNode;

/**
 * @author ACC
 * @desc
 * @create 2020/11/3
 **/
public class LeetCode0083 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode res1 = solution.deleteDuplicates(ListNode.generateListNode(1, 1, 2));
        ListNode.printListNode(res1);

        res1 = solution.deleteDuplicates(ListNode.generateListNode(1, 1, 2, 3, 3));
        ListNode.printListNode(res1);
    }

    private static class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null) return null;
            ListNode prev = head;
            ListNode cur = head.next;

            while (cur != null) {
                if (prev.val == cur.val) {
                    prev.next = cur.next;
                } else {
                    prev = cur;
                }

                cur = cur.next;
            }

            return head;
        }
    }
}