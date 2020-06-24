package club.justwrite.java.algorithm.leetcode.p1001_p1050;

import club.justwrite.java.io.Printer;

/**
 * @author ACC
 * @desc
 * @create 2020/6/17
 **/
public class LeetCode1014 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Printer.print(solution.maxScoreSightseeingPair(new int[]{8,1,5,2,6}));
    }

    static class Solution {
        public int maxScoreSightseeingPair(int[] A) {

            int best = A[0];
            int max = A[0];

            for (int i = 1; i < A.length; i++) {
                max = max - 1;

                int tBest = A[i] + max;
                if (tBest > best) {
                    best = tBest;
                }

                if (A[i] > max) {
                    max = A[i];
                }
            }

            return best;
        }
    }
}

