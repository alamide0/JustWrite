package club.justwrite.java.algorithm.leetcode.p0051_p0100;

/**
 * @author ACC
 * @desc
 * @create 2020/11/17
 **/
public class LeetCode0058 {

    public static void main(String[] args) {

    }

    private static class Solution {
        public int lengthOfLastWord(String s) {
            s = s.trim();
            return s.length() - s.lastIndexOf(" ");
        }
    }
}