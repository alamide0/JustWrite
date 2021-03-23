package club.justwrite.java.algorithm.leetcode.ptoday;

import club.justwrite.java.io.Printer;

/**
 * @author ACC
 * @desc
 * @create 2020/12/9
 **/
public class LeetCode0062 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Printer.print(solution.uniquePaths(3, 7));

        Printer.print(solution.uniquePaths(3, 2));
    }

    private static class Solution {
        public int uniquePaths(int m, int n) {

            int[][] f = new int[m][n];
            for (int i = 0; i < m; ++i) {
                f[i][0] = 1;
            }
            for (int j = 0; j < n; ++j) {
                f[0][j] = 1;
            }
            for (int i = 1; i < m; ++i) {
                for (int j = 1; j < n; ++j) {
                    f[i][j] = f[i - 1][j] + f[i][j - 1];
                }
            }
            return f[m - 1][n - 1];

        }
    }
}
