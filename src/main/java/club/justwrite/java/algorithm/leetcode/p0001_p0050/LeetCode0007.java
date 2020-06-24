package club.justwrite.java.algorithm.leetcode.p0001_p0050;

import club.justwrite.java.io.Printer;

/**
 * @author ACC
 * @desc
 * @create 2020/6/22
 **/
public class LeetCode0007 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Printer.print(Integer.MIN_VALUE);
        Printer.print(solution.reverse(1534236469));
    }

    static class Solution {
        public int reverse(int x) {
            int res = 0, t1 = Integer.MAX_VALUE / 10, t2 = Integer.MIN_VALUE / 10;
            while (x != 0) {
                int mod = x % 10;
                if (res > t1 || (res == t1 && mod > 7)) return 0;
                if (res < t2 || (res == t2 && mod < -8)) return 0;
                res = res * 10 + mod;
                x /= 10;
            }
            return res;

        }
    }
}
