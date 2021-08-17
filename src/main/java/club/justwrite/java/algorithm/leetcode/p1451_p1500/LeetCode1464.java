package club.justwrite.java.algorithm.leetcode.p1451_p1500;

import club.justwrite.java.base.io.Printer;

/**
 * @author ACC
 * @desc
 * @create 2020/8/14
 **/
public class LeetCode1464 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Printer.print(solution.maxProduct(new int[]{3, 4, 5, 2}));
        Printer.print(solution.maxProduct(new int[]{1, 4, 5, 5}));
        Printer.print(solution.maxProduct(new int[]{3, 7}));
    }

    static class Solution {
        public int maxProduct(int[] nums) {
            int firstN = -1, secondN = -1;

            for (int n : nums) {
                if (n > firstN) {
                    if (firstN > secondN) {
                        secondN = firstN;
                    }
                    firstN = n;
                    continue;
                }

                if (n > secondN) {
                    secondN = n;
                }
            }

            return (firstN - 1) * (secondN - 1);
        }
    }
}