package club.justwrite.java.algorithm.leetcode.p0151_p0200;

import club.justwrite.java.base.io.Printer;

/**
 * @author ACC
 * @desc
 * @create 2020/11/19
 **/
public class LeetCode0171 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Printer.print(solution.titleToNumber("ZY"));
    }

    private static class Solution {
        public int titleToNumber(String s) {
            char[] chars = s.toCharArray();
            int ans = 0;


            for (int i = 0; i < chars.length; i++) {
                ans = ans * ('Z' - 'A' + 1) + (chars[i] - 'A' + 1);
            }

            return ans;
        }
    }
}