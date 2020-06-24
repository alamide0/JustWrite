package club.justwrite.java.algorithm.leetcode.p0201_p0250;

import club.justwrite.java.io.Printer;

/**
 * @author ACC
 * @desc
 * @create 2020/6/24
 **/
public class LeetCode0201 {

    public static void main(String[] args) {
        LeetCode0201 leetCode0201 = new LeetCode0201();
        Solution solution = new Solution();
        Printer.print(Solution.TAGS);

        Printer.print(solution.rangeBitwiseAnd(  2147483646, 2147483647));
        Printer.print(Integer.toBinaryString(2147483646));
        Printer.print(Integer.toBinaryString(2147483647));

    }

    static class Solution {

        public static final int[] TAGS = new int[31];

        static {
            TAGS[0] = 0;
            TAGS[1] = 2;
            for (int i = 2; i < TAGS.length; i++) {
                TAGS[i] = TAGS[i - 1] << 1;
            }
        }


        public int rangeBitwiseAnd(int m, int n) {
            int res = m;

            for (int num : TAGS) {
                if (num >= m + 1 && num < n + 1) {
                    return 0;
                }
            }

            for (int i = m; i <= n; i++) {
                res &= i;
                if (res == 0) {
                    return 0;
                }

                if(i == Integer.MAX_VALUE){
                    break;
                }
            }

            return res;
        }
    }
}

