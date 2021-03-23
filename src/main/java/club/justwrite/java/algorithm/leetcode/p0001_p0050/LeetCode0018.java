package club.justwrite.java.algorithm.leetcode.p0001_p0050;

import club.justwrite.java.io.Printer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ACC
 * @desc
 * @create 2020/11/27
 **/
public class LeetCode0018 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Printer.print(solution.fourSum(new int[]{-2, -1, -1, 1, 1, 2, 2}, 0));

        Printer.print(solution.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
    }

    private static class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {

            List<List<Integer>> ans = new ArrayList<>();

            if (nums.length < 4) return ans;
            Arrays.sort(nums);

            for (int i = 0; i < nums.length - 3; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) continue;
                if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) break;

                if (nums[i] + nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3] < target) continue;
                for (int j = i + 1; j < nums.length - 2; j++) {
                    if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                    if (nums[j + 1] + nums[j + 2] + nums[i] + nums[j] > target) break;
                    if (nums[nums.length - 1] + nums[nums.length - 2] + nums[i] + nums[j] < target) continue;

                    int left = j + 1, right = nums.length - 1;

                    while (left < right) {
                        while (left < right && nums[left] + nums[right] + nums[i] + nums[j] < target) left++;
                        while (left < right && nums[left] + nums[right] + nums[i] + nums[j] > target) right--;

                        if (left < right && nums[left] + nums[right] + nums[i] + nums[j] == target) {
                            ans.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                            while (left < right && nums[left] == nums[left + 1]) left++;
                            while (left < right && nums[right] == nums[right - 1]) right--;
                            left++;
                            right--;
                        }
                    }

                }
            }


            return ans;
        }
    }
}