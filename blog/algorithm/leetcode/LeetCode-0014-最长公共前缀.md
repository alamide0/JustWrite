# 最长公共前缀
编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 ""。

**示例1：**
>输入: ["flower","flow","flight"]  
 输出: "fl"
 
**示例2：**
>输入: ["dog","racecar","car"]  
 输出: ""  
 解释: 输入不存在公共前缀。
 
我的算法笔较简单，直接按序排查，速度较慢。官方的二分查找方法，速度是我的一半。

```java
static class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        if(strs.length == 1) return strs[0];
        for (int i = 0; ; i++) {
            if (i >= strs[0].length()) {
                return strs[0];
            }
            char now = strs[0].charAt(i);
            for (String s : strs) {
                if (i >= s.length()) {
                    return s;
                }
                if (now != s.charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
    }
}
```