package club.justwrite.java.algorithm.leetcode.p0401_p0450;

import club.justwrite.java.algorithm.leetcode.TreeNode;

/**
 * @author ACC
 * @desc
 * @create 2020/11/24
 **/
public class LeetCode0404 {

    public static void main(String[] args) {

    }

    private static class Solution {

        private int sum = 0;

        public int sumOfLeftLeaves(TreeNode root) {
            sum = 0;
            dfs(root, null);
            return sum;
        }

        private void dfs(TreeNode root, TreeNode parent) {
            if (root == null) return;

            if (root.left == null && root.right == null && (parent == null || parent.left == root)) {
                sum += root.val;
            }

            dfs(root.left, root);
            dfs(root.right, root);
        }
    }
}