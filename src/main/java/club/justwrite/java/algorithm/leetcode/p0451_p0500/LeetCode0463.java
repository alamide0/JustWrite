package club.justwrite.java.algorithm.leetcode.p0451_p0500;

import club.justwrite.java.base.io.Printer;

/**
 * @author ACC
 * @desc
 * @create 2020/10/30
 **/
public class LeetCode0463 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Printer.print(solution.islandPerimeter(new int[][]{{0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}
        }));
    }

    private static class Solution {
        public int islandPerimeter(int[][] grid) {
            int count = 0;
            int countOne = 0;

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 1) {
                        countOne++;
                        if (j + 1 < grid[0].length && grid[i][j + 1] == 1) {
                            count += 2;
                        }

                        if (i + 1 < grid.length && grid[i + 1][j] == 1) {
                            count += 2;
                        }
                    }

                }
            }

            return countOne * 4 - count;
        }
    }
}