package club.justwrite.java.algorithm.leetcode.p0801_p0850;

import club.justwrite.java.base.io.Printer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author ACC
 * @desc 错误
 * @create 2020/10/26
 **/
public class LeetCode0844 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Printer.print(solution.backspaceCompare("ab#c", "ad#c"));
        Printer.print(solution.backspaceCompare("ab##", "c#d#"));
        Printer.print(solution.backspaceCompare("a##c", "#a#c"));
        Printer.print(solution.backspaceCompare("a#c", "b"));

        Printer.print(solution.backspaceCompare("abcd", "bbcd"));
    }

    static class Solution {
        public boolean backspaceCompare(String S, String T) {
            Deque<Character> stack1 = new LinkedList<>();
            Deque<Character> stack2 = new LinkedList<>();

            for (int i = 0; i < S.length(); i++) {
                if (S.charAt(i) != '#') {
                    stack1.push(S.charAt(i));
                } else {
                    if (!stack1.isEmpty()) {
                        stack1.pop();
                    }
                }
            }

            for (int i = 0; i < T.length(); i++) {
                if (T.charAt(i) != '#') {
                    stack2.push(T.charAt(i));
                } else {
                    if (!stack2.isEmpty()) {
                        stack2.pop();
                    }
                }
            }

            if (stack1.size() != stack2.size()) return false;

            int size = stack1.size();
            for (int i = 0; i < size; i++) {
                if (stack1.pop() != stack2.pop()) {
                    return false;
                }
            }

            return true;
        }
    }
}