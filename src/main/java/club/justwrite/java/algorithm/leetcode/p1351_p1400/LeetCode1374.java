package club.justwrite.java.algorithm.leetcode.p1351_p1400;

import club.justwrite.java.base.io.Printer;

/**
 * @author ACC
 * @desc
 * @create 2020/11/10
 **/
public class LeetCode1374 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Printer.print(solution.generateTheString(0));
    }

    private static class Solution {
        public String generateTheString(int n) {
            if (n <= 0) return "";
            int first = n % 2 == 0 ? n - 1 : n;
            int second = n - first;

            StringBuilder stringBuilder = new StringBuilder();

            for (int i = 0; i < first; i++) {
                stringBuilder.append('a');
            }

            for (int i = 0; i < second; i++) {
                stringBuilder.append('b');
            }


            return stringBuilder.toString();
        }
    }
}