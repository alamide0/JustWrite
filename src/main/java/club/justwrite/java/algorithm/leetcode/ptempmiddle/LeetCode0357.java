package club.justwrite.java.algorithm.leetcode.ptempmiddle;

import club.justwrite.java.base.io.Printer;

/**
 * @author ACC
 * @desc
 * @create 2020/11/2
 **/
public class LeetCode0357 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Printer.print(solution.countNumbersWithUniqueDigits(2));
    }

    private static class Solution {
        public int countNumbersWithUniqueDigits(int n) {
            int maxLength = String.valueOf((int) Math.pow(10, n)).length();
            int res = 1;

            for (int i = 1; i < maxLength; i++) {
                res += backtrace(i, new int[10], 1);
            }

            return res;
        }

        private int backtrace(int length, int[] numbers, int startIndex) {
            if (length == 0) {
                return 1;
            }

            int res = 0;
            for (int i = startIndex; i <= 9; i++) {
                if (numbers[i] == 1) continue;
                numbers[i] = 1;
                res += backtrace(length - 1, numbers, 0);
                numbers[i] = 0;
            }

            return res;
        }
    }
}
