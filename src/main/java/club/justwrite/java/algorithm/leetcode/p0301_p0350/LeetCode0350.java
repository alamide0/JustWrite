package club.justwrite.java.algorithm.leetcode.p0301_p0350;

import club.justwrite.java.io.Printer;

import java.util.HashSet;

/**
 * @author ACC
 * @desc
 * @create 2020/10/26
 **/
public class LeetCode0350 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Printer.print(solution.intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2}));
    }

    static class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {

            HashSet<Integer> set = new HashSet<>();
            for (int n : nums1) {
                for (int j = 0; j < nums2.length; j++) {
                    if (n == nums2[j] && !set.contains(j)) {
                        set.add(j);
                        break;
                    }
                }
            }

            int[] res = new int[set.size()];
            int index = 0;
            for (int n : set) {
                res[index++] = nums2[n];
            }


            return res;
        }
    }
}