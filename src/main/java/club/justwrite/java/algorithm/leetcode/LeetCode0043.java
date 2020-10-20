package club.justwrite.java.algorithm.leetcode;

import club.justwrite.java.io.Printer;

import java.util.Arrays;

/**
 * @author ACC
 * @desc
 * @create 2020/8/13
 **/
public class LeetCode0043 {

    public static void main(String[] args) {
        Solution solution = new Solution();

        Printer.print(solution.multiply("99", "100"));
    }

    static class Solution {
        public String multiply(String num1, String num2) {
            if ("0".equals(num1) || "0".equals(num2)) return "0";

            int[] res = new int[num1.length() + num2.length()];

            for (int i = num1.length() - 1; i >= 0; i--) {
                int n1 = num1.charAt(i) - '0';
                for (int j = num2.length() - 1; j >= 0; j--) {
                    res[i + j + 1] += n1 * (num2.charAt(j) - '0');
                    res[i + j] += res[i + j + 1] / 10;
                    res[i + j + 1] %= 10;
                }
            }

            StringBuilder stringBuilder = new StringBuilder();
            boolean start = false;
            for (int re : res) {
                if (!start && re == 0) continue;
                start = true;

                stringBuilder.append(re);
            }

            return stringBuilder.toString();
        }
    }
}
