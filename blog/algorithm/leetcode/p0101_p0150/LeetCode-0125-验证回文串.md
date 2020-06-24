# 0125 验证回文串
给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。

**说明：** 本题中，我们将空字符串定义为有效的回文串。

**示例1：**
>输入: "A man, a plan, a canal: Panama"  
 输出: true
 
**示例2：**
>输入: "race a car"  
 输出: false
 
本题不难，直接比较就好了。
 
```java
static class Solution {
    public boolean isPalindrome(String s) {

        int right = s.length() - 1;
        int left = 0;

        while (left < right) {
            char cl, cr;
            
            while (!isIllegalChar(cl = (char) (s.charAt(left) | 32)) && left < right) {
                left++;
            }
            
            while (!isIllegalChar(cr = (char) (s.charAt(right) | 32)) && left < right) {
                right--;
            }

            if (cl != cr) {
                return false;
            }

            left++;
            right--;
        }

        return true;

    }

    private boolean isIllegalChar(char c) {
        return (c >= '0' && c <= '9') || (c >= 'a' && c <= 'z');
    }
}

```