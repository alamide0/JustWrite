# 0005 最长回文子串
给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

**示例1：**
>输入: "babad"  
 输出: "bab"  
 注意: "aba" 也是一个有效答案。
 
**示例2：**
>输入: "cbbd"  
 输出: "bb"
 
本题耗时较长，主要是边界处理的不好，以后做题，要先理清思路，再写代码。

```java
class Solution {

    public String longestPalindrome(String s) {
        if (s.length() == 0) return s;

        DataHolder dataHolder = new DataHolder();
        for (int i = 0; i < s.length() - 1; i++) {
            if ((i > 0 && s.charAt(i - 1) == s.charAt(i + 1))) {
                walk(dataHolder, s, i - 1, i + 1);
            }

            if (s.charAt(i) == s.charAt(i + 1)) {
                walk(dataHolder, s, i, i + 1);
            }
        }

        return s.substring(dataHolder.start, dataHolder.end + 1);
    }

    private void walk(DataHolder holder, String s, int left, int right) {

        int t = right - left == 1 ? (holder.maxLength - 2) / 2 : (holder.maxLength - 3) / 2;

        if (t >= 0 && (left - t < 0 || right + t > s.length() - 1 || s.charAt(left - t) != s.charAt(right + t))) {
            return;
        }

        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }
            if (holder.maxLength < right - left + 1) {
                holder.maxLength = right - left + 1;
                holder.end = right;
                holder.start = left;
            }
            left--;
            right++;
        }
    }

    private class DataHolder {
        int start;
        int end;
        int maxLength;
    }

}
```