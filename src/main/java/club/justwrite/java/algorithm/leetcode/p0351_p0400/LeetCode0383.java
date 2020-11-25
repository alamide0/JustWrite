package club.justwrite.java.algorithm.leetcode.p0351_p0400;

/**
 * @author ACC
 * @desc
 * @create 2020/11/24
 **/
public class LeetCode0383 {

    public static void main(String[] args) {

    }

    private static class Solution {
        public boolean canConstruct(String ransomNote, String magazine) {
            int[] ransomArray = new int[26];

            int[] magazineArray = new int[26];

            char[] ch1 = ransomNote.toCharArray();
            char[] cha2 = magazine.toCharArray();
            for (char c : ch1) {
                ransomArray[c - 'a']++;
            }

            for (char c : cha2) {
                magazineArray[c - 'a']++;
            }

            for (int i = 0; i < 26; i++) {
                if (ransomArray[i] > magazineArray[i]) {
                    return false;
                }
            }


            return true;
        }
    }
}