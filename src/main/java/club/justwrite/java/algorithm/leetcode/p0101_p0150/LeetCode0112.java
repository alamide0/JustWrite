package club.justwrite.java.algorithm.leetcode.p0101_p0150;

import club.justwrite.java.algorithm.leetcode.TreeNode;
import club.justwrite.java.io.Printer;

/**
 * @author ACC
 * @desc
 * @create 2020/11/19
 **/
public class LeetCode0112 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Printer.print(solution.hasPathSum(TreeNode.generate(), 0));
    }

    private static class Solution {
        public boolean hasPathSum(TreeNode root, int sum) {
            if (root == null) return false;
            if (root.val == sum && root.left == root.right) return true;
            return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
        }
    }
}