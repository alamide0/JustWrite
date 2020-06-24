# 0201 数字范围按位与
给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，返回此范围内所有数字的按位与（包含 m, n 两端点）。

**示例1：**
>输入: [5,7]  
 输出: 4

**示例2：**
>输入: [0,1]  
 输出: 0
 
最初一看题目惊呆了，什么？这么简单，直接 for 循环 逐个数字按位与就好了。很不出意外的超时了。
后面仔细想想确实做了很多无谓的计算

举个例子

m=3, n=100000

3 & 4 = 11 & 100 = 0

后面的所有数都不用比了，结果就为 0

**推广**

m 的二进制为 xxxx

则只要在 (m, n) 的区间内找到一个数的二进制为

10000

则结果必然为 0 

下面来写代码

```java
class Solution {

    public static final int[] TAGS = new int[31];

    static {
        TAGS[0] = 0;
        TAGS[1] = 2;
        for (int i = 2; i < TAGS.length; i++) {
            TAGS[i] = TAGS[i - 1] << 1;
        }
    }


    public int rangeBitwiseAnd(int m, int n) {
        int res = m;

        for (int num : TAGS) {
            if (num >= m + 1 && num < n + 1) {
                return 0;
            }
        }

        for (int i = m; i <= n; i++) {
            res &= i;
            if (res == 0) {
                return 0;
            }

            if(i == Integer.MAX_VALUE){
                break;
            }
        }

        return res;
    }
}
```