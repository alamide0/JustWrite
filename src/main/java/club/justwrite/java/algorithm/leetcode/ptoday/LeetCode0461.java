package club.justwrite.java.algorithm.leetcode.ptoday;

import club.justwrite.java.io.Printer;

public class LeetCode0461 {

    public static void main(String[] args){
        Solution solution = new Solution();
        Printer.print(solution.hammingDistance(1, 400));
    }


    private static class Solution {
        public int hammingDistance(int x, int y) {
            int res = 0;
            while (x != 0 || y != 0){
                res += (x & 1) ^ (y & 1);
                x = x >>> 1;
                y = y >>> 1;
            }
            return res;
        }
    }
}
