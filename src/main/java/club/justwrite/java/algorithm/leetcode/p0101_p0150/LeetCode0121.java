package club.justwrite.java.algorithm.leetcode.p0101_p0150;

/**
 * @author ACC
 * @desc
 * @create 2020/11/8
 **/
public class LeetCode0121 {

    public static void main(String[] args) {

    }

    private static class Solution {
        public int maxProfit(int[] prices) {
            int min = Integer.MAX_VALUE;
            int res = 0;

            for (int n : prices) {
                if (n > min) {
                    res = Math.max(res, n - min);
                } else {
                    min = n;
                }
            }

            return res;
        }
    }
}