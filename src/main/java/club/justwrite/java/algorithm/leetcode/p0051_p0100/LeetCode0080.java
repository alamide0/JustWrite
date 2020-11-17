package club.justwrite.java.algorithm.leetcode.p0051_p0100;

import club.justwrite.java.io.Printer;

/**
 * @author ACC
 * @desc
 * @create 2020/10/30
 **/
public class LeetCode0080 {

    public static void main(String[] args) {
        Printer.print(Integer.MIN_VALUE - 1);
        Solution solution = new Solution();
        Printer.print(solution.removeDuplicates(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3}));
        Printer.print(solution.removeDuplicates(new int[]{1, 1, 1, 2, 2, 3}));
    }

    private static class Solution {
        public int removeDuplicates(int[] nums) {

            int index = 0;
            int pNum = nums[0];
            int count = 0;

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == pNum) {
                    count++;
                } else {
                    pNum = nums[i];
                    count = 1;
                }

                if (count <= 2) {
                    nums[index++] = nums[i];
                }
            }

            return index;
        }
    }
}