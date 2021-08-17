package club.justwrite.java.algorithm.leetcode.p0901_p0950;

import club.justwrite.java.base.io.Printer;

/**
 * @author ACC
 * @desc
 * @create 2020/10/27
 **/
public class LeetCode0922 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Printer.print(solution.sortArrayByParityII(new int[]{4, 2, 5, 7, 1, 2, 3, 4, 6, 5, 10, 9, 14, 11}));
        Printer.print(solution.sortArrayByParityII(new int[]{3, 4}));
    }

    static class Solution {
        public int[] sortArrayByParityII(int[] A) {
            int index1 = 0, index2 = 1;

            while (true) {
                while (index1 < A.length && A[index1] % 2 == 0) index1 += 2;
                while (index2 < A.length && A[index2] % 2 == 1) index2 += 2;
                if (index1 < A.length && index2 < A.length) {
                    int tmp = A[index1];
                    A[index1] = A[index2];
                    A[index2] = tmp;
                } else {
                    break;
                }
            }

            return A;
        }
    }
}