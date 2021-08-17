package club.justwrite.java.algorithm.leetcode.p0601_p0650;

import club.justwrite.java.base.io.Printer;

/**
 * @author ACC
 * @desc
 * @create 2020/11/25
 **/
public class LeetCode0633 {

    public static void main(String[] args) {
        Solution solution = new Solution();
//        Printer.print(solution.judgeSquareSum(5));
//        Printer.print(solution.judgeSquareSum(55));
//        Printer.print(solution.judgeSquareSum(100));
        Printer.print(solution.judgeSquareSum(1000));
    }

    private static class Solution {
        public boolean judgeSquareSum(int c) {
            int n = (int) Math.sqrt(c);

            for (int i = n; i >= n / 2; i--) {

                int a = (int) Math.sqrt(c - i * i);


                if (a * a == c - i * i) {
                    return true;
                }
            }

            return false;
        }
    }
}