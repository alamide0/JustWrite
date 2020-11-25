package club.justwrite.java.algorithm.leetcode.p0151_p0200;

import club.justwrite.java.io.Printer;

/**
 * @author ACC
 * @desc
 * @create 2020/11/19
 **/
public class LeetCode0168 {

    public static void main(String[] args) {
        Solution solution = new Solution();
//        Printer.print(solution.convertToTitle(28));
        Printer.print(solution.convertToTitle2(26));
    }

    private static class Solution {
        public String convertToTitle(int n) {
            StringBuilder stringBuilder = new StringBuilder();

            while (n != 0) {
                int mod = (n % 26);
                n = n / 26;

                if (mod == 0) {
                    stringBuilder.append('Z');
                    n -= 1;
                } else {
                    stringBuilder.append((char) ('A' + mod - 1));
                }


            }

            return stringBuilder.reverse().toString();
        }

        public String convertToTitle2(int n) {
            StringBuilder stringBuilder = new StringBuilder();
            while (n != 0) {
                n--; // 依次获取 26 进制逻辑上的个位、十位、百位…（虽然在 26 进制中不这么叫）
                stringBuilder.append((char) ('A' + n % 26));
                n /= 26;
            }
            return stringBuilder.reverse().toString();
        }
    }


}