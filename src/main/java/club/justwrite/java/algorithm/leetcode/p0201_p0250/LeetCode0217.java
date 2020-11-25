package club.justwrite.java.algorithm.leetcode.p0201_p0250;

import java.util.HashSet;

/**
 * @author ACC
 * @desc
 * @create 2020/11/23
 **/
public class LeetCode0217 {

    public static void main(String[] args) {

    }

    private static class Solution {
        public boolean containsDuplicate(int[] nums) {
            HashSet<Integer> integerHashSet = new HashSet<>();

            for (int n : nums) {
                if (integerHashSet.contains(n)) {
                    return true;
                } else {
                    integerHashSet.add(n);
                }
            }

            return false;
        }
    }
}