package club.justwrite.java.algorithm.leetcode.ptoday;

import club.justwrite.java.algorithm.leetcode.ListNode;
import club.justwrite.java.io.Printer;

/**
 * @author ACC
 * @desc
 * @create 2020/11/20
 **/
public class LeetCode0147 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode = solution.insertionSortList(ListNode.generateListNode(1, 2, 5, 3, 0));
        ListNode.printListNode(listNode);
    }

    private static class Solution {
        public ListNode insertionSortList(ListNode head) {
            if (head == null || head.next == null) return head;

            ListNode tagHeader = new ListNode(0, head);

            ListNode cur = tagHeader.next.next;
            ListNode prev = tagHeader.next;

            while (cur != null) {
                if (cur.val < prev.val) {
                    ListNode tmpPrev = tagHeader;
                    while (tmpPrev.next.val <= cur.val) {
                        tmpPrev = tmpPrev.next;
                    }
                    prev.next = cur.next;
                    cur.next = tmpPrev.next;
                    tmpPrev.next = cur;
                } else {
                    prev = prev.next;
                }

//                prev = cur; 原来的 这里会 把 prev 的指针移动到前面
                cur = prev.next;
            }

            return tagHeader.next;
        }

        public ListNode insertionSortList2(ListNode head) {
            if (head == null) {
                return head;
            }
            ListNode dummyHead = new ListNode(0);
            dummyHead.next = head;
            ListNode lastSorted = head, curr = head.next;
            while (curr != null) {
                if (lastSorted.val <= curr.val) {
                    lastSorted = lastSorted.next;
                } else {
                    ListNode prev = dummyHead;
                    while (prev.next.val <= curr.val) {
                        prev = prev.next;
                    }
                    lastSorted.next = curr.next;
                    curr.next = prev.next;
                    prev.next = curr;
                }
                curr = lastSorted.next;
            }
            return dummyHead.next;
        }

    }
}
