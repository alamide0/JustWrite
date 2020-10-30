package club.justwrite.java.algorithm.leetcode.p0301_p0350;

import club.justwrite.java.io.Printer;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author ACC
 * @desc
 * @create 2020/10/26
 **/
public class LeetCode0349 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Printer.print(solution.intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2}));
        Printer.print(solution.intersection(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4, 5}));
    }

    static class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            HashSet<Integer> set1 = new HashSet<>();
            HashSet<Integer> set2 = new HashSet<>();


            for (int n : nums1) {
                set1.add(n);
            }

            for (int n : nums2) {
                set2.add(n);
            }

            int[] res = new int[set1.size()];
            int index = 0;
            for (int n : set1) {
                if (set2.contains(n)) {
                    res[index++] = n;
                }
            }

            return Arrays.copyOf(res, index);
        }
    }
}