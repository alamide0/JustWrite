package club.justwrite.java.algorithm.leetcode.ptempsimple;

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
    }

    static class Solution {
        public List<Integer> minSubsequence(int[] nums) {
            Arrays.sort(nums);

            List<Integer> res = new ArrayList<>();
            if (nums.length == 1) {
                res.add(nums[0]);
                return res;
            } else if (nums.length == 2) {
                if (nums[1] == nums[0]) {
                    res.add(nums[0]);
                    res.add(nums[1]);
                } else {
                    res.add(nums[1]);
                }
                return res;
            }

            int start = 0, end = nums.length - 1;
            int firstSum = nums[start], secondSum = nums[end];
            while (end - start > 1) {
                while (firstSum < secondSum) firstSum += nums[++start];
                while (firstSum >= secondSum) secondSum += nums[--end];
            }

            for (int i = nums.length - 1; i >= end; i--) {
                res.add(nums[i]);
            }

            return res;

        }
    }
}
