package club.justwrite.java.algorithm.leetcode.p0851_p0900;

import club.justwrite.java.algorithm.leetcode.ListNode;
import club.justwrite.java.algorithm.leetcode.TreeNode;

import club.justwrite.java.io.Printer;

/**
 * @author ACC
 * @desc
 * @create 2020/10/20
 **/
public class LeetCode0867 {

    public static void main(String[] args) {
        Solution solution = new Solution();

        Printer.print(solution.transpose(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
        Printer.print(solution.transpose(new int[][]{{1, 2, 3}, {4, 5, 6}}));
    }

    static class Solution {
        public int[][] transpose(int[][] A) {
            int[][] res = new int[A[0].length][A.length];

            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[0].length; j++) {
                    res[i][j] = A[j][i];
                }
            }

            return res;
        }
    }
}