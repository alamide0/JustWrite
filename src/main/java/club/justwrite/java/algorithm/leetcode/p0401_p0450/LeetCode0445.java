package club.justwrite.java.algorithm.leetcode.p0401_p0450;

import club.justwrite.java.algorithm.leetcode.ListNode;
import club.justwrite.java.io.Printer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author ACC
 * @desc
 * @create 2020/11/3
 **/
public class LeetCode0445 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode res = solution.addTwoNumbers(ListNode.generateListNode(1), ListNode.generateListNode(9, 9));
        ListNode.printListNode(res);

    }

    private static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

            Deque<ListNode> deque1 = new LinkedList<>();
            Deque<ListNode> deque2 = new LinkedList<>();

            while (l1 != null) {
                deque1.push(l1);
                l1 = l1.next;
            }

            while (l2 != null) {
                deque2.push(l2);
                l2 = l2.next;
            }

            ListNode head = null;
            int extra = 0;
            while ((!deque1.isEmpty()) || (!deque2.isEmpty())) {
                int n1 = deque1.isEmpty() ? 0 : deque1.pop().val;
                int n2 = deque2.isEmpty() ? 0 : deque2.pop().val;
                ListNode node = new ListNode((n1 + n2 + extra) % 10);
                Printer.print(n1 + n2);
                node.next = head;
                head = node;
                extra = (n1 + n2 + extra) / 10;
            }

            Printer.print(extra);
            if (extra == 1) {
                ListNode node = new ListNode(extra);
                node.next = head;
                head = node;
            }

            return head;
        }


    }
}