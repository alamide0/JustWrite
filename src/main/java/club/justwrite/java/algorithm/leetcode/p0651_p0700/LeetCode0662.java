package club.justwrite.java.algorithm.leetcode.p0651_p0700;

import club.justwrite.java.algorithm.leetcode.ListNode;
import club.justwrite.java.algorithm.leetcode.TreeNode;

import club.justwrite.java.io.Printer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ACC
 * @desc
 * @create 2020/8/14
 **/
public class LeetCode0662 {

    public static void main(String[] args) {
        TreeNode root = TreeNode.generate(1, 1, 1, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null,
                1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1,
                null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, 1, null, null, 1, 1, null, 1, null, 1, null, 1, null, 1, null);

        Printer.print(new Solution().widthOfBinaryTree(root));
    }


    static class Solution {

        private Map<Integer, Integer> left = new HashMap<>();
        private int width;

        public int widthOfBinaryTree(TreeNode root) {
            dfs(root, 0, 0);
            return width;
        }

        private void dfs(TreeNode treeNode, int depth, int position) {

            if (treeNode == null) return;
            left.putIfAbsent(depth, position);

            width = Math.max(width, position - left.get(depth) + 1);

            dfs(treeNode.left, depth + 1, 2 * position);
            dfs(treeNode.right, depth + 1, 2 * position + 1);
        }
    }
}