package club.justwrite.java.algorithm.leetcode.ptempsimple;

import club.justwrite.java.io.Printer;

/**
 * @author ACC
 * @desc
 * @create 2020/11/9
 **/
public class LeetCode0198 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Printer.print(solution.rob(new int[]{1, 2, 3, 1}));
        Printer.print(solution.rob(new int[]{2, 7, 9, 3, 1}));
    }

    private static class Solution {
        public int rob(int[] nums) {
            if (nums.length == 0) return 0;

            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0], nums[1]);

            for (int i = 2; i < nums.length; i++) {
                dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
            }

            return dp[nums.length - 1];
        }
    }
}
