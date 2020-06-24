# 0016 最接近的三数之和
给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。

**示例：**
>输入：nums = [-1,2,1,-4], target = 1  
 输出：2  
 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 
**提示：**
* 3 <= nums.length <= 10^3
* -10^3 <= nums[i] <= 10^3
* -10^4 <= target <= 10^4

双指针方法，这题之前接触过，看 0015 ，这两题的类型一致
```java
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int result = Integer.MAX_VALUE;
        int left, right;
        for (int i = 0; i < nums.length; i++) {
            left = i + 1;
            right = nums.length - 1;
            while (left < right) {
                int t = nums[i] + nums[left] + nums[right] - target;
                if (t == 0) {
                    return target;
                } else if (t > 0) {
                    right--;
                } else {
                    left++;
                }

                if (Math.abs(t) < Math.abs(result)) {
                    result = t;
                }
            }
        }

        return result + target;
    }
}
```