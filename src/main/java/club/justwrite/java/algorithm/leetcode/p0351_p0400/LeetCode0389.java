package club.justwrite.java.algorithm.leetcode.p0351_p0400;

/**
 * @author ACC
 * @desc
 * @create 2020/11/23
 **/
public class LeetCode0389 {

    public static void main(String[] args) {

    }

    private static class Solution {
        public char findTheDifference(String s, String t) {
            int[] counts = new int[26];


            for (int i = 0; i < s.length(); i++) {
                counts[s.charAt(i) - 'a']++;
            }

            for (int i = 0; i < t.length(); i++) {
                counts[s.charAt(i) - 'a']--;
            }

            for (int i = 0; i < counts.length; i++) {
                if (counts[i] != 0) {
                    return (char) ('a' + i);
                }
            }

            return ' ';

        }
    }
}