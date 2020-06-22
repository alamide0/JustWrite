# 0003 无重复字符的最长子串
给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

**示例1：**
>输入: "abcabcbb"  
 输出: 3   
 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。  
 
**示例2：**
>输入: "bbbbb"  
 输出: 1  
 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。  
 
**示例3：**
>输入: "pwwkew"  
 输出: 3  
 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 
直接遍历就好了
```java
static class Solution {
    @MainMethod
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int length = 0;
        int max = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {

            int index = map.getOrDefault(s.charAt(i), -1);

            if (index >= start) {//说明有重复了，更新数据
                int tmp = map.get(s.charAt(i));
                length -= tmp - start;
                start = tmp + 1;
            } else {
                length++;
            }

            if (length > max) {
                max = length;
            }

            map.put(s.charAt(i), i);
        }

        return max;
    }
}

```
 