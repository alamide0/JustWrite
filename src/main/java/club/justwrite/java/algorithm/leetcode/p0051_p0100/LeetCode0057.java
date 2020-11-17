package club.justwrite.java.algorithm.leetcode.p0051_p0100;

import club.justwrite.java.io.Printer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ACC
 * @desc 这题没能耐心的解出来，主要是思路太复杂，操作太复杂
 * @create 2020/11/4
 **/
public class LeetCode0057 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Printer.print(solution.insert(new int[][]{{3, 5}}, new int[]{1, 2}));
        Printer.print(solution.insert(new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}, new int[]{4, 8}));
    }

    private static class Solution {
        public int[][] insert(int[][] intervals, int[] newInterval) {
            List<int[]> list = new ArrayList<>();

            int left = newInterval[0];
            int right = newInterval[1];
            boolean hasPlaced = false;

            for (int[] ns : intervals) {
                if (ns[1] < left) {
                    list.add(ns);
                } else if (ns[0] > right) {
                    if (!hasPlaced) {
                        list.add(new int[]{left, right});
                        hasPlaced = true;
                    }
                    list.add(ns);
                } else {
                    left = Math.min(left, ns[0]);
                    right = Math.max(right, ns[1]);
                }
            }

            if (!hasPlaced) {
                list.add(new int[]{left, right});
            }

            int[][] res = new int[list.size()][2];

            for (int i = 0; i < list.size(); i++) {
                res[i] = list.get(i);
            }

            return res;
        }
    }
}