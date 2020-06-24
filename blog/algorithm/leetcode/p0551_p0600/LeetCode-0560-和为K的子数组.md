# 0560 和为 K 的子数组
给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。

**示例1：**
>输入:nums = [1,1,1], k = 2  
 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 
**说明：**
>1. 数组的长度为 [1, 20,000]。  
>2. 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。

本题最开始的时候一直想的是动态规划，但是最后发现 nums 中的数可以为负数，浪费了一些时间，所以审题很重要。
我使用的是暴力求解，因为本题"需要穷举"所有的子串，所以使用的暴力求解法。效率有点低，推荐使用官方的题解。

****

有一点很奇怪，官方的暴力求解是从后向前，我的是从前向后，但是耗时却有一定差距。我统计了执行的次数，显示的结果是完全一致的，很奇怪。

```java
static class Solution {
    @MainMethod
    public int subarraySum(int[] nums, int k) {
        int res = 0, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    res++;
                }
            }
//官方的暴力求解
//          for (int j = i; j >= 0; j--) {
//              sum += nums[j];
//              if (sum == k) {
//                  res++;
//              }
//          }
        }
        return res;
    }
}

//官方的题解思路
static class Solution2 {
    @MainMethod
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int res = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int value = sum - k;

            res += map.getOrDefault(value, 0);

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return res;
    }
}
```