package club.justwrite.java.algorithm.leetcode.ptoday;

import club.justwrite.java.io.Printer;

/**
 * @author ACC
 * @desc
 * @create 2020/12/9
 **/
public class LeetCode0861 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Printer.print(solution.matrixScore(new int[][]{{0, 0, 1, 1}, {1, 0, 1, 0}, {1, 1, 0, 0}}));
    }

    private static class Solution {
        public int matrixScore(int[][] A) {

            if (A.length == 0) return 0;
            int ans = (int) (A.length * Math.pow(2, A[0].length - 1));

            for (int i = 0; i < A.length; i++) {
                if (A[i][0] == 0) {
                    for (int j = 0; j < A[0].length; j++) {
                        A[i][j] = A[i][j] == 0 ? 1 : 0;
                    }
                }
            }

            for (int i = 1; i < A[0].length; i++) {

                int count0 = 0;
                for (int[] aA : A) {
                    if (aA[i] == 0) count0++;
                }

                ans += (int) Math.pow(2, A[0].length - 1 - i) * Math.max(count0, A.length - count0);
            }


            return ans;

        }
    }
}
