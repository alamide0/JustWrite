package club.justwrite.java.algorithm.leetcode.p0351_p0400;

import club.justwrite.java.base.io.Printer;

/**
 * @author ACC
 * @desc
 * @create 2020/11/23
 **/
public class LeetCode0371 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Printer.print(solution.getSum(3, 300));
    }

    private static class Solution {
        public int getSum(int a, int b) {

            int tm = a;
            a = a & b;
            b = tm ^ b;
            while (a != 0) {

                tm = b;
                b = b ^ (a << 1);
                a = tm & (a << 1);
            }

            return b;
        }
    }
}