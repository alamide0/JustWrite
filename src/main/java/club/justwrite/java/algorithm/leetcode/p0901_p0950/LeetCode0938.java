package club.justwrite.java.algorithm.leetcode.p0901_p0950;

import club.justwrite.java.algorithm.leetcode.TreeNode;
import club.justwrite.java.io.Printer;

/**
 * @author ACC
 * @desc 慢
 * @create 2020/10/29
 **/
public class LeetCode0938 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Printer.print(solution.rangeSumBST(TreeNode.generate(10, 5, 15, 3, 7, null, 18), 7, 15));
        Printer.print(solution.rangeSumBST(TreeNode.generate(10, 5, 15, 3, 7, 13, 18, 1, null, 6), 6, 10));
    }

    static class Solution {
        public int rangeSumBST(TreeNode root, int L, int R) {
            return dfs(root, L, R);
        }

        private int dfs(TreeNode root, int start, int end) {

            if (root == null) {
                return 0;
            }


            if (root.val < start) {
                return dfs(root.right, start, end);
            } else if (root.val > end) {
                return dfs(root.left, start, end);
            } else {
                int sum = dfs(root.left, start, end) + dfs(root.right, start, end);
                return root.val + sum;
            }

        }
    }
}