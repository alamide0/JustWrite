package club.justwrite.java.algorithm.leetcode.p0001_p0050;

import club.justwrite.java.algorithm.leetcode.ListNode;
import club.justwrite.java.io.Printer;

/**
 * @author ACC
 * @desc
 * @create 2020/10/30
 **/
public class LeetCode0019 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode.printListNode(solution.removeNthFromEnd(ListNode.generateListNode(1), 1));
    }


    private static class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            int count = 1;
            ListNode fast = head;
            ListNode slow = new ListNode(0, head);
            ListNode newHeader = slow;

            while (count < n) {
                fast = fast.next;
                count++;
            }

            while (fast.next != null) {
                fast = fast.next;
                slow = slow.next;
            }

            slow.next = slow.next.next;

            return newHeader.next;
        }
    }
}