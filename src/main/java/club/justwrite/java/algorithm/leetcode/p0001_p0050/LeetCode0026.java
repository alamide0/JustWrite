package club.justwrite.java.algorithm.leetcode.p0001_p0050;

import club.justwrite.java.io.Printer;

/**
 * @author ACC
 * @desc
 * @create 2020/6/23
 **/
public class LeetCode0026 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Printer.print(solution.removeDuplicates(new int[]{1, 2, 2}));
        Printer.print(solution.removeDuplicates(new int[]{1, 1, 2, 2, 3, 3, 4, 4}));
    }

    static class Solution {
        public int removeDuplicates(int[] nums) {
            int i = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] != nums[i]) {
                    nums[++i] = nums[j];
                }
            }
            return i + 1;
        }
    }
}


