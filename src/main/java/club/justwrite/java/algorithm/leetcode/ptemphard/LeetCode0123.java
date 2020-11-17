package club.justwrite.java.algorithm.leetcode.ptemphard;

/**
 * @author ACC
 * @desc
 * @create 2020/11/8
 **/
public class LeetCode0123 {


    public static void main(String[] args) {

    }

    private static class Solution {
        public int maxProfit(int[] prices) {
            int dp1 = 0;
            int dp2 = -prices[0];
            int dp3 = 0;
            int dp4 = -prices[0];
            int dp5 = 0;

            for (int i = 1; i < prices.length; i++) {
                dp2 = Math.max(dp2, dp1 - prices[i]);

                dp3 = Math.max(dp3, prices[i] + dp2);

                dp4 = Math.max(dp4, dp3 - prices[i]);

                dp5 = Math.max(dp5, dp4 + prices[i]);
            }


            return Math.max(Math.max(dp1, Math.max(dp2, dp3)), Math.max(dp4, dp5));
        }
    }
}
