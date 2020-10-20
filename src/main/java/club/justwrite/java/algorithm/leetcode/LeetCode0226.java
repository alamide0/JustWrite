package club.justwrite.java.algorithm.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author ACC
 * @desc
 * @create 2020/8/13
 **/
public class LeetCode0226 {

    public static void main(String[] args) {

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static class Solution {
        public TreeNode invertTree(TreeNode root) {
            Deque<TreeNode> queue = new LinkedList<>();

            queue.push(root);

            while (!queue.isEmpty()) {
                TreeNode node = queue.pop();

                TreeNode tmp = node.left;
                node.left = node.right;
                node.right = tmp;

                if (node.left != null) {
                    queue.push(node.left);
                }

                if (node.right != null) {
                    queue.push(node.right);
                }

            }

            return root;
        }
    }
}
