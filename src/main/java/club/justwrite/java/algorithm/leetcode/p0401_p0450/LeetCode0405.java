package club.justwrite.java.algorithm.leetcode.p0401_p0450;

import club.justwrite.java.io.Printer;

import java.util.Arrays;

/**
 * @author ACC
 * @desc
 * @create 2020/10/30
 **/
public class LeetCode0405 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 10000;
        Printer.print(solution.toHex2(100001));
        Printer.print(Integer.toHexString(100001));
    }

    private static class Solution {

        public String toHex2(int num) {
            if (num == 0) return "0";
            StringBuilder builder = new StringBuilder();

            char[] chars = "0123456789abcdef".toCharArray();
            int n = num;

            while (n != 0) {
                builder.append(chars[n & 15]);
                n = n >>> 4;
            }

            return builder.reverse().toString();

        }

        public String toHex(int num) {

            int n = num;
            int[] binary = new int[32];
            int index = 0;

            binary[31] = num < 0 ? 1 : 0;


            while (n != 0) {
                binary[index++] = Math.abs(n % 2);
                n = n / 2;
            }

            if (num < 0) {
                int add = 1;
                for (int i = 0; i < binary.length - 1; i++) {
                    binary[i] = (binary[i] == 1 ? 0 : 1);
                    binary[i] = binary[i] + add;
                    if (binary[i] == 2) {
                        binary[i] = 0;
                        add = 1;
                    } else {
                        add = 0;
                    }
                }
            }

            char[] res = new char[8];
            Arrays.fill(res, '0');
            index = 0;

            for (int i = 0; i <= binary.length - 4; i += 4) {
                res[index++] = toChar(binary[i + 3] * 8 + binary[i + 2] * 4 + binary[i + 1] * 2 + binary[i]);
            }

            Printer.print(index);
            int endIndex = 0;
            for (int i = res.length - 1; i >= 0; i--) {
                if (res[i] != '0') {
                    endIndex = i;
                    break;
                }
            }

            char[] chars = Arrays.copyOf(res, endIndex + 1);

            for (int i = 0; i < chars.length / 2; i++) {
                char tm = chars[i];
                chars[i] = chars[chars.length - 1 - i];
                chars[chars.length - 1 - i] = tm;
            }

            return String.valueOf(chars);
        }

        private char toChar(int n) {
            char[] chars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
            return chars[n];
        }
    }
}