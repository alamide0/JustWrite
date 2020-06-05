package club.justwrite.java.algorithm;

import club.justwrite.java.io.Printer;

/**
 * @author ACC
 * @desc
 * @create 2020/6/5 3:11 PM
 **/
public class LeetCode0002 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode listNode1 = fillList(5);
        ListNode listNode2 = fillList(5);
        printListNode(listNode1);
        printListNode(listNode2);
        printListNode(solution.addTwoNumbers(listNode1, listNode2));

    }

    private static ListNode fillList(int... values) {
        ListNode listNode = new ListNode(0);
        int count = 0;
        ListNode head = listNode;
        for (int v : values) {
            listNode.val = v;
            count++;
            if (count < values.length) {
                listNode.next = new ListNode(0);
                listNode = listNode.next;
            }
        }

        return head;
    }

    private static void printListNode(ListNode listNode) {
        StringBuilder stringBuilder = new StringBuilder();
        while (listNode != null) {
            stringBuilder.append(listNode.val);
            listNode = listNode.next;
        }
        Printer.print(stringBuilder.toString());
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode result = new ListNode(0);

            ListNode head = result;
            int extra = 0;
            while (true) {
                if (l1 == null) {
                    result.val = l2.val + extra;
                    l2 = l2.next;
                } else if (l2 == null) {
                    result.val = l1.val + extra;
                    l1 = l1.next;
                } else {
                    result.val = l1.val + l2.val + extra;
                    l1 = l1.next;
                    l2 = l2.next;
                }

                if (result.val >= 10) {
                    extra = 1;
                    result.val -= 10;
                } else {
                    extra = 0;
                }

                if (l1 == null && l2 == null) {
                    if (extra > 0) {
                        result.next = new ListNode(extra);
                    }
                    break;
                }
                result.next = new ListNode(0);
                result = result.next;
            }
            return head;
        }

    }
}
