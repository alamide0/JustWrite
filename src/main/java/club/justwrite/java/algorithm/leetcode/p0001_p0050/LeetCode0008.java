package club.justwrite.java.algorithm.leetcode.p0001_p0050;

import club.justwrite.java.io.Printer;

import java.util.Arrays;

/**
 * @author ACC
 * @desc
 * @create 2020/6/18
 **/
public class LeetCode0008 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Printer.print(solution.myAtoi("42"));
        Printer.print(solution.myAtoi(" 0000000000012345678"));
        Printer.print(solution.myAtoi("0-1"));
        Printer.print(solution.myAtoi("-000000000000001"));
        Printer.print(solution.myAtoi("+1"));
    }

    static class Solution {
        public int myAtoi(String str) {
            if (str.length() == 0) return 0;

            int[] nums = new int[12];// index = 0， 符号位
            Arrays.fill(nums, -2);

            boolean begin = false;
            int index = 0;
            for (char c : str.toCharArray()) {

                if (!begin) {
                    switch (c) {
                        case ' ':
                            continue;
                        case '-':
                            nums[index++] = -1;
                            break;
                        case '+':
                        case '0':
                            nums[index++] = 0;
                            break;
                        default:
                            if (c > '0' && c <= '9') {
                                nums[index++] = 0;
                                nums[index++] = c - '0';
                            } else {
                                return 0;
                            }

                    }
                    begin = true;
                } else {
                    if (index == 1 && c == '0') {
                        continue;
                    }

                    if (c < '0' || c > '9') {
                        break;
                    }

                    nums[index++] = c - '0';

                    if (index >= nums.length) {
                        break;
                    }
                }

            }

            long result = 0;

            for (int i = 1; i < index; i++) {
                result = result * 10 + nums[i];
            }

            if (nums[0] == 0) {
                return result > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) result;
            } else if (nums[0] == -1) {
                return -result < Integer.MIN_VALUE ? Integer.MIN_VALUE : (int) -result;
            }

            return 0;
        }
    }
}
