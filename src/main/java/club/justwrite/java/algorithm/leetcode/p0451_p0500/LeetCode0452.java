package club.justwrite.java.algorithm.leetcode.p0451_p0500;

import club.justwrite.java.base.io.Printer;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author ACC
 * @desc
 * @create 2020/11/23
 **/
public class LeetCode0452 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Printer.print(solution.findMinArrowShots(new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}}));
        Printer.print(solution.findMinArrowShots(new int[][]{{1, 2}}));
        Printer.print(solution.findMinArrowShots(new int[][]{{1, 2}, {3, 4}, {5, 6}, {7, 8}}));
    }

    private static class Solution {
        public int findMinArrowShots(int[][] points) {

            if (points.length == 0) return 0;

            Arrays.sort(points, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[0] == o2[0]) {
                        return o1[1] - o2[1];
                    } else {
                        return o1[0] - o2[0];
                    }
                }
            });


            int ans = points.length;
            int start = points[0][0];
            int end = points[0][1];

            for (int i = 1; i < points.length; i++) {

                if (points[i][0] >= start && points[i][0] <= end) {
                    start = Math.max(start, points[i][0]);
                    end = Math.min(end, points[i][1]);
                    ans--;
                } else {
                    start = points[i][0];
                    end = points[i][1];
                }
            }

            return ans;

        }
    }
}