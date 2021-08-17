package club.justwrite.java.algorithm.leetcode.p0451_p0500;

import club.justwrite.java.base.io.Printer;

import java.util.*;

/**
 * @author ACC
 * @desc
 * @create 2020/8/13
 **/
public class LeetCode0451 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Printer.print(solution.frequencySort("tree"));
        Printer.print(solution.frequencySort("cccaaa"));
        Printer.print(solution.frequencySort("Aabb"));
        Printer.print(solution.frequencySort("Aabb"));
    }

    static class Solution {
        public String frequencySort(String s) {

            int[] chars = new int[128];

            for (char c : s.toCharArray()) {
                chars[c]++;
            }

            Queue<Character> queue = new PriorityQueue<>((o1, o2) -> chars[o2] - chars[o1]);

            for (int i = 0; i < chars.length; i++) {
                if (chars[i] > 0) queue.offer((char) i);
            }

            StringBuilder res = new StringBuilder();

            while (!queue.isEmpty()) {
                char c = queue.poll();
                while (chars[c]-- > 0) {
                    res.append(c);
                }
            }

            return res.toString();
        }


    }
}