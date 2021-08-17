package club.justwrite.java.algorithm.leetcode.p0901_p0950;

import club.justwrite.java.base.io.Printer;

/**
 * @author ACC
 * @desc
 * @create 2020/10/21
 **/
public class LeetCode0925 {

    public static void main(String[] args) {
        Solution solution = new Solution();

        //"abcd"
        //"aaabbbcccddd"
        Printer.print(solution.isLongPressedName("abcd", "aaabbbcccddd"));
//        Printer.print(solution.isLongPressedName("abcdefg", "aaaaaaabccdeeeeeeeffffffffffg"));
//        Printer.print(solution.isLongPressedName("abcdefg", "aaaaaaabccdeeeeeeeffffffffffge"));
//        Printer.print(solution.isLongPressedName("ab", "abaa"));
//        Printer.print(solution.isLongPressedName("ab", "a"));
//        Printer.print(solution.isLongPressedName("leelee", "lleeelee"));
    }


    static class Solution {
        public boolean isLongPressedName(String name, String typed) {

            if (name.length() > typed.length()) return false;

            if (name.length() == typed.length()) {
                return name.equals(typed);
            }

            int pointer = 0;
            char lastChar = name.charAt(0);

            for (int i = 0; i < name.length(); i++) {
                char c1 = name.charAt(i);
                while (true) {
                    if (pointer > typed.length() - 1) return false;
                    char cur = typed.charAt(pointer++);

                    if (cur != c1) {
                        if (cur != lastChar) return false;
                    } else {
                        lastChar = c1;
                        break;
                    }
                }

            }


            if (pointer < typed.length()) {
                for (int i = pointer - 1; i < typed.length(); i++) {
                    if (typed.charAt(i) != typed.charAt(pointer - 1)) {
                        return false;
                    }
                }
            }

            return true;
        }
    }
}