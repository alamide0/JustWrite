### [顺时针打印矩阵](../../src/main/java/club/justwrite/java/algorithm/LeetCode0029.java)
输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。

*示例1：*
> 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]\
> 输出：[1,2,3,6,9,8,7,4,5]

*示例2：*
>输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]\
>输出：[1,2,3,4,8,12,11,10,9,5,6,7]

*限制：*
* 0 <= matrix.length <= 100
* 0 <= matrix[i].length <= 100

自己写了个很矬的算法，我称之为探索算法，每行进一步需要监测当前位置的数据是否被遍历过。在这道题中，这个算法简直是个灾难，在确定的规则下再去
检测，完全没有必要。下面给出一个我看社区一个比较好的算法，速度比我的算法快了四倍，很赞。
```java
class Solution {
    public int[] spiralOrder(int[][] matrix) {
            if (matrix.length == 0) return new int[]{};
            int[] result = new int[matrix.length * matrix[0].length];
            int T = 0, R = matrix[0].length - 1, B = matrix.length - 1, L = 0;
            int index = 0;
            while (true) {
                for (int i = L; i <= R; i++) {
                    result[index++] = matrix[T][i];
                }

                if (++T > B) {
                    break;
                }

                for (int i = T; i <= B; i++) {
                    result[index++] = matrix[i][R];
                }

                if (--R < L) {
                    break;
                }

                for (int i = R; i >= L; i--) {
                    result[index++] = matrix[B][i];
                }

                if (--B < T) {
                    break;
                }

                for (int i = B; i >= T; i--) {
                    result[index++] = matrix[i][L];
                }

                if (++L > R) {
                    break;
                }
            }

            return result;
        }
}
```