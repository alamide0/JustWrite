package club.justwrite.java.algorithm.leetcode.p0301_p0350;

import club.justwrite.java.base.io.Printer;

/**
 * @author ACC
 * @desc
 * @create 2020/10/26
 **/
public class LeetCode0344 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.reverseString("hello".toCharArray());
        solution.reverseString("Hannah".toCharArray());
    }

    static class Solution {
        public void reverseString(char[] s) {

            int start = 0;
            int end = s.length - 1;

            while (start < end) {
                char temp = s[start];
                s[start++] = s[end];
                s[end--] = temp;
            }

            Printer.print(s);
        }
    }
}