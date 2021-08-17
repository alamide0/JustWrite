package club.justwrite.java.algorithm.leetcode.p0201_p0250;

import club.justwrite.java.base.io.Printer;

/**
 * @author ACC
 * @desc
 * @create 2020/10/26
 **/
public class LeetCode0242 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Printer.print(solution.isAnagram("anagram", "nagaram"));
        Printer.print(solution.isAnagram("rat", "car"));
    }

    static class Solution {
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) return false;

            int[] chars = new int[26];

            for (int i = 0; i < s.length(); i++) {
                chars[s.charAt(i) - 'a']++;
                chars[t.charAt(i) - 'a']--;
            }

            for (int i = 0; i < chars.length; i++) {
                if (chars[i] != 0) {
                    return false;
                }
            }
            return true;
        }
    }
}