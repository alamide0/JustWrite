package club.justwrite.java.algorithm.leetcode.ptempsimple;

import club.justwrite.java.io.Printer;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ACC
 * @desc
 * @create 2020/10/27
 **/
public class LeetCode1502 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Printer.print(solution.canMakeArithmeticProgression(new int[]{3, 5, 1}));
        Printer.print(solution.canMakeArithmeticProgression(new int[]{4, 5, 1}));
        Printer.print(solution.canMakeArithmeticProgression(new int[]{1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25, 3}));
        Printer.print(solution.canMakeArithmeticProgression(new int[]{5, 5, 5, 5, 5, 5, 5}));
    }

    static class Solution {
        public boolean canMakeArithmeticProgression(int[] arr) {
            Set<Integer> integerSet = new HashSet<>();

            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;

            for (int n : arr) {
                if (n > max) max = n;
                if (n < min) min = n;
                integerSet.add(n);
            }

            if (integerSet.size() == 1) return true;

            if (arr.length != integerSet.size()) return false;

            int dx = (max - min) / (arr.length - 1);
            if (dx * (arr.length - 1) != (max - min)) return false;
            for (int i = 0; i < arr.length; i++) {
                if (!integerSet.contains(min + dx * i)) return false;
            }

            return true;
        }
    }
}
