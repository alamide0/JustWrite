package club.justwrite.java.algorithm.leetcode.p0901_p0950;

import club.justwrite.java.algorithm.leetcode.ListNode;
import club.justwrite.java.algorithm.leetcode.TreeNode;

import club.justwrite.java.io.Printer;

import java.util.Arrays;

/**
 * @author ACC
 * @desc
 * @create 2020/8/13
 **/
public class LeetCode0949 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Printer.print(solution.largestTimeFromDigits(new int[]{1, 2, 3, 4}));
        Printer.print(solution.largestTimeFromDigits(new int[]{0, 2, 6, 6}));
        Printer.print(solution.largestTimeFromDigits(new int[]{0, 0, 1, 0}));


    }

    static class Solution {

        public String largestTimeFromDigits(int[] A) {
            Arrays.sort(A);

            for (int i = 3; i >= 0; i--) {
                if (A[i] > 2) continue;
                for (int j = 3; j >= 0; j--) {
                    if (j == i) continue;
                    if (A[i] == 2 && A[j] > 3) continue;
                    for (int k = 3; k >= 0; k--) {
                        if (k == i || k == j || A[k] > 5) continue;
                        return A[i] + "" + A[j] + ":" + A[k] + A[6 - i - j - k];
                    }
                }
            }

            return "";
        }

    }
}