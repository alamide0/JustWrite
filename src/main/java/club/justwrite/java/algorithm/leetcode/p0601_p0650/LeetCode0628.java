package club.justwrite.java.algorithm.leetcode.p0601_p0650;

import club.justwrite.java.algorithm.leetcode.ListNode;
import club.justwrite.java.algorithm.leetcode.TreeNode;

import club.justwrite.java.io.Printer;

/**
 * @author ACC
 * @desc
 * @create 2020/10/21
 **/
public class LeetCode0628 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Printer.print(solution.maximumProduct(new int[]{1, 2, 3, 6, 3, 4, 2, 10}));

        Printer.print(solution.maximumProduct(new int[]{1, 2, -3, 0, 3, 4, 2, 10}));

        Printer.print(solution.maximumProduct(new int[]{1, 2, -3, 0, 3, 4, 2, 10, -20}));

        Printer.print(solution.maximumProduct(new int[]{0, 0, -1, 0, 0}));

        Printer.print(solution.maximumProduct(new int[]{-1, -2, -3}));
    }

    static class Solution {
        public int maximumProduct(int[] nums) {
            int min1 = 1001, min2 = 1001;
            int max1 = -1001, max2 = -1001, max3 = -1001;

            for (int n : nums) {
                if (n < min1) {
                    min2 = min1;
                    min1 = n;
                } else if (n < min2) {
                    min2 = n;
                }

                if (n > max3) {
                    max1 = max2;
                    max2 = max3;
                    max3 = n;
                } else if (n > max2) {
                    max1 = max2;
                    max2 = n;
                } else if (n > max1) {
                    max1 = n;
                }
            }

            return Math.max(min1 * min2 * max3, max1 * max2 * max3);
        }
    }
}