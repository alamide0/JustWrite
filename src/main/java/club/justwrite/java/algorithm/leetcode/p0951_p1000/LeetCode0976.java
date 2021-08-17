package club.justwrite.java.algorithm.leetcode.p0951_p1000;

import club.justwrite.java.base.io.Printer;

import java.util.Arrays;

/**
 * @author ACC
 * @desc
 * @create 2020/10/28
 **/
public class LeetCode0976 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Printer.print(solution.largestPerimeter(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 100, 100, 1000, 900, 901, 100001, 10098}));
        Printer.print(solution.largestPerimeter(new int[]{2, 1, 2}));
        Printer.print(solution.largestPerimeter(new int[]{1, 1, 2}));
        Printer.print(solution.largestPerimeter(new int[]{3, 2, 3, 4}));
        Printer.print(solution.largestPerimeter(new int[]{3, 6, 2, 3}));
    }

    static class Solution {
        public int largestPerimeter(int[] A) {
            Arrays.sort(A);

            for (int j = A.length - 1; j >= 2; j--) {
                if (A[j - 1] + A[j - 2] > A[j]) return A[j - 1] + A[j - 2] + A[j];
            }

            return 0;
        }
    }
}