package club.justwrite.java.algorithm.leetcode.p0001_p0050;

import club.justwrite.java.io.Printer;

/**
 * @author ACC
 * @desc
 * @create 2020/6/23
 **/
public class LeetCode0013 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Printer.print(solution.romanToInt("III"));
        Printer.print(solution.romanToInt("IV"));
        Printer.print(solution.romanToInt("IX"));
        Printer.print(solution.romanToInt("LVIII"));
        Printer.print(solution.romanToInt("MCMXCIV"));
    }

    static class Solution {

        private static final char[] characters = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        private static final int[] nums = {1, 5, 10, 50, 100, 500, 1000};

        public int romanToInt(String s) {
            int res = 0;

            for (int i = 0; i < s.length(); ) {
                char c = s.charAt(i);

                switch (c) {
                    case 'I':
                        if (i + 1 < s.length()) {
                            if (s.charAt(i + 1) == 'V') {
                                res += 4;
                                i += 2;
                                continue;
                            } else if (s.charAt(i + 1) == 'X') {
                                res += 9;
                                i += 2;
                                continue;
                            }
                        }
                        break;
                    case 'X':
                        if (i + 1 < s.length()) {
                            if (s.charAt(i + 1) == 'L') {
                                res += 40;
                                i += 2;
                                continue;
                            } else if (s.charAt(i + 1) == 'C') {
                                res += 90;
                                i += 2;
                                continue;
                            }
                        }
                        break;
                    case 'C':
                        if (i + 1 < s.length()) {
                            if (s.charAt(i + 1) == 'D') {
                                res += 400;
                                i += 2;
                                continue;
                            } else if (s.charAt(i + 1) == 'M') {
                                res += 900;
                                i += 2;
                                continue;
                            }
                        }
                        break;
                }

                res += getN(c);
                i++;

            }

            return res;
        }


        int getN(char c) {
            for (int i = 0; i < characters.length; i++) {
                if (characters[i] == c) {
                    return nums[i];
                }
            }
            return 0;
        }

    }
}

