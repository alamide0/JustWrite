package club.justwrite.java.algorithm.leetcode.p0401_p0450;

import club.justwrite.java.base.io.Printer;

/**
 * @author ACC
 * @desc
 * @create 2020/6/28
 **/
public class LeetCode0415 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Printer.print(solution.addStrings("9", "1"));
        Printer.print(solution.addStrings("999999", "1"));
        Printer.print("10000000009".length());
    }

    static class Solution {
        public String addStrings(String num1, String num2) {
            StringBuilder res = new StringBuilder();
            int extra = 0;
            int i = num1.length() - 1, j = num2.length() - 1;
            while (i >= 0 || j >= 0) {
                Printer.print(i + ", " + j);
                int n1 = i < 0 ? 0 : num1.charAt(i) - '0';
                int n2 = j < 0 ? 0 : num2.charAt(j) - '0';

                int t = n1 + n2 + extra;
                if (t > 9) {
                    res.append(t - 10);
                    extra = 1;
                } else {
                    res.append(t);
                    extra = 0;
                }
                i--;
                j--;
            }

            return extra == 1 ? res.append(1).reverse().toString() : res.reverse().toString();
        }
    }
}