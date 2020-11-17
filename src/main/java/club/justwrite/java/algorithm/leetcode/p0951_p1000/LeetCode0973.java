package club.justwrite.java.algorithm.leetcode.p0951_p1000;

import club.justwrite.java.io.Printer;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author ACC
 * @desc
 * @create 2020/11/9
 **/
public class LeetCode0973 {

    public static void main(String[] args) {
        Solution solution = new Solution();

//        Printer.print(solution.kClosest(new int[][]{{1, 3}, {-2, 2}}, 1));

        Printer.print(solution.kClosest(new int[][]{{3, 3}, {5, -1}, {-2, 4}, {0, 0}, {3, 5}, {1, 1}}, 2));
    }

    private static class Solution {
        public int[][] kClosest(int[][] points, int K) {
            quickSort(points, 0, points.length - 1, K);

            return Arrays.copyOfRange(points, 0, K);
        }


        public int[][] kClosest2(int[][] points, int K) {
            Arrays.sort(points, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[1] * o1[1] + o1[0] * o1[0] - o2[1] * o2[1] - o2[0] * o2[0];
                }
            });

            return Arrays.copyOfRange(points, 0, K);
        }

        private void quickSort(int[][] array, int left, int right, int K) {

            if (left >= right) return;
            int pivot = array[left][0] * array[left][0] + array[left][1] * array[left][1];

            int start = left, end = right;
            while (start < end) {
                while (start < end && array[start][0] * array[start][0] + array[start][1] * array[start][1] < pivot)
                    start++;
                while (start < end && array[end][0] * array[end][0] + array[end][1] * array[end][1] > pivot)
                    end--;

                if (start < end && array[end][0] * array[end][0] + array[end][1] * array[end][1] == array[start][0] * array[start][0] + array[start][1] * array[start][1]) {
                    start++;
                } else {
                    int[] tmp = array[start];
                    array[start] = array[end];
                    array[end] = tmp;
                }
            }

            if (end < K) {
                quickSort(array, end + 1, right, K);
            } else if (end > K) {
                quickSort(array, left, end - 1, K);
            }
        }

    }
}