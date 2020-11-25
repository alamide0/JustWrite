package club.justwrite.java.algorithm.leetcode.p0901_p0950;

/**
 * @author ACC
 * @desc
 * @create 2020/11/25
 **/
public class LeetCode0917 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    private static class Solution {
        public String reverseOnlyLetters(String S) {
            char[] chars = S.toCharArray();

            int left = 0;
            int right = chars.length - 1;

            while (left < right) {
                while (left < right && !isChar(chars[left])) left++;
                while (left < right && !isChar(chars[right])) right--;

                if (left < right) {
                    char tmpC = chars[left];
                    chars[left] = chars[right];
                    chars[right] = tmpC;
                    left++;
                    right--;
                }
            }

            return String.valueOf(chars);

        }

        private boolean isChar(char c) {
            return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
        }
    }
}