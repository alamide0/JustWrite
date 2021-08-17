package club.justwrite.java.algorithm.leetcode.p0701_p0750;

import club.justwrite.java.base.io.Printer;

/**
 * @author ACC
 * @desc
 * @create 2020/11/9
 **/
public class LeetCode0746 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Printer.print(solution.minCostClimbingStairs(new int[]{10, 15, 20}));
        Printer.print(solution.minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1, 100, 1, 1, 1, 100, 100}));
    }

    private static class Solution {
        public int minCostClimbingStairs(int[] cost) {
            if (cost.length == 0) return 0;
            if (cost.length == 1) return cost[0];

            int[] dp = new int[cost.length];

            dp[0] = cost[0];
            dp[1] = cost[1];

            for (int i = 2; i < cost.length; i++) {
                dp[i] = Math.min(dp[i - 2] + cost[i], dp[i - 1] + cost[i]);
            }



            return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
        }


    }
}