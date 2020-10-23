package club.justwrite.java.algorithm.leetcode.p0951_p1000;

import club.justwrite.java.io.Printer;

/**
 * @author ACC
 * @desc
 * @create 2020/10/23
 **/
public class LeetCode0977 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Printer.print(solution.sortedSquares(new int[]{-4, -1, 0, 3, 10}));
        Printer.print(solution.sortedSquares(new int[]{-7,-3,2,3,11}));
        Printer.print(solution.sortedSquares(new int[]{-10, -6, -3}));
        Printer.print(solution.sortedSquares(new int[]{}));
    }

    static class Solution {
        public int[] sortedSquares(int[] A) {
            int[] res = new int[A.length];
            int pointer1 = 0, pointer2 = A.length - 1;
            int pointer = A.length - 1;

            while (pointer1 <= pointer2) {
                if (A[pointer1] >= 0) {
                    for (int i = pointer2; i >= pointer1; i--) {
                        res[pointer--] = A[i] * A[i];
                    }
                    break;
                }

                if (Math.abs(A[pointer1]) > Math.abs(A[pointer2])) {
                    res[pointer--] = A[pointer1] * A[pointer1];
                    pointer1++;
                } else {
                    res[pointer--] = A[pointer2] * A[pointer2];
                    pointer2--;
                }
            }

            return res;
        }
    }
}