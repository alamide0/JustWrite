# 0180 将有序数组转换为二叉搜索树
将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。  

本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。

**示例：**
```
给定有序数组: [-10,-3,0,5,9],

一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：

      0
     / \
   -3   9
   /   /
 -10  5

  ```

本题就是不断的保持当前节点的左右 node 数量相等就行了
  
```java
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
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
```
 
************
 执行结果：
 通过
 显示详情  
 执行用时：
 0 ms
 , 在所有 Java 提交中击败了
 100.00%
 的用户  
 内存消耗：
 39.7 MB
 , 在所有 Java 提交中击败了
 8.70%
 的用户
************