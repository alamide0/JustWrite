package club.justwrite.java.algorithm;

import club.justwrite.java.io.Printer;

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
        Printer.print(solution.twoSum(new int[]{2, 7, 11, 15}, 9));
        Printer.print(solution.twoSum(new int[]{3, 2, 4}, 6));
        Printer.print(solution.twoSum(new int[]{5, 75, 25}, 100));
    }

    static class Solution {
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
