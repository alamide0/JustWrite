package club.justwrite.java.algorithm.leetcode.p1451_p1500;

import club.justwrite.java.base.io.Printer;

/**
 * @author ACC
 * @desc
 * @create 2020/10/26
 **/
public class LeetCode1491 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Printer.print(solution.average(new int[]{6000, 5000, 4000, 3000, 2000, 1000}));
        Printer.print(solution.average(new int[]{4000, 3000, 1000, 2000}));
        Printer.print(solution.average(new int[]{1000, 2000, 3000}));
        Printer.print(solution.average(new int[]{8000, 9000, 2000, 3000, 6000, 1000}));
    }

    static class Solution {
        public double average(int[] salary) {
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            int sum = 0;

            for (int n : salary) {
                if (n > max) max = n;
                if (n < min) min = n;
                sum += n;
            }

            return (sum - max - min) * 1.0 / (salary.length - 2);
        }
    }
}