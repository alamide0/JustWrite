package club.justwrite.java.algorithm.leetcode.p0101_p0150;

import club.justwrite.java.algorithm.leetcode.TreeNode;
import club.justwrite.java.base.io.Printer;

/**
 * @author ACC
 * @desc
 * @create 2020/10/29
 **/
public class LeetCode0129 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Printer.print(solution.sumNumbers(TreeNode.generate(1, 2, 3)));
        Printer.print(solution.sumNumbers(TreeNode.generate(4, 9, 0, 5, 1)));
    }

    private static class Solution {
        public int sumNumbers(TreeNode root) {
            return dfs(root, 0);
        }

        private int dfs(TreeNode root, int sum) {
            if (root == null) return 0;

            int prevSum = sum * 10 + root.val;

            if (root.left == null && root.right == null) {
                return prevSum;
            }

            return dfs(root.left, prevSum) + dfs(root.right, prevSum);
        }

    }
}