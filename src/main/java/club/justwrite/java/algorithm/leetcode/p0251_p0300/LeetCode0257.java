package club.justwrite.java.algorithm.leetcode.p0251_p0300;

import club.justwrite.java.algorithm.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author ACC
 * @desc
 * @create 2020/11/24
 **/
public class LeetCode0257 {

    public static void main(String[] args) {

    }

    private static class Solution {
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> paths = new ArrayList<String>();
            dfs(root,  paths, "");
            return paths;
        }

        private void dfs(TreeNode root, List<String> ans, String tmp) {
            if (root == null) {
                return;
            }

            StringBuffer stringBuffer = new StringBuffer(tmp);
            stringBuffer.append(Integer.toString(root.val));
            if (root.left == null && root.right == null) {
                ans.add(stringBuffer.toString());
            } else {
                stringBuffer.append("->");
                dfs(root.left, ans, stringBuffer.toString());
                dfs(root.right, ans, stringBuffer.toString());
            }


        }


    }
}