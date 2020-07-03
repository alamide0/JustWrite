package club.justwrite.java.algorithm.leetcode.p0101_p0150;

import club.justwrite.java.io.Printer;

import java.util.ArrayDeque;

/**
 * @author ACC
 * @desc
 * @create 2020/7/3
 **/
public class LeetCode0108 {


    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode treeNode = solution.sortedArrayToBST(new int[]{0, 1, 2, 3, 4, 5,});

        walkTreeNodeBFS(treeNode);
    }

    private static void walkTreeNodeBFS(TreeNode treeNode) {
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(treeNode);
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();

            System.out.print(node.val + " ");

            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }

            System.out.println();

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

    static class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            if (nums.length == 0) return null;
            int middle = nums.length / 2;
            int rootValue = nums[middle];
            TreeNode root = new TreeNode(rootValue);

            insertMiddle(root, 0, middle, nums);

            insertMiddle(root, middle + 1, nums.length, nums);

            return root;
        }

        private void insertMiddle(TreeNode root, int start, int end, int[] nums) {
            if (start < end) {
                int middle = (start + end) / 2;
                TreeNode node = insertToTree(root, nums[middle]);

                insertMiddle(node, start, middle, nums);
                insertMiddle(node, middle + 1, end, nums);
            }
        }

        private TreeNode insertToTree(TreeNode treeNode, int value) {
            while (true) {
                if (value < treeNode.val) {
                    if (treeNode.left == null) {
                        treeNode.left = new TreeNode(value);
                        return treeNode.left;
                    } else {
                        treeNode = treeNode.left;
                    }
                } else {
                    if (treeNode.right == null) {
                        treeNode.right = new TreeNode(value);

                        return treeNode.right;
                    } else {
                        treeNode = treeNode.right;
                    }
                }
            }
        }
    }
}


