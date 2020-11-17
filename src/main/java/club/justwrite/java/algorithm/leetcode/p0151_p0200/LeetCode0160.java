package club.justwrite.java.algorithm.leetcode.p0151_p0200;

import club.justwrite.java.algorithm.leetcode.ListNode;
import club.justwrite.java.io.Printer;

/**
 * @author ACC
 * @desc
 * @create 2020/11/3
 **/
public class LeetCode0160 {

    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode listNode1 = ListNode.generateListNode(4, 1, 8, 4, 5);

        ListNode listNode2 = ListNode.generateListNode(5, 0, 1);

        listNode2.next.next.next = listNode1.next.next;
        Printer.print(solution.getIntersectionNode(listNode1, listNode2).val);
    }

    private static class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

            ListNode pA = headA;
            ListNode pB = headB;

            while (pA != pB) {
                pA = pA == null ? headB : pA.next;
                pB = pB == null ? headA : pB.next;
            }

            return pA;
        }


    }
}