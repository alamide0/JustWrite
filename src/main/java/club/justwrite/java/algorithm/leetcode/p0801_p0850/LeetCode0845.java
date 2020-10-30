package club.justwrite.java.algorithm.leetcode.p0801_p0850;

import club.justwrite.java.io.Printer;

/**
 * @author ACC
 * @desc
 * @create 2020/10/25
 **/
public class LeetCode0845 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Printer.print(solution.longestMountain(new int[]{1,2,3,4,5,6,7,8,2,2,3,34,3452,4,5,6,7,8,4,23,45,43,34,34,43,436,465,4,3543,5,43,5,34,5,435,43}));
    }

    static class Solution {
        public int longestMountain(int[] A) {
            int max = 0;
            int length = 0;
            int[] state = {0, 0};

            for (int i = 1; i < A.length; i++) {
                if (A[i] > A[i - 1]) {
                    if (state[0] == 1 && state[1] == 1) {
                        state[1] = 0;
                        length = 2;
                    } else if (state[0] == 1) {
                        length++;
                    } else if (state[0] == 0) {
                        state[0] = 1;
                        length = 2;
                    }
                } else if (A[i] < A[i - 1]) {
                    if (state[0] == 1) {
                        state[1] = 1;
                        max = Math.max(++length, max);
                    }
                } else {
                    if (state[1] == 1 && state[0] == 1) {
                        max = Math.max(length, max);
                    }
                    state[1] = 0;
                    state[0] = 0;
                }

            }


            return max;
        }
    }
}