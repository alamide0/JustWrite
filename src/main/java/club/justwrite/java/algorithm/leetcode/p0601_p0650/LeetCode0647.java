package club.justwrite.java.algorithm.leetcode.p0601_p0650;

import club.justwrite.java.base.io.Printer;

/**
 * @author ACC
 * @desc
 * @create 2020/8/19
 **/
public class LeetCode0647 {

    public static void main(String[] args) {
        Solution solution = new Solution();
//        Printer.print(solution.countSubstrings("abc"));
//        Printer.print(solution.countSubstrings("aaa"));
        Printer.print(solution.countSubstrings("abasdsafdsa"));
    }

    static class Solution {
        public int countSubstrings(String s) {

            int res = 0;
            char[] chars = s.toCharArray();
            for (int i = 0; i < s.length(); i++) {
                res += R(chars, i, i);
                res += R(chars, i, i + 1);
            }

            return res;
        }

        private int R(char[] chars, int start, int end) {
            int res = 0;

            while (start >= 0 && end < chars.length && chars[start--] == chars[end++]) {
                res++;
            }

            return res;
        }

    }
}