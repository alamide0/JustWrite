package club.justwrite.java.algorithm.leetcode.p1001_p1050;

import club.justwrite.java.base.io.Printer;

import java.util.Stack;

/**
 * @author ACC
 * @desc
 * @create 2020/11/6
 **/
public class LeetCode1021 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Printer.print(solution.removeOuterParentheses("(()())(())(()(()))"));
        Printer.print(solution.removeOuterParentheses("()()"));
    }

    private static class Solution {
        public String removeOuterParentheses(String S) {
            Stack<Character> stack = new Stack<>();

            StringBuilder stringBuilder = new StringBuilder();
            char[] chars = S.toCharArray();
            int start = 0;
            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];

                if (')' == c) {
                    stack.pop();
                } else {
                    stack.push(c);
                }

                if (stack.isEmpty()) {
                    stringBuilder.append(S, start + 1, i);
                    start = i + 1;
                }

            }

            return stringBuilder.toString();
        }
    }
}