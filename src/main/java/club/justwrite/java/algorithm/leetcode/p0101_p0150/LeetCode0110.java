package club.justwrite.java.algorithm.leetcode.p0101_p0150;

import club.justwrite.java.algorithm.leetcode.TreeNode;

import club.justwrite.java.base.io.Printer;

/**
 * @author ACC
 * @desc
 * @create 2020/8/17
 **/
public class LeetCode0110 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Printer.print(solution.isBalanced2(TreeNode.generate(3, 9, 20, null, null, 15, 7)));
        Printer.print(solution.isBalanced2(TreeNode.generate(1, 2, 2, 3, 3, null, null, 4, 4)));
    }

    static class Solution {
        public boolean isBalanced(TreeNode root) {
            if (root == null) return true;
            return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
        }

        private int height(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return Math.max(height(root.left) + 1, height(root.right) + 1);
        }

        public boolean isBalanced2(TreeNode root) {
            return height2(root) != -1;
        }

        private int height2(TreeNode root) {
            if (root == null) return 0;

            int leftHeight = height2(root.left);
            int rightHeight = height2(root.right);

            if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
                return -1;
            } else {
                return Math.max(leftHeight, rightHeight) + 1;
            }
        }
    }
}