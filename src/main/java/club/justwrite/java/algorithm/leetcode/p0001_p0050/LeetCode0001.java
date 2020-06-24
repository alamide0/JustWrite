package club.justwrite.java.algorithm.leetcode.p0001_p0050;

import club.justwrite.java.algorithm.leetcode.test.MainMethod;
import club.justwrite.java.algorithm.leetcode.test.Tester;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ACC
 * @desc
 * @create 2020/6/1 10:30 AM
 **/
public class LeetCode0001 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Object[] objects = new Object[]{
                new Object[]{new int[]{2, 7, 11, 15}, 9}, new int[]{1, 2},
                new Object[]{new int[]{3, 2, 4}, 6}, new int[]{1, 2},
                new Object[]{new int[]{5, 75, 25}, 100}, new int[]{1, 2}
        };
        Tester.test(objects, solution);
    }

    static class Solution {
        @MainMethod
        public int[] twoSum(int[] nums, int target) {
            int count = 0;
            Map<Integer, Integer> cache = new HashMap<>();//缓存
            for (int n : nums) {
                if (cache.containsKey(n)) {
                    return new int[]{cache.get(n), count};
                } else {
                    cache.put(target - n, count++);
                }
            }

            return new int[]{};
        }
    }
}