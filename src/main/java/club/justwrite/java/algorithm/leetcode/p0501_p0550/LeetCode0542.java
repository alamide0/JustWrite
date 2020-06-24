package club.justwrite.java.algorithm.leetcode.p0501_p0550;

import club.justwrite.java.io.Printer;

import java.util.Arrays;

/**
 * @author ACC
 * @desc
 * @create 2020/6/9
 **/
public class LeetCode0542 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] ns = new int[][]{
                {1, 1, 0, 0, 1, 0, 0, 1, 1, 0},
                {1, 0, 0, 1, 0, 1, 1, 1, 1, 1},
                {1, 1, 1, 0, 0, 1, 1, 1, 1, 0},
                {0, 1, 1, 1, 0, 1, 1, 1, 1, 1},
                {0, 0, 1, 1, 1, 1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1, 1, 0, 1, 1, 1},
                {0, 1, 1, 1, 1, 1, 1, 0, 0, 1},
                {1, 1, 1, 1, 1, 0, 0, 1, 1, 1},
                {0, 1, 0, 1, 1, 0, 1, 1, 1, 1},
                {1, 1, 1, 0, 1, 0, 1, 1, 1, 1},
        };
        Printer.print(solution.updateMatrix(ns));
    }

    static class Solution {
        public int[][] updateMatrix(int[][] matrix) {

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (matrix[i][j] != 0) {
                        int min = 10001;
                        //左侧探索
                        if (j - 1 >= 0) {
                            if (matrix[i][j - 1] == 0) {
                                matrix[i][j] = 1;
                                continue;
                            } else {
                                if (min > matrix[i][j - 1] + 1) {
                                    min = matrix[i][j - 1] + 1;
                                }
                            }
                        }

                        //上侧探索
                        if (i - 1 >= 0) {
                            if (matrix[i - 1][j] == 0) {
                                matrix[i][j] = 1;
                                continue;
                            } else {
                                if (min > matrix[i - 1][j] + 1) {
                                    min = matrix[i - 1][j] + 1;
                                }
                            }

                        }

                        matrix[i][j] = min;
                    }
                }
            }

            for (int i = matrix.length - 1; i >= 0; i--) {
                for (int j = matrix[0].length - 1; j >= 0; j--) {
                    if (matrix[i][j] != 0) {
                        //右侧探索
                        if (j + 1 < matrix[0].length) {
                            if (matrix[i][j + 1] == 0) {
                                matrix[i][j] = 1;
                            } else {
                                if (matrix[i][j] > matrix[i][j + 1] + 1) {
                                    matrix[i][j] = matrix[i][j + 1] + 1;
                                }
                            }
                        }

                        //下侧探索
                        if (i + 1 < matrix.length) {
                            if (matrix[i + 1][j] == 0) {
                                matrix[i][j] = 1;
                            } else {
                                if (matrix[i][j] > matrix[i + 1][j] + 1) {
                                    matrix[i][j] = matrix[i + 1][j] + 1;
                                }
                            }
                        }

                    }
                }
            }


            return matrix;
        }
    }
}