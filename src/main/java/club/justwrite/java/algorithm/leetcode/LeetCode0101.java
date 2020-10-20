package club.justwrite.java.algorithm.leetcode;

import club.justwrite.java.io.Printer;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author ACC
 * @desc
 * @create 2020/8/18
 **/
public class LeetCode0101 {

    public static void main(String[] args) {
        Solution solution = new Solution();
//        Printer.print(solution.isSymmetric(TreeNode.generate(1, 2, 2, 3, 4, 4, 3)));
//        Printer.print(solution.isSymmetric(TreeNode.generate(1, 2, 2, null, 3, null, 3)));
        Printer.print(solution.isSymmetric(TreeNode.generate(1, 2, 3)));
    }

    static class Solution {

        public boolean isSymmetric(TreeNode root) {
            return check(root, root);
        }

        private boolean check(TreeNode left, TreeNode right) {
            if (left == null && right == null) {
                return true;
            }

            if (left == null || right == null) {
                return false;
            }

            return left.val == right.val && check(left.right, right.left) && check(left.left, right.right);
        }
    }
}
