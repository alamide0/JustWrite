package club.justwrite.java.algorithm.leetcode.p0201_p0250;

import java.util.HashMap;

/**
 * @author ACC
 * @desc
 * @create 2020/11/23
 **/
public class LeetCode0219 {

    public static void main(String[] args) {

    }

    private static class Solution {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            HashMap<Integer, Integer> hashMap = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                if (hashMap.containsKey(nums[i])) {
                    int prev = hashMap.get(nums[i]);
                    if (i - prev <= k) {
                        return true;
                    }
                }

                hashMap.put(nums[i], i);
            }

            return false;
        }
    }
}