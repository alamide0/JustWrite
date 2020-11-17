package club.justwrite.java.algorithm.leetcode.p0201_p0250;

import club.justwrite.java.algorithm.leetcode.ListNode;

/**
 * @author ACC
 * @desc
 * @create 2020/11/3
 **/
public class LeetCode0206 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode reversed = solution.reverseList2(ListNode.generateListNode(1, 2, 3, 4, 5));
        ListNode.printListNode(reversed);
    }

    private static class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode cur = head;
            ListNode prev = null;

            while (cur != null) {
                ListNode tmp = cur.next;
                cur.next = prev;
                prev = cur;
                cur = tmp;
            }

            return prev;
        }

        public ListNode reverseList2(ListNode node) {
            if (node == null || node.next == null) {
                return node;
            }
            ListNode p = reverseList(node.next);
            node.next.next = node;
            node.next = null;
            return p;
        }
    }
}