package club.justwrite.java.algorithm.leetcode.ptoday;

import club.justwrite.java.io.Printer;

import java.util.Arrays;

/**
 * @author ACC
 * @desc
 * @create 2020/12/3
 **/
public class LeetCode0204 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Printer.print(solution.countPrimes(10));
    }

    private static class Solution {
        public int countPrimes(int n) {

            if (n <= 2) return 0;

            boolean[] isPrimes = new boolean[n];
            Arrays.fill(isPrimes, true);

            int ans = 0;
            for (int i = 2; i < n; i++) {
                int times = 2;
                if (isPrimes[i]) ans++;
                while (isPrimes[i] && i * times < n) {
                    isPrimes[i * times] = false;
                    times++;
                }
            }

            return ans;
        }
    }
}
