# 0718 最长重复子数组 Medium
给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。

**示例：**

```
输入：
A: [1,2,3,2,1]
B: [3,2,1,4,7]
输出：3
解释：
长度最长的公共子数组是 [3, 2, 1] 。
```

```java
public class LeetCode0718 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Printer.print(solution.findLength(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7}));
    }

    static class Solution {
        public int findLength(int[] A, int[] B) {
            int m = A.length, n = B.length;
            int[][] table = new int[m + 1][n + 1];
            int res = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    table[i + 1][j + 1] = (A[i] == B[j]) ? table[i][j] + 1 : 0;
                    res = Math.max(res, table[i + 1][j + 1]);
                }
            }
            return res;
        }
    }
}

```