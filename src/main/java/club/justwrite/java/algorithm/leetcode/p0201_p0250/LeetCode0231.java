package club.justwrite.java.algorithm.leetcode.p0201_p0250;

import club.justwrite.java.base.io.Printer;

/**
 * @author ACC
 * @desc
 * @create 2020/10/30
 **/
public class LeetCode0231 {

    public static void main(String[] args) {
        Printer.print(Integer.toBinaryString(-1));
        Solution solution = new Solution();
        Printer.print(solution.isPowerOfTwo(0));
        Printer.print(solution.isPowerOfTwo(1));
        Printer.print(solution.isPowerOfTwo(2));
        Printer.print(solution.isPowerOfTwo(16));
        Printer.print(solution.isPowerOfTwo(218));
        Printer.print(solution.isPowerOfTwo(512));
        Printer.print(solution.isPowerOfTwo(513));
    }

    private static class Solution {
        public boolean isPowerOfTwo(int n) {
            if (n <= 0) return false;
            int count = 0;
            while (n != 0) {
                if ((n & 1) == 1) count++;
                n = n >>> 1;
            }
            return count == 1 || count == 0;
        }
    }
}