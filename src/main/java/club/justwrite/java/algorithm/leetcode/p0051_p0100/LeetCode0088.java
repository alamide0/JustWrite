package club.justwrite.java.algorithm.leetcode.p0051_p0100;

/**
 * @author ACC
 * @desc
 * @create 2020/10/26
 **/
public class LeetCode0088 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.merge(new int[]{1, 2, 3, 4, 0, 0, 0, 0}, 4, new int[]{1, 1, 2, 5}, 4);
        solution.merge(new int[]{1, 2, 0, 0}, 2, new int[]{0, 5}, 2);
        solution.merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
    }

    static class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int i = m + n - 1;
            int index1 = m - 1, index2 = n - 1;
            while (i >= 0) {
                while (index1 >= 0 && (index2 < 0 || nums1[index1] > nums2[index2])) nums1[i--] = nums1[index1--];
                while (index2 >= 0 && (index1 < 0 || nums1[index1] <= nums2[index2])) nums1[i--] = nums2[index2--];
            }
        }
    }
}