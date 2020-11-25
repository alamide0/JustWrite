package club.justwrite.java.algorithm.leetcode.p0101_p0150;

import club.justwrite.java.algorithm.leetcode.TreeNode;
import club.justwrite.java.io.Printer;

import java.util.*;

/**
 * @author ACC
 * @desc
 * @create 2020/11/20
 **/
public class LeetCode0107 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Printer.print(solution.levelOrderBottom(TreeNode.generate(3, 2)));
    }

    private static class Solution {
        public List<List<Integer>> levelOrderBottom(TreeNode root) {

            List<List<Integer>> ans = new LinkedList<>();
            Queue<TreeNode> treeNodeDeque = new LinkedList<>();

            if (root != null) {
                treeNodeDeque.offer(root);
            }

            while (!treeNodeDeque.isEmpty()) {
                int size = treeNodeDeque.size();

                List<Integer> curList = new ArrayList<>(size);
                while (size-- > 0) {

                    TreeNode node = treeNodeDeque.poll();
                    curList.add(node.val);
                    if (node.left != null) {
                        treeNodeDeque.offer(node.left);
                    }

                    if (node.right != null) {
                        treeNodeDeque.offer(node.right);
                    }
                }

                ans.add(0, curList);
            }


            return ans;

        }
    }
}