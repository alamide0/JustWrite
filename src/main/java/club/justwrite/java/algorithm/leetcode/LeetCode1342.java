package club.justwrite.java.algorithm.leetcode;

import club.justwrite.java.io.Printer;

/**
 * @author ACC
 * @desc 果然还是适合做简单的题目
 * 执行用时 : 0 ms, 在所有 Java 提交中击败了100.00% 的用户
 * 内存消耗 :  36.6 MB, 在所有 Java 提交中击败了100.00% 的用户
 * @create 2020/6/12
 **/
public class LeetCode1342 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Printer.print(solution.numberOfSteps(14));
        Printer.print(solution.numberOfSteps(8));
        Printer.print(solution.numberOfSteps(123));
        Printer.print(solution.numberOfSteps(0));
        Printer.print(solution.numberOfSteps(100000));
    }

    static class Solution {
        public int numberOfSteps(int num) {
            int count = 0;
            while (num != 0) {
                if ((num & 1) == 1) {//奇数
                    num -= 1;
                } else {
                    num >>= 1;
                }
                count++;
            }

            return count;
        }
    }
}

