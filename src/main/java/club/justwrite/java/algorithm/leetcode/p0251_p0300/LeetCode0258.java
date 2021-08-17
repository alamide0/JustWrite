package club.justwrite.java.algorithm.leetcode.p0251_p0300;

import club.justwrite.java.base.io.Printer;

/**
 * @author ACC
 * @desc
 * @create 2020/11/23
 **/
public class LeetCode0258 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Printer.print(solution.addDigits(-38));
    }


    private static class Solution {
        public int addDigits(int num) {
            if (Math.abs(num) < 10) return num;

            int ans = 0;

            while (num != 0) {
                ans += num % 10;
                num = num / 10;
            }

            return addDigits(ans);
        }
    }
}