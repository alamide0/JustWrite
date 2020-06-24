### 三数之和
给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。

注意：答案中不可以包含重复的三元组。

**示例：**
```
给定数组 nums = [-1, 0, 1, 2, -1, -4]，

满足要求的三元组集合为：
[
  [-1, 0, 1],
  [-1, -1, 2]
]
```

本题主要是需要注意超时问题，思路是先排序，再解决去重问题，我的算法耗时有点长。最开始使用的二分查找在剩下的
数组中搜寻第三个数，后改良为使用 HashMap 缓存，耗时减少了一半左右。但是还是较慢，看到一个好的算法，双指针算法，耗时只有我的一半。

```java
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
           Arrays.sort(nums);
            Map<Integer, Integer> map = new HashMap<>(nums.length);
            int count =0;
            for (int n : nums) {
                map.put(n, count++);
            }
//            Printer.print(nums);
            List<List<Integer>> result = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) break;
                if (i > 0 && nums[i] == nums[i - 1]) continue;
                for (int j = i + 1; j < nums.length; j++) {
                    if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                    int temp = nums[i] + nums[j];
                    if (temp > 0) break;
                    if (temp + nums[nums.length - 1] < 0) continue;
                    if (map.get(-temp) != null &&  map.get(-temp)> j) {
                        result.add(Arrays.asList(nums[i], nums[j], -temp));
                    }
                }
            }

            return result;
        

    }
}
```
