package club.justwrite.java.algorithm.leetcode.p0101_p0150;

import club.justwrite.java.algorithm.leetcode.TreeNode;
import club.justwrite.java.base.io.Printer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ACC
 * @desc
 * @create 2020/10/27
 **/
public class LeetCode0144 {

    public static void main(String[] args) {
        Solution solution = new Solution();

        Printer.print(solution.preorderTraversal(TreeNode.generate(1, null, 2, 3)));
    }

    static class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> res = new LinkedList<>();
            if (root == null) return res;
            Deque<TreeNode> stack = new LinkedList<>();

            TreeNode node = root;

            while (!stack.isEmpty() || node != null) {

                while (node != null) {
                    res.add(node.val);
                    stack.push(node);
                    node = node.left;
                }


                node = stack.pop();
                node = node.right;
            }

            return res;
        }
    }
}