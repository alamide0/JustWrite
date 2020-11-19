package club.justwrite.java.algorithm.leetcode.p0151_p0200;

/**
 * @author ACC
 * @desc
 * @create 2020/11/17
 **/
public class LeetCode0191 {

    public static void main(String[] args) {

    }

    private static class Solution {
        public int hammingWeight(int n) {
            int ans = 0;

            while (n != 0) {
                ans += n & 1;
                n = n >>> 1;
            }

            return ans;
        }
    }
}