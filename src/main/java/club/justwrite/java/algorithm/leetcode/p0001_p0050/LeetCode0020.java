package club.justwrite.java.algorithm.leetcode.p0001_p0050;

import club.justwrite.java.base.io.Printer;

import java.util.*;

/**
 * @author ACC
 * @desc
 * @create 2020/6/23
 **/
public class LeetCode0020 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Printer.print(solution.isValid("()"));
        Printer.print(solution.isValid("()[]{}"));
        Printer.print(solution.isValid("(]"));
        Printer.print(solution.isValid("([)]"));
        Printer.print(solution.isValid("{[]}"));
    }

    static class Solution {

        private static final Map<Character, Character> pairs = new HashMap<>();

        static {
            pairs.put(')', '(');
            pairs.put('}', '{');
            pairs.put(']', '[');
        }

        public boolean isValid(String s) {

            Deque<Character> characterDeque = new LinkedList<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                switch (s.charAt(i)) {
                    case ')':
                    case '}':
                    case ']':
                        if (characterDeque.pollLast() != pairs.get(c)) {
                            return false;
                        }
                        break;
                    default:
                        characterDeque.add(c);
                }
            }
            return characterDeque.isEmpty();
        }
    }
}
