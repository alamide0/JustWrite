package club.justwrite.java.algorithm.leetcode.p0451_p0500;

/**
 * @author ACC
 * @desc
 * @create 2020/11/10
 **/
public class LeetCode0459 {

    public static void main(String[] args) {

    }

    private static class Solution {
        public boolean repeatedSubstringPattern(String s) {

            return (s + s).indexOf(s, 1) != s.length();

        }
    }
}