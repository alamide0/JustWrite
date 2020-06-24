### 字符串的排列
给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。

换句话说，第一个字符串的排列之一是第二个字符串的子串。

**示例1：**

输入: s1 = "ab" s2 = "eidbaooo"\
输出: True\
解释: s2 包含 s1 的排列之一 ("ba").

**示例2：**

输入: s1= "ab" s2 = "eidboaoo"\
输出: False

**注意**

1. 输入的字符串只包含小写字母
2. 两个字符串的长度都在 [1, 10,000] 之间

本题如果列举字符串的每一个排列再比较，那就比较恐怖了。可以统计字符数，字符数相同则必定有一个排列是符合要求的。

```java
static class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) return false;
        if (s1.length() == s2.length() && s1.equals(s2)) return true;

        int[] array1 = new int[26];
        int[] array2 = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            array1[s1.charAt(i) - 'a']++;
            array2[s2.charAt(i) - 'a']++;
        }

        if (equals(array1, array2)) return true;
        for (int i = 0; i < s2.length() - s1.length(); i++) {

            array2[s2.charAt(i) - 'a']--;
            array2[s2.charAt(s1.length() + i) - 'a']++;
            if (equals(array1, array2)) {
                return true;
            }
        }

        return false;
    }

    private boolean equals(int[] array1, int[] array2) {
        for (int i = 0; i < 26; i++) {
            if (array1[i] != array2[i]) {
                return false;
            }
        }
        return true;
    }
}
```