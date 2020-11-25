package club.justwrite.java.algorithm.leetcode.p0001_p0050;

import club.justwrite.java.io.Printer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author ACC
 * @desc
 * @create 2020/11/20
 **/
public class LeetCode0038 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        for (int i = 1; i < 10; i++) {
            Printer.print(solution.countAndSay(0));

        }
    }

    private static class Solution {
        public String countAndSay(int n) {

            if (n < 1) return "";
            Deque<Character> characterDeque = new LinkedList<>();
            characterDeque.offer('1');
            n--;

            while (n > 0) {
                int size = characterDeque.size();
                int count = 0;

                while (size > 0) {
                    char c = characterDeque.poll();
                    size--;
                    count++;
                    if (size == 0 || c != characterDeque.peek()) {
                        characterDeque.offer((char) (count + '0'));
                        characterDeque.offer(c);
                        count = 0;
                    }
                }

                n--;

            }


            StringBuilder stringBuilder = new StringBuilder();
            while (!characterDeque.isEmpty()) {
                stringBuilder.append(characterDeque.poll());
            }


            return stringBuilder.toString();
        }
    }
}