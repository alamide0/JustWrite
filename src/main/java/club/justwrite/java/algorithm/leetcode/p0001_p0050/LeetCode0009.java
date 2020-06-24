package club.justwrite.java.algorithm.leetcode.p0001_p0050;

import club.justwrite.java.io.Printer;

/**
 * @author ACC
 * @desc
 * @create 2020/6/10
 **/
public class LeetCode0009 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        for (int i = 0; i < 102; i++) {
            Printer.print("i = " + i + " is palindrome " + solution.isPalindrome(i));
        }
    }

    static class Solution {
        public boolean isPalindrome(int x) {
            if (x == 0) return true;
            if (x < 0 || x % 10 == 0) return false;
            if (x < 10) return true;

            int re = 0;

            while (x > re) {
                re = re * 10 + x % 10;
                x /= 10;
            }

            return x == re || x == re / 10;
        }
    }
}
