package club.justwrite.java.algorithm.leetcode.ptoday;

import club.justwrite.java.io.Printer;

/**
 * @author ACC
 * @desc
 * @create 2020/12/10
 **/
public class LeetCode0860 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Printer.print(solution.lemonadeChange(new int[]{5, 5, 5, 10, 20}));
        Printer.print(solution.lemonadeChange(new int[]{5, 5, 10}));
        Printer.print(solution.lemonadeChange(new int[]{10, 10}));
        Printer.print(solution.lemonadeChange(new int[]{5, 5, 10, 10, 20}));
    }

    private static class Solution {
        public boolean lemonadeChange(int[] bills) {
            int count5 = 0, count10 = 0;

            for (int b : bills) {
                if (b == 5) {
                    count5++;
                } else if (b == 10) {
                    if (count5 > 0) {
                        count5--;
                        count10++;
                    } else {
                        return false;
                    }
                } else {
                    if (count10 > 0 && count5 > 0) {
                        count10--;
                        count5--;

                    } else if (count5 > 2) {
                        count5 -= 3;
                    } else {
                        return false;
                    }
                }
            }

            return true;

        }
    }
}
