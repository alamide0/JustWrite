package club.justwrite.java.algorithm.leetcode.p0001_p0050;

import club.justwrite.java.io.Printer;

import java.util.Arrays;

/**
 * @author ACC
 * @desc
 * @create 2020/6/5 8:43 AM
 **/
public class LeetCode0029 {

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] a = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
        };

        Printer.print(solution.spiralOrder(a));
    }

    static class Solution {

//        public static final int DW = 0;//方向西
//        public static final int DS = 1;//方向南
//        public static final int DE = 2;//方向东
//        public static final int DN = 3;//方向北

        public int[] spiralOrder(int[][] matrix) {
            if (matrix.length == 0) return new int[]{};
            int[] result = new int[matrix.length * matrix[0].length];
            int T = 0, R = matrix[0].length - 1, B = matrix.length - 1, L = 0;
            int index = 0;
            while (true) {
                for (int i = L; i <= R; i++) {
                    result[index++] = matrix[T][i];
                }

                if (++T > B) {
                    break;
                }

                for (int i = T; i <= B; i++) {
                    result[index++] = matrix[i][R];
                }

                if (--R < L) {
                    break;
                }

                for (int i = R; i >= L; i--) {
                    result[index++] = matrix[B][i];
                }

                if (--B < T) {
                    break;
                }

                for (int i = B; i >= T; i--) {
                    result[index++] = matrix[i][L];
                }

                if (++L > R) {
                    break;
                }
            }

            return result;
        }


//        public int[] spiralOrder(int[][] matrix) {
//            if (matrix.length == 0) return new int[]{};
//            int[] result = new int[matrix.length * matrix[0].length];
//            boolean[][] trace = new boolean[matrix.length][matrix[0].length];
//            for (boolean[] aTrace : trace) {
//                Arrays.fill(aTrace, false);
//            }
//            int direction = DE, curIndexI = 0, curIndexJ = 0;
//            for (int i = 0; i < result.length; i++) {
//                int rawI = curIndexI, rawJ = curIndexJ, rawD = direction;
//                result[i] = matrix[curIndexI][curIndexJ];
//                trace[curIndexI][curIndexJ] = true;
//                switch (direction) {
//                    case DE:
//                        curIndexJ += 1;
//                        break;
//                    case DS:
//                        curIndexI += 1;
//                        break;
//                    case DW:
//                        curIndexJ -= 1;
//                        break;
//                    case DN:
//                        curIndexI -= 1;
//                        break;
//                }
//
//                if (curIndexJ == matrix[0].length) {
//                    curIndexJ -= 1;
//                    direction = DS;
//                } else if (curIndexJ < 0) {
//                    curIndexJ = 0;
//                    direction = DN;
//                }
//
//
//                if (curIndexI == matrix.length) {
//                    curIndexI -= 1;
//                    direction = DW;
//                } else if (curIndexI < 0) {
//                    curIndexI = 0;
//                    direction = DE;
//                }
//
//                if (trace[curIndexI][curIndexJ]) {
//                    direction = findNextD(rawD);
//                    switch (direction) {
//                        case DE:
//                            curIndexJ = rawJ + 1;
//                            curIndexI = rawI;
//                            break;
//                        case DS:
//                            curIndexI = rawI + 1;
//                            curIndexJ = rawJ;
//                            break;
//                        case DW:
//                            curIndexJ = rawJ - 1;
//                            curIndexI = rawI;
//                            break;
//                        case DN:
//                            curIndexI = rawI - 1;
//                            curIndexJ = rawJ;
//                            break;
//                    }
//
//                }
//
//
//            }
//
//            return result;
//        }
//
//        private int findNextD(int direction) {
//            switch (direction) {
//                case DW:
//                    direction = DN;
//                    break;
//                case DS:
//                    direction = DW;
//                    break;
//                case DE:
//                    direction = DS;
//                    break;
//                case DN:
//                    direction = DE;
//                    break;
//            }
//
//            return direction;
//        }


    }
}