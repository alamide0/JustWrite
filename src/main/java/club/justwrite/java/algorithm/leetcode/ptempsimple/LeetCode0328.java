package club.justwrite.java.algorithm.leetcode.ptempsimple;

import club.justwrite.java.algorithm.leetcode.ListNode;
import club.justwrite.java.io.Printer;

/**
 * @author ACC
 * @desc
 * @create 2020/11/13
 **/
public class LeetCode0328 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode.printListNode(solution.oddEvenList(ListNode.generateListNode(1, 2, 3, 4, 5, 6, 7, 8, 9)));
    }

    private static class Solution {
        public ListNode oddEvenList(ListNode head) {
            if (head == null || head.next == null) return head;
            ListNode oddHead = head.next;
            ListNode even = head, odd = oddHead;
            ListNode cur = oddHead.next;

            while (cur != null) {
                even.next = cur;
                cur = cur.next;
                even = even.next;
                even.next = null;


                if (cur != null) {
                    odd.next = cur;
                    cur = cur.next;
                    odd = odd.next;
                }

                odd.next = null;
            }

            even.next = oddHead;

            return head;
        }
    }
}
