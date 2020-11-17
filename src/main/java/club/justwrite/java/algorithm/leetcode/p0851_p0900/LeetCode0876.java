package club.justwrite.java.algorithm.leetcode.p0851_p0900;

import club.justwrite.java.algorithm.leetcode.ListNode;
import club.justwrite.java.io.Printer;

/**
 * @author ACC
 * @desc
 * @create 2020/11/3
 **/
public class LeetCode0876 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Printer.print(solution.middleNode(ListNode.generateListNode(1, 2, 3, 4, 5, 6)).val);
        Printer.print(solution.middleNode(ListNode.generateListNode(1, 2, 3, 4, 5)).val);
    }

    private static class Solution {
        public ListNode middleNode(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            return slow;
        }
    }
}