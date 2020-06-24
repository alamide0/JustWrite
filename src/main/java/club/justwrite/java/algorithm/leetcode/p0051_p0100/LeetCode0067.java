package club.justwrite.java.algorithm.leetcode.p0051_p0100;

import club.justwrite.java.io.Printer;

/**
 * @author ACC
 * @desc
 * @create 2020/6/23
 **/
public class LeetCode0067 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Printer.print(s.addBinary("1", "1"));
        Printer.print(s.addBinary("1010", "1011"));
        Printer.print(s.addBinary("11111", "11111"));
    }

    static class Solution {
        public String addBinary(String a, String b) {

            int[] nums = new int[Math.max(a.length(), b.length()) + 1];
            int index = -1;

            int extra = 0;
            for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; ) {
                index++;
                if (i == -1) {
                    nums[index] = b.charAt(j) + extra - '0';
                    j--;
                } else if (j == -1) {
                    nums[index] = a.charAt(i) + extra - '0';
                    i--;
                } else {
                    nums[index] = a.charAt(i) + b.charAt(j) + extra - '0' - '0';
                    i--;
                    j--;
                }

                if (nums[index] > 1) {
                    nums[index] -= 2;
                    extra = 1;
                } else {
                    extra = 0;
                }
            }

            if (extra != 0) {
                nums[++index] = 1;
            }

            StringBuilder stringBuilder = new StringBuilder();
            for (int i = index; i >= 0; i--) {
                stringBuilder.append(nums[i]);
            }

            return stringBuilder.toString();
        }
    }
}