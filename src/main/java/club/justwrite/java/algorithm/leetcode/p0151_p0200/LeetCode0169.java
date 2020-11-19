package club.justwrite.java.algorithm.leetcode.p0151_p0200;

import java.util.HashMap;

/**
 * @author ACC
 * @desc
 * @create 2020/11/17
 **/
public class LeetCode0169 {

    public static void main(String[] args) {

    }

    private static class Solution {
        public int majorityElement(int[] nums) {
            HashMap<Integer, Integer> hashMap = new HashMap<>();

            for (int n : nums) {
                int count = hashMap.getOrDefault(n, 0);

                if (count+1 > nums.length / 2) {
                    return n;
                }

                hashMap.put(n, count + 1);
            }

            return -1;
        }
    }
}