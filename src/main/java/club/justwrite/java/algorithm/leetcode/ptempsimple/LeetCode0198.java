package club.justwrite.java.algorithm.leetcode.ptempsimple;

import club.justwrite.java.base.io.Printer;

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
            if(nums.length == 0) return 0;
            int n1 = 0;
            int n2 = nums[0];
            int n3 = 0;

            for (int i = 1; i < nums.length; i++) {
                n3 = Math.max(n1 + nums[i], n2);
                n1 = n2;
                n2 = n3;
            }


            return n3;
        }
    }
}
