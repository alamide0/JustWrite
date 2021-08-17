package club.justwrite.java.algorithm.leetcode.p0001_p0050;

import club.justwrite.java.base.io.Printer;

/**
 * @author ACC
 * @desc
 * @create 2020/11/10
 **/
public class LeetCode0031 {

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = {1, 3, 2};
        solution.nextPermutation(nums);
        Printer.print(nums);
    }

    private static class Solution {
        public void nextPermutation(int[] nums) {

            if (nums.length <= 1) return;
            int i = nums.length - 2;

            Printer.print(i);
            while (i >= 0 && nums[i] >= nums[i + 1]) i--;

            Printer.print(i);

            if (i >= 0) {
                int j = nums.length - 1;
                while (nums[j] <= nums[i]) j--;

                Printer.print(j);
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;

                Printer.print(nums);

            }

            reverse(nums, i + 1, nums.length - 1);


        }


        private void reverse(int[] nums, int start, int end) {
            for (int i = start; i <= (start + end) / 2; i++) {
                int tmp = nums[i];
                nums[i] = nums[end - (i - start)];
                nums[end - (i - start)] = tmp;
            }
        }
    }
}