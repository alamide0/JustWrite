package club.justwrite.java.algorithm.leetcode.ptempsimple;

import club.justwrite.java.base.io.Printer;

public class LeetCode0476 {

    public static void main(String[] args){
        Solution solution = new Solution();
        Printer.print(solution.findComplement(1));
    }

    private static class Solution {
        public int findComplement(int num) {

            int res = 0;
            int times = 0;

            while (num != 0){
                int n = num & 1;
                res += n == 0 ? Math.pow(2, times) : 0;
                num >>>= 1;
                times++;
            }

            return res;
        }
    }
}
