package club.justwrite.java.algorithm.leetcode.ptempsimple;

import club.justwrite.java.algorithm.leetcode.ListNode;
import club.justwrite.java.io.Printer;

/**
 * @author ACC
 * @desc
 * @create 2020/11/13
 **/
public class LeetCode0024 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode.printListNode(solution.swapPairs(ListNode.generateListNode(1,2,3,4,5,6)));
        ListNode.printListNode(solution.swapPairs(ListNode.generateListNode(1,2,3,4,5,6, 7)));
        ListNode.printListNode(solution.swapPairs(ListNode.generateListNode()));
    }

    private static class Solution {
        public ListNode swapPairs(ListNode head) {

            ListNode h = new ListNode(0, head);

            ListNode pointer = h;


            while (pointer.next != null && pointer.next.next != null) {
                ListNode first = pointer.next;
                ListNode second = pointer.next.next;

                pointer.next = second;
                first.next = second.next;
                second.next = first;

                pointer = first;
            }

            return h.next;
        }
    }
}
