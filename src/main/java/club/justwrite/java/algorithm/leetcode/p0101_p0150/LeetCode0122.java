package club.justwrite.java.algorithm.leetcode.p0101_p0150;

import club.justwrite.java.base.io.Printer;

/**
 * @author ACC
 * @desc
 * @create 2020/11/8
 **/
public class LeetCode0122 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Printer.print(solution.maxProfit3(new int[]{7, 1, 5, 3, 6, 4}));
        Printer.print(solution.maxProfit3(new int[]{7, 6, 4, 3, 1}));
    }

    private static class Solution {
        public int maxProfit(int[] prices) {
            int price = Integer.MAX_VALUE;
            int res = 0;
            int dx = 0;

            for (int n : prices) {
                if (n < price) {
                    res += dx;
                    dx = 0;
                } else {
                    dx += n - price;
                }
                price = n;
            }

            return res + dx;
        }

        public int maxProfit2(int[] prices) {
            int res = 0;

            for (int i = 1; i < prices.length; i++) {
                res += Math.max(0, prices[i] - prices[i - 1]);
            }

            return res;
        }

        public int maxProfit3(int[] prices) {
            int[][] dp = new int[prices.length][2];
            dp[0][0] = 0;
            dp[0][1] = -prices[0];

            for (int i = 1; i < prices.length; i++) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);
            }

            return dp[prices.length - 1][0];
        }
    }
}