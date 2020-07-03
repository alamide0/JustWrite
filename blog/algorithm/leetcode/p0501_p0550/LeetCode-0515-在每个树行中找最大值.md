# 0515 在每个数行中找最大值 Medium
您需要在二叉树的每一行中找到最大的值。

**示例：**

```
输入: 

          1
         / \
        3   2
       / \   \  
      5   3   9 

输出: [1, 3, 9]

```

```java
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
```