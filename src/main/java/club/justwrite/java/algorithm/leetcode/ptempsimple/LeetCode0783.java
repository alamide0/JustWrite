package club.justwrite.java.algorithm.leetcode.ptempsimple;

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
        public int minDiffInBST(TreeNode root) {
            int[] res = new int[]{Integer.MAX_VALUE};
            dfs(root.left, root.val, res);
            dfs(root.right, root.val, res);

            return res[0];
        }

        private void dfs(TreeNode root, int parentVal, int[] res) {
            if (root == null) return;

            dfs(root.left, root.val, res);
            Printer.print(root.val + ", " + parentVal);
            res[0] = Math.min(Math.abs(parentVal - root.val), res[0]);
            dfs(root.right, root.val, res);
        }
    }
}
