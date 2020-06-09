### 找到数组中消失的数字
给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。

找到所有在 [1, n] 范围之间没有出现在数组中的数字。

您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。

**示例：**
>输入:\
> [4,3,2,7,8,2,3,1]\
> 输出:\
> [5,6]

以空间换取时间，速度较快
```java
static class Solution {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            int[] result = new int[nums.length + 1];
            List<Integer> list = new LinkedList<>();
            Arrays.fill(result, 0);

            for (int n : nums) {
                result[n] = 1;
            }

            int index = 0;
            for (int n : result) {
                if (n == 0 && index > 0) {
                    list.add(index);
                }
                index++;
            }

            return list;
        }
}

```

把数字交换到合适的位置，官方的思路好一点，遍历过程中把相应的位置标记为负数，速度比我的算法快一点点，但是只快了一点点
```java
static class Solution {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            List<Integer> list = new LinkedList<>();
            int times = 0;
            for (int i = 0; i < nums.length; ) {
                if (times > nums.length) {
                    break;
                }
                if (nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]) {
                    int tmp = nums[nums[i] - 1];
                    nums[nums[i] - 1] = nums[i];
                    nums[i] = tmp;
                    times++;
                } else {
                    i++;
                }
            }
            int index = 0;
            for (int n : nums) {
                if (index++ != n - 1) {
                    list.add(index);
                }
            }

            return list;
        }
}
```