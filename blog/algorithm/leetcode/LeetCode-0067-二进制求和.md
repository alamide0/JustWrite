# 0067 二进制求和
给你两个二进制字符串，返回它们的和（用二进制表示）。

输入为 非空 字符串且只包含数字 1 和 0。

**示例1：**
>输入: a = "11", b = "1"  
 输出: "100"
 
**示例2：**
>输入: a = "1010", b = "1011"  
 输出: "10101"
 
简单题

```java
class Solution {
    public String addBinary(String a, String b) {

        int[] nums = new int[Math.max(a.length(), b.length()) + 1];
        int index = -1;

        int extra = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; ) {
            index++;
            if (i == -1) {
                nums[index] = b.charAt(j) + extra - '0';
                j--;
            } else if (j == -1) {
                nums[index] = a.charAt(i) + extra - '0';
                i--;
            } else {
                nums[index] = a.charAt(i) + b.charAt(j) + extra - '0' - '0';
                i--;
                j--;
            }

            if (nums[index] > 1) {
                nums[index] -= 2;
                extra = 1;
            } else {
                extra = 0;
            }
        }

        if (extra != 0) {
            nums[++index] = 1;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = index; i >= 0; i--) {
            stringBuilder.append(nums[i]);
        }

        return stringBuilder.toString();
    }
}
```