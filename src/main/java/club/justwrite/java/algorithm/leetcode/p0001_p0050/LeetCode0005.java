package club.justwrite.java.algorithm.leetcode.p0001_p0050;

import club.justwrite.java.algorithm.leetcode.test.MainMethod;
import club.justwrite.java.algorithm.leetcode.test.Tester;
import club.justwrite.java.io.Printer;

/**
 * @author ACC
 * @desc
 * @create 2020/6/22
 **/
public class LeetCode0005 {

    public static void main(String[] args) {
        Solution solution = new Solution();

        Object[] params = new Object[]{
                "aabbaaa", "aabbaa",
                "cbbdd", "bb",
                "babad", "bab",
                "aaa", "aaa",
                "aaaa", "aaaa"
        };

        Tester.test(params, solution);
    }

    static class Solution {

        @MainMethod
        public String longestPalindrome(String s) {
            if (s.length() == 0) return s;

            DataHolder dataHolder = new DataHolder();
            for (int i = 0; i < s.length() - 1; i++) {
                if ((i > 0 && s.charAt(i - 1) == s.charAt(i + 1))) {
                    walk(dataHolder, s, i - 1, i + 1);
                }

                if (s.charAt(i) == s.charAt(i + 1)) {
                    walk(dataHolder, s, i, i + 1);
                }
            }

            return s.substring(dataHolder.start, dataHolder.end + 1);
        }

        private void walk(DataHolder holder, String s, int left, int right) {

            int t = right - left == 1 ? (holder.maxLength - 2) / 2 : (holder.maxLength - 3) / 2;

            if (t >= 0 && (left - t < 0 || right + t > s.length() - 1 || s.charAt(left - t) != s.charAt(right + t))) {
                return;
            }

            while (left >= 0 && right < s.length()) {
                if (s.charAt(left) != s.charAt(right)) {
                    break;
                }
                if (holder.maxLength < right - left + 1) {
                    holder.maxLength = right - left + 1;
                    holder.end = right;
                    holder.start = left;
                }
                left--;
                right++;
            }
        }

        private class DataHolder {
            int start;
            int end;
            int maxLength;
        }

    }
}
