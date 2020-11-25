package club.justwrite.java.algorithm.leetcode.p0251_p0300;

import club.justwrite.java.io.Printer;

/**
 * @author ACC
 * @desc
 * @create 2020/11/24
 **/
public class LeetCode0263 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Printer.print(s.isUgly(8));
        Printer.print(s.isUgly(1));
        Printer.print(s.isUgly(6));
        Printer.print(s.isUgly(14));
    }

    private static class Solution {
        public boolean isUgly(int num) {

            if (num == 0 || Math.abs(num) == 1) return false;
            while (num != 1) {
                if (num % 2 == 0) {
                    num = num / 2;
                } else if (num % 3 == 0) {
                    num = num / 3;
                } else if (num % 5 == 0) {
                    num = num / 5;
                } else {
                    return false;
                }
            }

            return true;
        }
    }
}