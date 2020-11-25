package club.justwrite.java.algorithm.leetcode.p0351_p0400;

/**
 * @author ACC
 * @desc
 * @create 2020/11/24
 **/
public class LeetCode0387 {


    public static void main(String[] args) {

    }

    private static class Solution {
        public int firstUniqChar(String s) {
            int[][] chars = new int[26][2];

            char[] chs = s.toCharArray();

            for (int i = 0; i < chs.length; i++) {
                char c = chs[i];
                chars[c - 'a'][0]++;
                if (chars[c - 'a'][1] == 0) {
                    chars[c - 'a'][1] = i;
                }
            }

            int minIndex = Integer.MAX_VALUE;
            for (int i = 0; i < 26; i++) {
                if (chars[i][0] == 1) {
                    minIndex = Math.min(chars[i][1], minIndex);
                }
            }

            return minIndex == Integer.MAX_VALUE ? 1 : minIndex;
        }
    }
}