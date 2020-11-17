package club.justwrite.java.algorithm.leetcode.p1551_p1600;

import club.justwrite.java.io.Printer;

/**
 * @author ACC
 * @desc
 * @create 2020/11/10
 **/
public class LeetCode1576 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Printer.print(solution.modifyString("?zs"));
        Printer.print(solution.modifyString("ubv?w"));
        Printer.print(solution.modifyString("j?qg??b"));
        Printer.print(solution.modifyString(""));
        Printer.print(solution.modifyString("b"));
        Printer.print(solution.modifyString("?"));
        Printer.print(solution.modifyString("??"));
        Printer.print(solution.modifyString("???"));
    }

    private static class Solution {
        public String modifyString(String s) {

            char[] chars = s.toCharArray();

            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == '?') {
                    char ahead = i == 0 ? ' ' : chars[i - 1];
                    char behind = i == chars.length - 1 ? ' ' : chars[i + 1];

                    char tmp = 'a';

                    while (tmp == ahead || tmp == behind) tmp++;

                    chars[i] = tmp;
                }
            }

            return String.valueOf(chars);
        }


    }
}