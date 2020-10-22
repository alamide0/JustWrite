package club.justwrite.java.algorithm.leetcode.p1501_p1550;

import club.justwrite.java.algorithm.leetcode.ListNode;
import club.justwrite.java.algorithm.leetcode.TreeNode;

import club.justwrite.java.io.Printer;

/**
 * @author ACC
 * @desc
 * @create 2020/10/22
 **/
public class LeetCode1518 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Printer.print(solution.numWaterBottles(9, 3));
        Printer.print(solution.numWaterBottles(15, 4));
        Printer.print(solution.numWaterBottles(5, 5));
        Printer.print(solution.numWaterBottles(2, 3));
    }

    static class Solution {
        public int numWaterBottles(int numBottles, int numExchange) {
            int emptyBottles = numBottles;
            int res = numBottles;

            while (emptyBottles >= numExchange) {
                int exchange = emptyBottles / numExchange;
                emptyBottles = emptyBottles % numExchange + exchange;
                res += exchange;
            }

            return res;
        }
    }
}