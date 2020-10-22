package club.justwrite.java.algorithm.leetcode.p0101_p0150;

import club.justwrite.java.algorithm.leetcode.ListNode;
import club.justwrite.java.algorithm.leetcode.TreeNode;

/**
 * @author ACC
 * @desc
 * @create 2020/7/28
 **/
public class LeetCode0104 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static class Solution {


        public int maxDepth(TreeNode root) {
            MaxValueHolder holder = new MaxValueHolder();
            walk(holder, root, 0);
            return holder.maxValue;
        }

        private void walk(MaxValueHolder valueHolder, TreeNode node, int depth) {
            if (node == null) {
                return;
            }

            valueHolder.maxValue = Math.max(valueHolder.maxValue, depth + 1);
            walk(valueHolder, node.left, depth + 1);
            walk(valueHolder, node.right, depth + 1);
        }

        private static class MaxValueHolder {
            int maxValue;
        }
    }


}