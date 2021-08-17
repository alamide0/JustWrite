package club.justwrite.java.algorithm.leetcode.p0151_p0200;

import club.justwrite.java.base.io.Printer;

/**
 * @author ACC
 * @desc
 * @create 2020/11/18
 **/
public class LeetCode0190 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Printer.print(solution.reverseBits(1));
        Printer.print(Integer.toBinaryString(964176192));
        Printer.print(Integer.toBinaryString(21630798));
        Printer.print(solution.reverseBits(-3));
    }

    private static class Solution {
        public int reverseBits(int n) {
            int r = 0;
            for (int i = 0; i < 32; i++) {
                r <<= 1;
                if ((n & 1) == 1) {
                    r++;
                }
                n >>= 1;
            }
            return r;
        }
    }
}