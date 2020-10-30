package club.justwrite.java.algorithm.leetcode.p1351_p1400;

import club.justwrite.java.io.Printer;

import java.util.Arrays;

/**
 * @author ACC
 * @desc
 * @create 2020/10/26
 **/
public class LeetCode1365 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Printer.print(solution.smallerNumbersThanCurrent(new int[]{8, 1, 2, 2, 3, 5,43,2,2,2,3,5,23,2,1,3,4,2,1,23,1,2,1,1,1,1}));
        Printer.print(solution.smallerNumbersThanCurrent(new int[]{6, 5, 4, 8}));
        Printer.print(solution.smallerNumbersThanCurrent(new int[]{7, 7, 7, 7}));
    }

    static class Solution {
        public int[] smallerNumbersThanCurrent(int[] nums) {
            int[] res = new int[nums.length];

            for (int i = 0; i < nums.length; i++) {
                int start = 0;
                int same = 0;
                if (res[i] > 0) {
                    start = i + 1;
                }
                for (int j = start; j < nums.length; j++) {
                    if (i == j) continue;
                    if (nums[j] < nums[i]) {
                        res[i]++;
                    } else if (nums[j] > nums[i]) {
                        res[j] = Math.max(res[j], res[i] + 1 + same);
                    } else {
                        res[j] = Math.max(res[j], res[i]);
                        same++;
                    }
                }
            }

            return res;

        }
    }
}