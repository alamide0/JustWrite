package club.justwrite.java.algorithm.leetcode.p0901_p0950;

import club.justwrite.java.io.Printer;

/**
 * @author ACC
 * @desc
 * @create 2020/11/3
 **/
public class LeetCode0941 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Printer.print(solution.validMountainArray(new int[]{2, 1}));
        Printer.print(solution.validMountainArray(new int[]{3, 5, 5}));
        Printer.print(solution.validMountainArray(new int[]{0, 3, 2, 1}));
        Printer.print(solution.validMountainArray(new int[]{0, 3, 2, 1}));
        Printer.print(solution.validMountainArray(new int[]{4, 3, 2, 1}));
    }

    private static class Solution {
        public boolean validMountainArray(int[] A) {
            if (A.length < 3) return false;
            int start = 0, end = A.length - 1;
            while (start < end && A[start] < A[start + 1]) start++;
            while (start < end && A[end] < A[end - 1]) end--;
            return start == end && start < A.length - 1 && end > 0;
        }
    }
}