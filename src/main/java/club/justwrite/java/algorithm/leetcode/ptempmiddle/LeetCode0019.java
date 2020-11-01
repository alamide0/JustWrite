package club.justwrite.java.algorithm.leetcode.ptempmiddle;

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
        ListNode.printListNode(solution.removeNthFromEnd(ListNode.generateListNode(1, 2, 3, 4, 5, 6, 7), 1));
    }


    private static class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            int count = 1;
            ListNode fast = head;
            ListNode slow = head;
            ListNode prev = head;

            while (count < n) {
                fast = fast.next;
                count++;
            }

            while (true) {
                fast = fast.next;
                if (fast == null) break;
                prev = slow;
                slow = slow.next;
            }

            prev.next = slow.next;

            return prev == head ? prev.next : head;
        }
    }
}
