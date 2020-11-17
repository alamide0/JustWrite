package club.justwrite.java.algorithm.leetcode.p0051_p0100;

import club.justwrite.java.algorithm.leetcode.ListNode;

/**
 * @author ACC
 * @desc
 * @create 2020/11/3
 **/
public class LeetCode0061 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode res = solution.rotateRight(ListNode.generateListNode(1, 2, 3, 4, 5), 6);
        ListNode.printListNode(res);

        res = solution.rotateRight(ListNode.generateListNode(0, 1, 2), 4);
        ListNode.printListNode(res);
    }

    private static class Solution {
        public ListNode rotateRight(ListNode head, int k) {

            if(head == null || k == 0) return head;
            ListNode pHead = head;
            ListNode res = head;
            ListNode prev = head;

            int count = 0;
            while (pHead.next != null) {
                pHead = pHead.next;
                count++;
            }

            count += 1;

            pHead.next = head;

            int end = count - k % count;
            for (int i = 0; i < end; i++) {
                prev = res;
                res = res.next;
            }

            prev.next = null;

            return res;
        }
    }
}