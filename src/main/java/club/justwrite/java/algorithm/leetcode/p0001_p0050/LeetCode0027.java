package club.justwrite.java.algorithm.leetcode.p0001_p0050;

import club.justwrite.java.base.io.Printer;

/**
 * @author ACC
 * @desc
 * @create 2020/10/26
 **/
public class LeetCode0027 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Printer.print(solution.removeElement(new int[]{1}, 1));
        Printer.print(solution.removeElement(new int[]{3, 2, 2, 3}, 3));
    }

    static class Solution {
        public int removeElement(int[] nums, int val) {

            int length = nums.length;
            int start = 0, end = nums.length - 1;

            while (start <= end) {
                if (nums[start] == val) {
                    nums[start] = nums[end];
                    end--;
                    length--;
                } else {
                    start++;
                }
            }

            return length;
        }

        public int removeElement2(int[] nums, int val) {
            int length = 0;
            int i = 0;

            for (int j = 0; j < nums.length; j++) {
                if (nums[j] != val) {
                    nums[i++] = nums[j];
                    length++;
                }
            }
            Printer.print(nums);

            return length;
        }
    }
}