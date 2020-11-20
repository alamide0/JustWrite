package club.justwrite.java.algorithm.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author ACC
 * @desc
 * @create 2020/8/14
 **/
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }


    public static TreeNode generate(Integer... ns) {

        if (ns.length == 0) return null;

        int size = 0;

        Deque<TreeNode> treeNodeDeque = new LinkedList<>();
        TreeNode root = new TreeNode(ns[size++]);
        treeNodeDeque.offer(root);

        while (!treeNodeDeque.isEmpty() && size < ns.length) {
            TreeNode node = treeNodeDeque.poll();
            Integer left = ns[size++];
            if (left != null) {
                node.left = new TreeNode(left);
                treeNodeDeque.offer(node.left);
            }
            if (size >= ns.length) break;

            Integer right = ns[size++];
            if (right != null) {
                node.right = new TreeNode(right);
                treeNodeDeque.offer(node.right);
            }
            if (size >= ns.length) break;

        }
        return root;
    }
}
