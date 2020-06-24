package club.justwrite.java.algorithm.leetcode.p0001_p0050;

import club.justwrite.java.io.Printer;

import java.util.Arrays;

/**
 * @author ACC
 * @desc
 * @create 2020/6/24
 **/
public class LeetCode0016 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Printer.print(solution.threeSumClosest(new int[]{0,1,2}, 3));
    }

    static class Solution {
        public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);

            int result = Integer.MAX_VALUE;
            int left, right;
            for (int i = 0; i < nums.length; i++) {
                left = i + 1;
                right = nums.length - 1;
                while (left < right) {
                    int t = nums[i] + nums[left] + nums[right] - target;
                    if (t == 0) {
                        return target;
                    } else if (t > 0) {
                        right--;
                    } else {
                        left++;
                    }

                    if (Math.abs(t) < Math.abs(result)) {
                        result = t;
                    }
                }
            }

            return result + target;
        }
    }
}


