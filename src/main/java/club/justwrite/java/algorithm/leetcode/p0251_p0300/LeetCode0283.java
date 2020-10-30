package club.justwrite.java.algorithm.leetcode.p0251_p0300;

import club.justwrite.java.io.Printer;

/**
 * @author ACC
 * @desc
 * @create 2020/10/26
 **/
public class LeetCode0283 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.moveZeroes(new int[]{1, 2, 3, 4, 0, 4, 5, 0, 4, 0, 56});
        solution.moveZeroes(new int[]{0, 0, 0, 12, 3});
    }

    static class Solution {
        public void moveZeroes(int[] nums) {
            int length = nums.length;
            int i = 0;

            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == 0) {
                    length--;
                } else {
                    nums[i++] = nums[j];
                }
            }

            for (int j = length; j < nums.length; j++) {
                nums[j] = 0;
            }

//            Printer.print(nums);
        }
    }
}