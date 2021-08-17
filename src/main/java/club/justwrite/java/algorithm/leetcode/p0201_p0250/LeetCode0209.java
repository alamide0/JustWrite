package club.justwrite.java.algorithm.leetcode.p0201_p0250;

import club.justwrite.java.base.io.Printer;

/**
 * @author ACC
 * @desc 2 3 1 2 4 3
 * 7
 * 4 3
 * @create 2020/6/28
 **/
public class LeetCode0209 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Printer.print(solution.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));

        Solution2 solution2 = new Solution2();
        Printer.print(solution2.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }

    static class Solution {
        public int minSubArrayLen(int s, int[] nums) {
            int res = Integer.MAX_VALUE;
            int sum = 0;
            int left = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];

                while (sum >= s) {
                    int t = i - left + 1;
                    if (t < res) {
                        res = i - left + 1;
                    }
                    sum -= nums[left];
                    left++;
                }
            }

            return res == Integer.MAX_VALUE ? 0 : res;
        }
    }

    static class Solution2 {
        public int minSubArrayLen(int s, int[] nums) {
            int res = Integer.MAX_VALUE;
            int sum;

            for (int i = 0; i < nums.length; i++) {
                sum = 0;
                for (int j = i; j < nums.length; j++) {
                    sum += nums[j];
                    if (sum >= s) {
                        res = Math.min(res, j - i + 1);
                        break;
                    }
                }
            }

            return res == Integer.MAX_VALUE ? 0 : res;
        }
    }
}


