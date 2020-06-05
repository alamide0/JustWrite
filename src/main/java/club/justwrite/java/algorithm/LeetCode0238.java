package club.justwrite.java.algorithm;

import club.justwrite.java.io.Printer;

/**
 * @author ACC
 * @desc
 * @create 2020/6/4 11:05 AM
 **/
public class LeetCode0238 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Printer.print(solution.productExceptSelf(new int[]{1, 2, 3, 4}));
    }

    static class Solution {


        public int[] productExceptSelf(int[] nums) {
            int length = nums.length;
            int[] L = new int[length];
            int[] R = new int[length];

            L[0] = 1;

            for (int i = 1; i < nums.length; i++) {
                L[i] = nums[i - 1] * L[i - 1];
            }

            R[length - 1] = 1;

            for (int i = length - 2; i >= 0; i--) {
                R[i] = R[i + 1] * nums[i + 1];
            }

            int[] result = new int[length];

            for (int i = 0; i < length; i++) {
                result[i] = R[i] * L[i];
            }

            return result;
        }
    }
}
