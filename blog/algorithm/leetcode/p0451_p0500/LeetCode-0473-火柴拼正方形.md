# 0473 火柴拼正方形
还记得童话《卖火柴的小女孩》吗？现在，你知道小女孩有多少根火柴，请找出一种能使用所有火柴拼成一个正方形的方法。不能折断火柴，可以把火柴连接起来，并且每根火柴都要用到。

输入为小女孩拥有火柴的数目，每根火柴用其长度表示。输出即为是否能用所有的火柴拼成正方形。

**示例1：**  
>输入: [1,1,2,2,2]  
>输出: true
>   
>解释: 能拼成一个边长为2的正方形，每边两根火柴。

**示例2：**
>输入: [3,3,3,3,4]  
>输出: false  
>
>解释: 不能用所有火柴拼成一个正方形。

**注意：**
>1. 给定的火柴长度和在 0 到 10^9之间。  
>2. 火柴数组的长度不超过15。

本题想的有点太多了，一直在考虑是否有"讨巧"的方法，而不是穷举。当想不出有好的算法的时候，穷举就是最好的解法。看了官方的题解，原来
这就叫做深度遍历 dfs，学习了。这里要注意一个细节，这个题目反向深度遍历是一种更优的解法，在有解的情况下，会消耗更少的计算次数。

```java
static class Solution {

    private int w;
    private int[] sum = new int[4];
    private int[] nums;

    private boolean dfs(int index) {

        if (index == -1) {
            return (sum[0] == w && sum[1] == w && sum[2] == w && sum[3] == w);
        }

        for (int i = 0; i < 4; i++) {
            if (sum[i] + nums[index] <= w) {
                sum[i] += nums[index];
                if (dfs(index - 1)) {
                    return true;
                }
                sum[i] -= nums[index];
            }
        }
        return false;
    }

    public boolean makesquare(int[] nums) {

        if (nums.length < 4) return false;
        int sum = 0;

        for (int n : nums) {
            sum += n;
        }

        w = sum / 4;
        if (w * 4 != sum) return false;
        Arrays.sort(nums);

        if (nums[nums.length - 1] > w) return false;

        this.nums = nums;

        return dfs(nums.length - 1);
    }
}
```