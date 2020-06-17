package club.justwrite.java.algorithm.leetcode;

import club.justwrite.java.io.Printer;

import java.util.Arrays;

/**
 * @author ACC
 * @desc
 * @create 2020/6/16
 **/
public class LeetCode0473 {

    public static void main(String[] args) {
        Solution solution = new Solution();

        Printer.print(solution.makesquare(new int[]{1,1,2,2,2}));
    }


    static class Solution {

        private int w;
        private int[] sum = new int[4];
        private int[] nums;

        private boolean dfs(int index) {

            if (index == -1) {
                return (sum[0] == w && sum[1] == w && sum[2] == w && sum[3] == w);
            }


            for (int i = 0; i < 4; i++) {
                if (sum[i] + nums[index] <= w) {
                    sum[i] += nums[index];
                    if (dfs(index - 1)) {
                        return true;
                    }
                    sum[i] -= nums[index];
                }
            }
            return false;
        }

        public boolean makesquare(int[] nums) {

            if (nums.length < 4) return false;
            int sum = 0;

            for (int n : nums) {
                sum += n;
            }

            w = sum / 4;
            if (w * 4 != sum) return false;
            Arrays.sort(nums);

            if (nums[nums.length - 1] > w) return false;

            this.nums = nums;

            return dfs(nums.length - 1);
        }
    }
}

