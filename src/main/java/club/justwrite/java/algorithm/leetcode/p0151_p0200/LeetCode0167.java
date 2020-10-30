package club.justwrite.java.algorithm.leetcode.p0151_p0200;

import club.justwrite.java.io.Printer;

/**
 * @author ACC
 * @desc
 * @create 2020/10/26
 **/
public class LeetCode0167 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Printer.print(solution.twoSum(new int[]{2, 7, 11, 15, 23, 25, 26, 34}, 48));
        Printer.print(solution.twoSum(new int[]{2, 7, 11, 15, 23, 25, 26, 34}, 18));
    }

    static class Solution {
        public int[] twoSum(int[] numbers, int target) {
            int start = 0, end = numbers.length - 1;

            while (start < end && numbers[start] + numbers[end] != target) {
                while (numbers[start] + numbers[end] < target) start++;
                while (numbers[start] + numbers[end] > target) end--;
            }


            return new int[]{start + 1, end + 1};
        }
    }
}