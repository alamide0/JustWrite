package club.justwrite.java.algorithm.leetcode.ptoday;

import club.justwrite.java.io.Printer;

/**
 * @author ACC
 * @desc
 * @create 2020/12/1
 **/
public class LeetCode0034 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Printer.print(solution.searchRange(new int[]{1, 2, 3, 4, 5, 6, 6, 7, 8, 9, 9}, 9));
    }

    private static class Solution {
        public int[] searchRange(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            int middle = 0;

            while (left <= right) {
                middle = (right - left + 1) / 2 + left;
                if (nums[middle] > target) {
                    right = middle - 1;
                } else if (nums[middle] < target) {
                    left = middle + 1;
                } else {
                    break;
                }
            }


            if (nums.length > 0 && nums[middle] == target) {
                int start = middle;
                int end = middle;

                while (start - 1 >= 0 && nums[start - 1] == target) start -= 1;
                while (end + 1 <= nums.length - 1 && nums[end + 1] == target) end += 1;

                return new int[]{start, end};
            } else {
                return new int[]{-1, -1};
            }
        }
    }
}
