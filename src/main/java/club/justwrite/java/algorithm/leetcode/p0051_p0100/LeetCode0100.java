package club.justwrite.java.algorithm.leetcode.p0051_p0100;

import club.justwrite.java.algorithm.leetcode.TreeNode;

/**
 * @author ACC
 * @desc
 * @create 2020/11/17
 **/
public class LeetCode0100 {

    public static void main(String[] args) {

    }

    private static class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if (p == null && q == null) return true;

            if (p == null || q == null) return false;

            if (p.val != q.val) return false;

            if (!isSameTree(p.left, q.left)) {
                return false;
            }

            return isSameTree(p.right, q.right);
        }
    }
}