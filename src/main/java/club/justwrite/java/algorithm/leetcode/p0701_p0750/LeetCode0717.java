package club.justwrite.java.algorithm.leetcode.p0701_p0750;

/**
 * @author ACC
 * @desc
 * @create 2020/11/17
 **/
public class LeetCode0717 {

    public static void main(String[] args) {

    }

    private static class Solution {
        public boolean isOneBitCharacter(int[] bits) {
            for (int i = 0; i < bits.length; ) {
                if (bits[i] == 1) {
                    i += 2;
                } else {
                    i += 1;
                    if (i == bits.length) {
                        return true;
                    }
                }
            }

            return false;

        }
    }
}