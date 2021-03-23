package club.justwrite.java.algorithm.leetcode.p0301_p0350;

import club.justwrite.java.io.Printer;

/**
 * @author ACC
 * @desc
 * @create 2020/11/26
 **/
public class LeetCode0342 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Printer.print(solution.isPowerOfFour(16));
    }

    private static class Solution {
        public boolean isPowerOfFour(int num) {
            return (num > 0) && ((num & (num - 1)) == 0) && ((num & 0xaaaaaaaa) == 0);
        }
    }
}