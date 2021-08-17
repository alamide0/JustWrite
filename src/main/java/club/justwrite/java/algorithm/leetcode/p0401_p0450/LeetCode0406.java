package club.justwrite.java.algorithm.leetcode.p0401_p0450;

import club.justwrite.java.base.io.Printer;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author ACC
 * @desc
 * @create 2020/11/16
 **/
public class LeetCode0406 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Printer.print(solution.reconstructQueue(new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}}));
    }


    private static class Solution {
        public int[][] reconstructQueue(int[][] people) {
            Arrays.sort(people, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[0] == o2[0]) {
                        return o2[1] - o1[1];
                    } else {
                        return o1[0] - o2[0];
                    }
                }
            });


            int[][] res = new int[people.length][];

            int dx;

            for (int[] p : people) {
                dx = p[1] + 1;
                for (int i = 0; i < people.length; i++) {
                    if (res[i] == null) {
                        dx--;
                        if (dx == 0) {
                            res[i] = p;
                            break;
                        }
                    }
                }
            }

            return res;
        }
    }
}