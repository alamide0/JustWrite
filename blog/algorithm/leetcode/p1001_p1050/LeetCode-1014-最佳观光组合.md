# 1014 最佳观光组合
给定正整数数组 A，A[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的距离为 j - i。

一对景点（i < j）组成的观光组合的得分为（A[i] + A[j] + i - j）：景点的评分之和减去它们两者之间的距离。

返回一对观光景点能取得的最高分。

**示例：**
>输入：[8,1,5,2,6]  
 输出：11  
 解释：i = 0, j = 2, A[i] + A[j] + i - j = 8 + 5 + 0 - 2 = 11
 
**提示：**
>1. 2 <= A.length <= 50000
>2. 1 <= A[i] <= 1000

本题想明白了就简单，首先不可能暴力求解，绝对超时。思路就是向后遍历，逐步更新已遍历过数据的最大权重值，这样就简单了很多。

```java
static class Solution {
    public int maxScoreSightseeingPair(int[] A) {
        
        int best = A[0];
        int max = A[0];

        for (int i = 1; i < A.length; i++) {
            max = max - 1;

            int tBest = A[i] + max;
            if (tBest > best) {
                best = tBest;
            }

            if (A[i] > max) {
                max = A[i];
            }
        }

        return best;
    }
}
```