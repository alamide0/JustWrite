package club.justwrite.java.algorithm.leetcode;

import club.justwrite.java.io.Printer;

/**
 * @author ACC
 * @desc
 * @create 2020/6/19
 **/
public class LeetCode0125 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Printer.print(solution.isPalindrome("A man, a plan, a canal: Panama"));
        Printer.print(solution.isPalindrome("race a car"));
        Printer.print(solution.isPalindrome("   12@"));
    }

    static class Solution {
        public boolean isPalindrome(String s) {

            int right = s.length() - 1;
            int left = 0;

            while (left < right) {
                char cl, cr;

                while (!isIllegalChar(cl = (char) (s.charAt(left) | 32)) && left < right) {
                    left++;
                }

                while (!isIllegalChar(cr = (char) (s.charAt(right) | 32)) && left < right) {
                    right--;
                }

                if (cl != cr) {
                    return false;
                }

                left++;
                right--;
            }

            return true;

        }

        private boolean isIllegalChar(char c) {
            return (c >= '0' && c <= '9') || (c >= 'a' && c <= 'z');
        }
    }
}
