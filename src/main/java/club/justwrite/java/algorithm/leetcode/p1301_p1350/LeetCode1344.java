package club.justwrite.java.algorithm.leetcode.p1301_p1350;

import club.justwrite.java.base.io.Printer;

/**
 * @author ACC
 * @desc
 * @create 2020/8/14
 **/
public class LeetCode1344 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Printer.print(solution.angleClock(1, 55));
    }

    static class Solution {
        public double angleClock(int hour, int minutes) {
            double hAngle = (hour + minutes * 1.0 / 60) * 30;
            double mAngle = minutes * 6;

            Printer.print(hAngle);
            Printer.print(mAngle);
            return Math.abs(hAngle - mAngle) % 180;
        }
    }
}