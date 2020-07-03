# 0415 字符串相加
给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。

**注意：**

1. num1 和num2 的长度都小于 5100.
2. num1 和num2 都只包含数字 0-9.
3. num1 和num2 都不包含任何前导零。
4. 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。

简单题

```java
public class LeetCode0415 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Printer.print(solution.addStrings("9", "1"));
        Printer.print(solution.addStrings("999999", "1"));
        Printer.print("10000000009".length());
    }

    static class Solution {
        public String addStrings(String num1, String num2) {
            StringBuilder res = new StringBuilder();
            int extra = 0;
            int i = num1.length() - 1, j = num2.length() - 1;
            while (i >= 0 || j >= 0) {
                Printer.print(i + ", " + j);
                int n1 = i < 0 ? 0 : num1.charAt(i) - '0';
                int n2 = j < 0 ? 0 : num2.charAt(j) - '0';

                int t = n1 + n2 + extra;
                if (t > 9) {
                    res.append(t - 10);
                    extra = 1;
                } else {
                    res.append(t);
                    extra = 0;
                }
                i--;
                j--;
            }

            return extra == 1 ? res.append(1).reverse().toString() : res.reverse().toString();
        }
    }
}

```