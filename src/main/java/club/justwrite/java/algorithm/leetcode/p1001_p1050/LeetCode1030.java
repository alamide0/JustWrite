package club.justwrite.java.algorithm.leetcode.p1001_p1050;

import club.justwrite.java.base.io.Printer;

/**
 * @author ACC
 * @desc
 * @create 2020/10/28
 **/
public class LeetCode1030 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Printer.print(solution.allCellsDistOrder(1, 2, 0, 0));
        Printer.print("==============");
        Printer.print(solution.allCellsDistOrder(2, 2, 0, 1));
        Printer.print("==============");
        Printer.print(solution.allCellsDistOrder(2, 3, 1, 2));
    }

    static class Solution {
        public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
            int[][] res = new int[R * C][2];
            int[] dx = new int[R * C];
            res[0] = new int[]{r0, c0};
            dx[0] = 0;
            int index = 1;

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (i == r0 && j == c0) continue;
                    res[index] = new int[]{i, j};
                    dx[index] = Math.abs(i - r0) + Math.abs(j - c0);
                    index++;
                }
            }

            quickSort(0, dx.length - 1, dx, res);

            return res;
        }


        private void quickSort(int start, int end, int[] dx, int[][] res) {
            if (start >= end) return;
            int i = start, j = end;
            int pivot = dx[start];

            while (i < j) {
                while (i < j && dx[j] > pivot) j--;
                while (i < j && dx[i] < pivot) i++;

                if (i < j && dx[i] == dx[j]) {
                    i++;
                } else {
                    int tmp = dx[i];
                    dx[i] = dx[j];
                    dx[j] = tmp;

                    int[] tt = res[i];
                    res[i] = res[j];
                    res[j] = tt;
                }
            }

            quickSort(start, i - 1, dx, res);
            quickSort(i + 1, end, dx, res);
        }

    }
}