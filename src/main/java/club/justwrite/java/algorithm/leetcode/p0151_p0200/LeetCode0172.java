package club.justwrite.java.algorithm.leetcode.p0151_p0200;

import club.justwrite.java.base.io.Printer;

/**
 * @author ACC
 * @desc
 * @create 2020/11/18
 **/
public class LeetCode0172 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Printer.print(solution.trailingZeroes(130));
    }

    private static class Solution {
        public int trailingZeroes(int n) {

            int ans = 0;

            for (int i = 1; i <= n; i++) {
                if (i % 5 == 0) {
                    int tmp = i;

                    while (tmp != 0) {
                        if (tmp % 5 == 0) {
                            ans++;
                        } else {
                            break;
                        }
                        tmp = tmp / 5;
                    }
                }

            }

            return ans;
        }
    }
}