package club.justwrite.java.algorithm.leetcode.p0001_p0050;

import club.justwrite.java.io.Printer;

/**
 * @author ACC
 * @desc
 * @create 2020/6/23
 **/
public class LeetCode0021 {


    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = ListNode.listNode(1, 2, 4);
        ListNode l2 = ListNode.listNode(1, 3, 4);
//        printListNode(l1);
//        printListNode(l2);
        printListNode(solution.mergeTwoLists(l1,l2));

    }

    public static void printListNode(ListNode listNode) {
        while (listNode != null) {
            System.out.print(listNode.val + ", ");
            listNode = listNode.next;
        }
        System.out.println();
    }

    static class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null) return l2;
            if (l2 == null) return l1;
            ListNode res = new ListNode();

            ListNode header = res;
            while (true) {

                if (l1.val < l2.val) {
                    res.val = l1.val;
                    l1 = l1.next;
                } else {
                    res.val = l2.val;
                    l2 = l2.next;
                }

                if (l1 == null) {
                    res.next = l2;
                    break;
                }

                if (l2 == null) {
                    res.next = l1;
                    break;
                }

                res.next = new ListNode();
                res = res.next;
            }

            return header;
        }
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public static ListNode listNode(int... ints) {
            ListNode listNode = new ListNode();
            ListNode header = listNode;

            for (int i = 0; i < ints.length; i++) {
                listNode.val = ints[i];
                if (i != ints.length - 1) {
                    listNode.next = new ListNode();
                    listNode = listNode.next;
                }
            }

            return header;
        }

    }
}


