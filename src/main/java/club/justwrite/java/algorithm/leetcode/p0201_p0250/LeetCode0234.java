package club.justwrite.java.algorithm.leetcode.p0201_p0250;

import club.justwrite.java.algorithm.leetcode.ListNode;

import club.justwrite.java.base.io.Printer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ACC
 * @desc
 * @create 2020/10/20
 **/
public class LeetCode0234 {

    public static void main(String[] args) {
        Solution2 solution = new Solution2();

        Printer.print(solution.isPalindrome(ListNode.generateListNode(1, 2, 3, 4, 5, 6, 7, 8, 9)));
        Printer.print(solution.isPalindrome(ListNode.generateListNode(1, 2)));
        Printer.print(solution.isPalindrome(ListNode.generateListNode(1, 2, 3, 4, 4, 3, 2, 1)));
        Printer.print(solution.isPalindrome(ListNode.generateListNode(1, 2, 3, 4, 5, 4, 3, 2, 1)));
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    static class Solution {
        public boolean isPalindrome(ListNode head) {
            if (head == null) return true;
            List<ListNode> listNodeList = new ArrayList<>();

            while (head != null) {
                listNodeList.add(head);
                head = head.next;
            }

            int i = 0, j = listNodeList.size() - 1;

            while (i < j) {
                if (listNodeList.get(i++).val != listNodeList.get(j--).val) return false;
            }

            return true;
        }
    }

    /**
     * 快慢指针解法
     */
    static class Solution2 {
        public boolean isPalindrome(ListNode head) {

            if (head == null) return true;

            ListNode fistHead = head;
            ListNode secondHead = reverse(middle(head).next);

            while (secondHead != null) {
                if (fistHead.val != secondHead.val) return false;
                fistHead = fistHead.next;
                secondHead = secondHead.next;
            }

            return true;
        }

        public ListNode reverse(ListNode head) {
            ListNode curr = head;
            ListNode prev = null;
            while (curr != null) {
                ListNode nextTmp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextTmp;
            }

            return prev;
        }

        public ListNode middle(ListNode head) {
            ListNode fast = head;
            ListNode slow = head;

            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            return slow;
        }
    }
}