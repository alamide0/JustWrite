package club.justwrite.java.algorithm.leetcode.p0451_p0500;

import java.util.HashMap;

/**
 * @author ACC
 * @desc
 * @create 2020/11/27
 **/
public class LeetCode0454 {

    public static void main(String[] args) {

    }

    private static class Solution {
        public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
            HashMap<Integer, Integer> preMap = new HashMap<>();

            int count = 0;
            for (int aA : A) {
                for (int aB : B) {
                    preMap.put(aA + aB, preMap.getOrDefault(aA + aB, 0) + 1);
                }
            }

            for (int aC : C) {
                for (int aD : D) {
                    if (preMap.containsKey(-aC - aD)) {
                        count += preMap.get(-aC - aD);
                    }
                }
            }

            return count;
        }
    }
}