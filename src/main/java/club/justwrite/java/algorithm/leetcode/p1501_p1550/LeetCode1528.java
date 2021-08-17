package club.justwrite.java.algorithm.leetcode.p1501_p1550;

import club.justwrite.java.base.io.Printer;

/**
 * @author ACC
 * @desc
 * @create 2020/10/26
 **/
public class LeetCode1528 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Printer.print(solution.restoreString("codeleet", new int[]{4, 5, 6, 7, 0, 2, 1, 3}));
    }

    static class Solution {
        public String restoreString(String s, int[] indices) {
            char[] chars = new char[indices.length];

            int index = 0;
            for (int indice : indices) {
                chars[indice] = s.charAt(index++);
            }

            return String.valueOf(chars);
        }
    }
}