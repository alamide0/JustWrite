package club.justwrite.java.algorithm.leetcode;

import club.justwrite.java.io.Printer;

/**
 * @author ACC
 * @desc
 * @create 2020/8/21
 **/
public class LeetCode0111 {

    public static void main(String[] args) {
        LeetCode0111 leetCode0111 = new LeetCode0111();
        Printer.print(leetCode0111.new Solution().minDepth(TreeNode.generate(3, 9, 20, null, null, 15, 7)));
    }

    class Solution {

        private int minHeight = Integer.MAX_VALUE;

        public int minDepth(TreeNode root) {
            if (root == null) return 0;
            walk(root, 1);
            return minHeight;
        }

        private void walk(TreeNode root, int height) {

            if (root == null) return;

            if (root.right == null && root.left == null) {
                minHeight = Math.min(minHeight, height);
            }

            walk(root.left, height + 1);
            walk(root.right, height + 1);
        }
    }
}
