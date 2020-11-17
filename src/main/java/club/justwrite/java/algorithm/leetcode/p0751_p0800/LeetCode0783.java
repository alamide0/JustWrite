package club.justwrite.java.algorithm.leetcode.p0751_p0800;

import club.justwrite.java.algorithm.leetcode.TreeNode;
import club.justwrite.java.io.Printer;

/**
 * @author ACC
 * @desc 错误
 * @create 2020/10/29
 **/
public class LeetCode0783 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Printer.print(solution.minDiffInBST(TreeNode.generate(90, 69, null, 49, 89, null, 52, null, null, null, null)));
    }

    private static class Solution {

        private int prev;
        private boolean hasSet = false;

        public int minDiffInBST(TreeNode root) {
            hasSet = false;
            int[] res = new int[]{Integer.MAX_VALUE};
            dfs(root, res);

            return res[0];
        }

        private void dfs(TreeNode root, int[] res) {
            if (root == null) return;

            dfs(root.left, res);

            if (!hasSet) {
                hasSet = true;
            } else {
                res[0] = Math.min(Math.abs(prev - root.val), res[0]);
            }

            prev = root.val;
            dfs(root.right, res);
        }
    }
}