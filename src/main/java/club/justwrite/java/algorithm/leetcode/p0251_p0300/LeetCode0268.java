package club.justwrite.java.algorithm.leetcode.p0251_p0300;

import club.justwrite.java.base.io.Printer;

/**
 * @author ACC
 * @desc
 * @create 2020/10/29
 **/
public class LeetCode0268 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Printer.print(solution.missingNumber(new int[]{0, 1}));
        Printer.print(solution.missingNumber(new int[]{3, 0, 1}));
        Printer.print(solution.missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
        Printer.print(solution.missingNumber(new int[]{0}));
    }

    private static class Solution {
        public int missingNumber(int[] nums) {
            int n = nums.length;

            int sum1 = 0;
            int sum2 = 0;
            for (int i = 0; i < n; i++) {
                sum1 += nums[i];
                sum2 += i;
            }

            return sum2 + n - sum1;
        }
    }
}