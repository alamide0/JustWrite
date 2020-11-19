package club.justwrite.java.algorithm.leetcode.p0051_p0100;

import java.util.Arrays;

/**
 * @author ACC
 * @desc
 * @create 2020/11/17
 **/
public class LeetCode0066 {

    public static void main(String[] args) {

    }

    private static class Solution {
        public int[] plusOne(int[] digits) {
            int[] res = new int[digits.length + 1];

            int extra = 1;
            for (int i = digits.length - 1; i >= 0; i--) {
                res[i + 1] = (digits[i] + extra) % 10;
                extra = (digits[i] + extra) / 10;
            }

            res[0] = extra;
            if (res[0] == 0) {
                return Arrays.copyOfRange(res, 1, res.length);
            }

            return res;
        }
    }
}