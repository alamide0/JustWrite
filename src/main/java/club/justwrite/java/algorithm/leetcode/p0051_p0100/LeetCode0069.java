package club.justwrite.java.algorithm.leetcode.p0051_p0100;

import club.justwrite.java.base.io.Printer;

/**
 * @author ACC
 * @desc
 * @create 2020/11/20
 **/
public class LeetCode0069 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Printer.print(solution.mySqrt(1));
    }

    private static class Solution {
        public int mySqrt(int x) {
            int start = 0;
            int end = x;

            int ans = 0;

            while (start <= end) {
                Printer.print(start + ", "+end + ", " + (start + end) + ", " + ((start + end) / 2) + ", " + (start + (end - start) / 2));
                int middle = start + (end - start) / 2;
                if ((long) middle * middle > x) {
                    end = middle - 1;
                } else {
                    start = middle + 1;
                    ans = middle;
                }
            }

            return ans;
        }
    }
}