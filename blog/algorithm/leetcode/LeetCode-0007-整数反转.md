# 0007 整数反转
给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。

**示例1：**
>输入: 123  
 输出: 321

**示例2：**
>输入: -123  
 输出: -321
 
**示例3：**
>输入: 120  
 输出: 21
 
**注意：**
假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。

本题我最初解决溢出的解法是 把 res 的类型定义为 long，运算的效率不够理想，不可取。后查看官方的题解，在判断边界，虽然比我的运算多，但是总的耗时
少了一半。下面给出官方的思路，

```java
class Solution {
    public int reverse(int x) {
        int res = 0, t1 = Integer.MAX_VALUE / 10, t2 = Integer.MIN_VALUE / 10;
        while (x != 0) {
            int mod = x % 10;
            if (res > t1 || (res == t1 && mod > 7)) return 0;
            if (res < t2 || (res == t2 && mod < -8)) return 0;
            res = res * 10 + mod;
            x /= 10;
        }
        return res;
    }
}
```