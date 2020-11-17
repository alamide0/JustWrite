package club.justwrite.java.algorithm.leetcode.p1401_p1450;

import club.justwrite.java.io.Printer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ACC
 * @desc
 * @create 2020/10/28
 **/
public class LeetCode1403 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Printer.print(solution.minSubsequence(new int[]{4, 3, 10, 9, 8}));
        Printer.print(solution.minSubsequence(new int[]{4, 4, 7, 6, 7}));
        Printer.print(solution.minSubsequence(new int[]{6}));
        Printer.print(solution.minSubsequence(new int[]{10, 2, 5}));
    }

    static class Solution {
        public List<Integer> minSubsequence(int[] nums) {
            Arrays.sort(nums);

            List<Integer> res = new ArrayList<>();

            int sum = 0;
            for (int n : nums) {
                sum += n;
            }

            int endSum = 0;
            for (int i = nums.length - 1; i >= 0; i--) {
                endSum += nums[i];
                res.add(nums[i]);
                if (endSum > sum - endSum) {
                    break;
                }
            }

            return res;

        }
    }
}