package club.justwrite.java.algorithm.leetcode.p0201_p0250;

import club.justwrite.java.algorithm.leetcode.TreeNode;
import club.justwrite.java.base.io.Printer;

/**
 * @author ACC
 * @desc
 * @create 2020/11/24
 **/
public class LeetCode0222 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Printer.print(solution.countNodes(TreeNode.generate(1, 2, 3, 4, 5, 6)));
    }

    private static class Solution {

        public int countNodes(TreeNode root) {
            if (root == null) return 0;
            int depth = 0;
            TreeNode node = root;

            while (node != null) {
                depth++;
                node = node.left;
            }

            int left = 1 << (depth - 1), right = (1 << depth) - 1;


            while (left < right) {
                int middle = (right - left + 1) / 2 + left;

                if (isExist(root, depth, middle)) {
                    left = middle;
                } else {
                    right = middle - 1;
                }
            }

            return left;
        }

        private boolean isExist(TreeNode root, int level, int bits) {
            int tmp = 1 << (level - 2);
            TreeNode node = root;

            while (node != null && tmp != 0) {


                if ((bits & tmp) == 0) {
                    node = node.left;
                } else {
                    node = node.right;
                }

                tmp = tmp >> 1;
            }


            return node != null;
        }
    }
}