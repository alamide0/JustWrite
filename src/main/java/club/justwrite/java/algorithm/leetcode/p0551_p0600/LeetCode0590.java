package club.justwrite.java.algorithm.leetcode.p0551_p0600;

import club.justwrite.java.algorithm.leetcode.ListNode;
import club.justwrite.java.algorithm.leetcode.TreeNode;

import club.justwrite.java.io.Printer;

import java.util.*;

/**
 * @author ACC
 * @desc
 * @create 2020/8/21
 **/
public class LeetCode0590 {


    public static void main(String[] args) {
        List<Integer> list = null;

        for (Integer integer : list) {
            Printer.print(integer);
        }
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    ;


    class Solution {
        public List<Integer> postorder(Node root) {
            List<Integer> res = new ArrayList<>();
            dfs(root, res);
            return res;
        }

        private void dfs(Node root, List<Integer> res) {
            if (root == null) return;
            if (root.children != null) {
                for (Node node : root.children) {
                    dfs(node, res);
                }
            }

            res.add(root.val);
        }
    }
}