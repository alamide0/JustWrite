package club.justwrite.java.algorithm.leetcode.p0551_p0600;

import club.justwrite.java.algorithm.leetcode.test.MainMethod;
import club.justwrite.java.algorithm.leetcode.test.Tester;

import java.util.HashMap;
import java.util.Map;


/**
 * @author ACC
 * @desc
 * @create 2020/6/21
 **/
public class LeetCode0560 {

    public static void main(String[] args) {
        Solution2 solution = new Solution2();

        Object[] objects = new Object[]{
                new Object[]{
                        new int[]{1, 1, 1, 1, -1, 3, -1},
                        2
                }, 6
        };

        Tester.test(objects, solution);

    }

    static class Solution {
        @MainMethod
        public int subarraySum(int[] nums, int k) {
            int res = 0, sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum = 0;
                for (int j = i; j < nums.length; j++) {
                    sum += nums[j];
                    if (sum == k) {
                        res++;
                    }
                }
//官方的暴力求解
//                for (int j = i; j >= 0; j--) {
//                    sum += nums[j];
//                    if (sum == k) {
//                        res++;
//                    }
//                }
            }
            return res;
        }
    }

    static class Solution2 {
        @MainMethod
        public int subarraySum(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);
            int res = 0;
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                int value = sum - k;

                res += map.getOrDefault(value, 0);

                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }

            return res;
        }
    }

}


