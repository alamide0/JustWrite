package club.justwrite.java.algorithm.leetcode;

import club.justwrite.java.io.Printer;

/**
 * @author ACC
 * @desc
 * @create 2020/6/11
 **/
public class LeetCode0567 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Printer.print(solution.checkInclusion("a", "ab"));
    }

    static class Solution {
        public boolean checkInclusion(String s1, String s2) {

            if (s1.length() > s2.length()) return false;
            if (s1.length() == s2.length() && s1.equals(s2)) return true;

            int[] array1 = new int[26];
            int[] array2 = new int[26];

            for (int i = 0; i < s1.length(); i++) {
                array1[s1.charAt(i) - 'a']++;
                array2[s2.charAt(i) - 'a']++;
            }

            if (equals(array1, array2)) return true;
            for (int i = 0; i < s2.length() - s1.length(); i++) {

                array2[s2.charAt(i) - 'a']--;
                array2[s2.charAt(s1.length() + i) - 'a']++;
                if (equals(array1, array2)) {
                    return true;
                }
            }

            return false;
        }

        private boolean equals(int[] array1, int[] array2) {
            for (int i = 0; i < 26; i++) {
                if (array1[i] != array2[i]) {
                    return false;
                }
            }
            return true;
        }
    }
}


