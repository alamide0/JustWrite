package club.justwrite.java.algorithm.leetcode.p0001_p0050;

/**
 * @author ACC
 * @desc
 * @create 2020/11/27
 **/
public class LeetCode0011 {

    public static void main(String[] args) {

    }

    private static class Solution {
        public int maxArea(int[] height) {
            if (height.length < 2) return 0;
            int left, leftIndex = 0;
            int right, rightIndex = height.length - 1;

            int max = 0;
            while (leftIndex < rightIndex) {
                left = height[leftIndex];
                right = height[rightIndex];
                max = Math.max(max, (rightIndex - leftIndex) * Math.min(left, right));

                if (left < right) {
                    leftIndex++;
                } else {
                    rightIndex--;
                }
            }

            return max;
        }
    }
}