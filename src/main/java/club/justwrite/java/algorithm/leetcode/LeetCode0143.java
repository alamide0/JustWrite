package club.justwrite.java.algorithm.leetcode;

import club.justwrite.java.io.Printer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ACC
 * @desc
 * @create 2020/10/20
 **/
public class LeetCode0143 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = null;
        ListNode.printListNode(head);
        solution.reorderList(head);
        ListNode.printListNode(head);

        head = ListNode.generateListNode(1, 2, 3, 4, 5, 6, 7, 8, 9);
        ListNode.printListNode(head);
        solution.reorderList(head);
        ListNode.printListNode(head);
    }

    /**
     * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
     * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    static class Solution {
        public void reorderList(ListNode head) {
            List<ListNode> array = listArray(head);

            int i = 0, j = array.size() - 1;
            for (; i < j; ) {
                array.get(j).next = array.get(i).next;
                i++;
                if (i == j) {
                    break;
                }
                array.get(i).next = array.get(j);
                j--;
            }

            array.get(i).next = null;
        }

        private List<ListNode> listArray(ListNode head) {
            List<ListNode> list = new ArrayList<>();

            ListNode node = head;

            while (node != null) {
                list.add(node);
                node = node.next;
            }

            return list;
        }
    }
}
