package club.justwrite.java.algorithm.leetcode.p1251_p1300;

import club.justwrite.java.algorithm.leetcode.ListNode;
import club.justwrite.java.base.io.Printer;

/**
 * @author ACC
 * @desc
 * @create 2020/11/3
 **/
public class LeetCode1290 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Printer.print(solution.getDecimalValue(ListNode.generateListNode(1, 0, 1)));
    }

    private static class Solution {
        public int getDecimalValue(ListNode head) {

            int sum = 0;
            while (head != null) {
                sum = sum * 2 + head.val;
                head = head.next;
            }

            return sum;
        }
    }
}