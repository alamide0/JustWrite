package club.justwrite.java.algorithm.leetcode.p1401_p1450;

import club.justwrite.java.io.Printer;

/**
 * @author ACC
 * @desc
 * @create 2020/11/25
 **/
public class LeetCode1413 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Printer.print(solution.minStartValue(new int[]{-3, 2, -3, 4, 2}));
        Printer.print(solution.minStartValue(new int[]{1, 2}));
        Printer.print(solution.minStartValue(new int[]{1, -2, -3}));
    }

    private static class Solution {
        public int minStartValue(int[] nums) {
            int preSum = 0;

            int min = Integer.MAX_VALUE;

            for (int n : nums) {
                preSum += n;
                min = Math.min(preSum, min);
            }

            return min >= 0 ? 1 : -min + 1;
        }
    }
}