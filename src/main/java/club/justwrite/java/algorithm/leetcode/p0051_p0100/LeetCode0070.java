package club.justwrite.java.algorithm.leetcode.p0051_p0100;

import club.justwrite.java.base.io.Printer;

/**
 * @author ACC
 * @desc
 * @create 2020/6/6 5:02 PM
 **/
public class LeetCode0070 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Printer.print(solution.climbStairs(2));
        for (int i = 3; i < 40; i++) {
            Printer.print(solution.climbStairs(i));
        }
    }

    static class Solution {
        public int climbStairs(int n) {
            if (n <= 2) {
                return n;
            }
            int i1 = 1;
            int i2 = 2;
            for (int i = 3; i <= n; i++) {
                int temp = i1 + i2;
                i1 = i2;
                i2 = temp;
            }
            return i2;
        }

    }
}