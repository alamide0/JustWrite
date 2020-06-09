package club.justwrite.java.algorithm.leetcode;

import club.justwrite.java.io.Printer;

import java.util.*;

/**
 * @author ACC
 * @desc
 * @create 2020/6/6 10:44 AM
 **/
public class LeetCode0015 {

    public static void main(String[] args) {
        Solution solution = new Solution();

        Printer.print(solution.threeSum(new int[]{1, -1, -1, 0}));
    }

    static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {

            Arrays.sort(nums);
            Map<Integer, Integer> map = new HashMap<>(nums.length);
            int count = 0;
            for (int n : nums) {
                map.put(n, count++);
            }
            List<List<Integer>> result = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) break;
                if (i > 0 && nums[i] == nums[i - 1]) continue;
                for (int j = i + 1; j < nums.length; j++) {
                    if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                    int temp = nums[i] + nums[j];
                    if (temp > 0) break;
                    if (temp + nums[nums.length - 1] < 0) continue;
                    if (map.get(-temp) != null && map.get(-temp) > j) {
                        result.add(Arrays.asList(nums[i], nums[j], -temp));
                    }
                }
            }

            return result;
        }
    }
}
