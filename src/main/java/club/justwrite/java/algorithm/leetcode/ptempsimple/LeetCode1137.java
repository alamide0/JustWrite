package club.justwrite.java.algorithm.leetcode.ptempsimple;

import club.justwrite.java.io.Printer;

/**
 * @author ACC
 * @desc 递归效率太低
 * @create 2020/10/29
 **/
public class LeetCode1137 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Printer.print(solution.tribonacci(37));
    }

    private static class Solution {

        public int tribonacci(int n) {
            int[] cache = new int[38];
            cache[0] = 0;
            cache[1] = 1;
            cache[2] = 1;
            if (n != 0 && cache[n] != 0) {
                return cache[n];
            }

            for (int i = 3; i <= n; i++) {
                cache[i] = cache[i - 1] + cache[i - 2] + cache[i - 3];
            }

            return cache[n];
        }
    }
}
