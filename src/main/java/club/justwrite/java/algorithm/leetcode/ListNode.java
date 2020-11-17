package club.justwrite.java.algorithm.leetcode;

import club.justwrite.java.io.Printer;

import java.nio.file.Paths;

/**
 * @author ACC
 * @desc
 * @create 2020/8/18
 **/
public class ListNode {
    public int val;
    public ListNode next;

    ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode generateListNode(int... ns) {

        ListNode head = new ListNode(ns[0]);
        ListNode tag = head;
        for (int i = 1; i < ns.length; i++) {
            head.next = new ListNode(ns[i]);
            head = head.next;
        }

        return tag;
    }

    public static void printListNode(ListNode head) {
        while (head != null) {
            System.out.print(head.val + ", ");
            head = head.next;
        }

        System.out.println();
    }
}
