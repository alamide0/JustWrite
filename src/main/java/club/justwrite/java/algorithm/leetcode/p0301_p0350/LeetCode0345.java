package club.justwrite.java.algorithm.leetcode.p0301_p0350;

import club.justwrite.java.base.io.Printer;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author ACC
 * @desc
 * @create 2020/10/23
 **/
public class LeetCode0345 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Printer.print(solution.reverseVowels("leetcode"));
    }

    static class Solution {

        public String reverseVowels(String s) {
            char[] chars = s.toCharArray();
            int pointer1 = 0;
            int pointer2 = chars.length - 1;

            HashSet<Character> hashSet = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));


            while (pointer1 < pointer2) {

                while (pointer1 < pointer2 && !hashSet.contains(chars[pointer1])) pointer1++;
                while (pointer1 < pointer2 && !hashSet.contains(chars[pointer2])) pointer2--;

                if (pointer1 > pointer2) break;

                char tmp = chars[pointer1];
                chars[pointer1] = chars[pointer2];
                chars[pointer2] = tmp;
                pointer1++;
                pointer2--;
            }

            return String.valueOf(chars);
        }

    }
}