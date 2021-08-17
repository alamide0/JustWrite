package club.justwrite.java.algorithm.leetcode.p1351_p1400;

import club.justwrite.java.base.io.Printer;

/**
 * @author ACC
 * @desc
 * @create 2020/10/28
 **/
public class LeetCode1370 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Printer.print(solution.sortString("aaaabbbbcccc"));
        Printer.print(solution.sortString("rat"));
        Printer.print(solution.sortString("leetcode"));
        Printer.print(solution.sortString("ggggggg"));
        Printer.print(solution.sortString("spo"));
    }

    static class Solution {
        public String sortString(String s) {
            int[] chars = new int[26];

            for (int i = 0; i < s.length(); i++) {
                chars[s.charAt(i) - 'a']++;
            }

            StringBuilder buffer = new StringBuilder();
            boolean step1 = true;
            int count = 0;
            while (count < s.length()) {
                if (step1) {
                    for (int i = 0; i < chars.length; i++) {
                        if (chars[i] > 0) {
                            buffer.append((char) ('a' + i));
                            chars[i]--;
                            count++;
                        }
                    }
                    step1 = false;
                } else {
                    for (int i = chars.length - 1; i >= 0; i--) {
                        if (chars[i] > 0) {
                            buffer.append((char) ('a' + i));
                            chars[i]--;
                            count++;
                        }
                    }
                    step1 = true;
                }
            }

            return buffer.toString();

        }
    }
}