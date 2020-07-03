package club.justwrite.java.algorithm.leetcode.p0501_p0550;

import club.justwrite.java.io.Printer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ACC
 * @desc
 * @create 2020/6/28
 **/
public class LeetCode0515 {


    public static void main(String[] args) {
        TreeNode node0 = new TreeNode(1);

        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);

        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(9);

        node0.left = node1;
        node0.right = node2;

        node1.left = node3;
        node1.right = node4;

        node2.right = node5;

        Printer.print(new Solution().largestValues(node0));
    }

    static class Solution {
        public List<Integer> largestValues(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            walkTree(root, 1, res);
            return res;
        }

        private void walkTree(TreeNode node, int level, List<Integer> res) {
            if (node == null) return;

            if (level > res.size()) {
                res.add(node.val);
            } else {
                res.set(level - 1, Math.max(node.val, res.get(level - 1)));
            }

            walkTree(node.left, level + 1, res);
            walkTree(node.right, level + 1, res);
        }

    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}