package club.justwrite.java.algorithm.leetcode.p0051_p0100;

import club.justwrite.java.base.io.Printer;

/**
 * @author ACC
 * @desc
 * @create 2020/10/30
 **/
public class LeetCode0053 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Printer.print(solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }


    private static class Solution {
        public int maxSubArray(int[] nums) {
            int best = 0;
            int max = Integer.MIN_VALUE;

            for (int n : nums) {
                if (best > 0) {
                    best += n;
                } else {
                    best = n;
                }
                max = Math.max(best, max);
            }

            return max;
        }
    }
}