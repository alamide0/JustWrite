### [两数之和](../../src/main/java/club/justwrite/java/algorithm/LeetCode0001.java)
给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。

#### 示例：
>给定 nums = [2, 7, 11, 15], target = 9\
 因为 nums[0] + nums[1] = 2 + 7 = 9\
 所以返回 [0, 1]
 
 本题利用空间换取时间，把每次计算的结果保存下来，可以降低时间复杂度。
 
 ```java
static class Solution {
        public int[] twoSum(int[] nums, int target) {
            int count = 0;
            Map<Integer, Integer> cache = new HashMap<>();//缓存
            for (int n : nums) {
                if (cache.containsKey(n)) {
                    return new int[]{cache.get(n), count};
                } else {
                    cache.put(target - n, count++);
                }
            }
            return new int[]{};
        }
}
```
