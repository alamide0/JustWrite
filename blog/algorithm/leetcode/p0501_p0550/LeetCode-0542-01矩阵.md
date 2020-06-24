### 01矩阵
给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。

两个相邻元素间的距离为 1 。

**示例1：**

输入：

>0 0 0\
 0 1 0\
 0 0 0
 
输出：
>0 0 0\
 0 1 0\
 0 0 0
 
**示例2：**

输入：
>0 0 0\
 0 1 0\
 1 1 1
 
输出：
>0 0 0\
 0 1 0\
 1 2 1
 
**注意：**
1. 给定矩阵的元素个数不超过 10000。
2. 给定矩阵中至少有一个元素是 0。
3. 矩阵中的元素只在四个方向上相邻: 上、下、左、右。

本题使用动态规划来解决问题，由已知的推导出未知的。由于相邻方向有四个方向，所以我分两次遍历矩阵(左下，右上)，这样每次只需要关注两个方向且这两个方向的结果都是已知的。取两次遍历的
最小值即可。
```java
static class Solution {
        public int[][] updateMatrix(int[][] matrix) {

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (matrix[i][j] != 0) {
                        int min = 10001;
                        //左侧探索
                        if (j - 1 >= 0) {
                            if (matrix[i][j - 1] == 0) {
                                matrix[i][j] = 1;
                                continue;
                            } else {
                                if (min > matrix[i][j - 1] + 1) {
                                    min = matrix[i][j - 1] + 1;
                                }
                            }
                        }

                        //上侧探索
                        if (i - 1 >= 0) {
                            if (matrix[i - 1][j] == 0) {
                                matrix[i][j] = 1;
                                continue;
                            } else {
                                if (min > matrix[i - 1][j] + 1) {
                                    min = matrix[i - 1][j] + 1;
                                }
                            }

                        }

                        matrix[i][j] = min;
                    }
                }
            }

            for (int i = matrix.length - 1; i >= 0; i--) {
                for (int j = matrix[0].length - 1; j >= 0; j--) {
                    if (matrix[i][j] != 0) {
                        //右侧探索
                        if (j + 1 < matrix[0].length) {
                            if (matrix[i][j + 1] == 0) {
                                matrix[i][j] = 1;
                            } else {
                                if (matrix[i][j] > matrix[i][j + 1] + 1) {
                                    matrix[i][j] = matrix[i][j + 1] + 1;
                                }
                            }
                        }

                        //下侧探索
                        if (i + 1 < matrix.length) {
                            if (matrix[i + 1][j] == 0) {
                                matrix[i][j] = 1;
                            } else {
                                if (matrix[i][j] > matrix[i + 1][j] + 1) {
                                    matrix[i][j] = matrix[i + 1][j] + 1;
                                }
                            }
                        }

                    }
                }
            }


            return matrix;
        }
}
```