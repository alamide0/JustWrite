package club.justwrite.java.algorithm.leetcode.p0351_p0400;

import club.justwrite.java.io.Printer;

/**
 * @author ACC
 * @desc
 * @create 2020/11/9
 **/
public class LeetCode0392 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Printer.print(solution.isSubsequence("abc", "ahbgdc"));
        Printer.print(solution.isSubsequence("axc", "ahbgdc"));
        Printer.print(solution.isSubsequence("bb", "ahbgdc"));
    }

    private static class Solution {
        public boolean isSubsequence(String s, String t) {

            if (s.length() == t.length()) return s.equals(t);
            if (s.length() > t.length()) return false;

            int indexS = 0;
            int indexT = 0;


            while (indexS < s.length() && indexT < t.length()) {
                while (indexT < t.length() && t.charAt(indexT) != s.charAt(indexS)) indexT++;
                if (indexT == t.length()) {
                    break;
                }
                indexS++;
                indexT++;
            }

            return indexS == s.length();
        }


    }
}