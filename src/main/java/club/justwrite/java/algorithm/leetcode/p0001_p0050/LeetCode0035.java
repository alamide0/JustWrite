package club.justwrite.java.algorithm.leetcode.p0001_p0050;

/**
 * @author ACC
 * @desc
 * @create 2020/11/17
 **/
public class LeetCode0035 {

    public static void main(String[] args) {

    }

    private static class Solution {
        public int searchInsert(int[] nums, int target) {

            int ans = -1;

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target || nums[i] > target) {
                    ans = i;
                    break;
                }
            }

            return ans == -1 ? nums.length : ans;
        }
    }
}