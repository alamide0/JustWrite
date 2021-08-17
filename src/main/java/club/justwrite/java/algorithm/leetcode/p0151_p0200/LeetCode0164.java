package club.justwrite.java.algorithm.leetcode.p0151_p0200;


import club.justwrite.java.base.io.Printer;

import java.util.Arrays;

/**
 * @author ACC
 * @desc 基数排序，
 * @create 2020/11/26
 **/
public class LeetCode0164 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Printer.print(solution.maximumGap2(new int[]{1, 100}));
    }

    private static class Solution {

        /**
         * 基数排序解法
         *
         * @param nums
         * @return
         */
        public int maximumGap(int[] nums) {

            if (nums.length < 2) return 0;
            int[] buffer = new int[nums.length];

            int max = Integer.MIN_VALUE;
            for (int n : nums) {
                max = Math.max(max, n);
            }

            int divided = 1;

            while (divided <= max) {
                int[] ns = new int[10];

                for (int n : nums) {
                    int mod = (n / divided) % 10;
                    ns[mod]++;
                }

                for (int i = 1; i < 10; i++) {
                    ns[i] += ns[i - 1];
                }

                for (int i = nums.length - 1; i >= 0; i--) {
                    int mod = (nums[i] / divided) % 10;
                    buffer[ns[mod] - 1] = nums[i];
                    ns[mod]--;
                }

                System.arraycopy(buffer, 0, nums, 0, buffer.length);

                divided *= 10;
            }


            max = 0;
            for (int i = 1; i < nums.length; i++) {
                max = Math.max(nums[i] - nums[i - 1], max);
            }

            return max;
        }

        /**
         * 桶排序解法
         *
         * @param nums
         * @return
         */
        public int maximumGap2(int[] nums) {
            if (nums.length < 2) return 0;
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;

            for (int n : nums) {
                max = Math.max(max, n);
                min = Math.min(min, n);
            }

            if (max == min) return 0;
            int bucketSize = Math.max(1, (max - min) / (nums.length - 1));
            int bucketNum = (max - min) / bucketSize + 1;


            int[][] bucket = new int[bucketNum][2];

            for (int[] ns : bucket) {
                Arrays.fill(ns, -1);
            }

            for (int n : nums) {
                int index = (n - min) / bucketSize;
                bucket[index][0] = bucket[index][0] == -1 ? n : Math.min(bucket[index][0], n);
                bucket[index][1] = bucket[index][0] == -1 ? n : Math.max(bucket[index][1], n);
            }

            max = 0;
            int lastMax = -1;
            for (int[] aBucket : bucket) {
                if (aBucket[0] == -1) {
                    continue;
                }

                if (lastMax == -1) {
                    lastMax = aBucket[1];
                }

                if (lastMax != -1) {
                    max = Math.max(max, aBucket[0] - lastMax);
                    lastMax = aBucket[1];
                }

            }

            return max;
        }
    }
}