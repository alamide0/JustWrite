package club.justwrite.java.algorithm.leetcode.p0101_p0150;

import club.justwrite.java.base.io.Printer;

/**
 * @author ACC
 * @desc
 * @create 2020/11/17
 **/
public class LeetCode0136 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Printer.print(solution.singleNumber(new int[]{1, 2, 1, 2, 4,4,7}));
    }

    private static class Solution {
        public int singleNumber(int[] nums) {
            int res = 0;

            for (int n : nums) {
                res = res ^ n;
            }

            return res;
        }
    }
}