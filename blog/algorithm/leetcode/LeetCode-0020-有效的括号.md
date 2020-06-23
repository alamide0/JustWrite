# 0020 有效的括号
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

有效字符串需满足：
1. 左括号必须用相同类型的右括号闭合。
2. 左括号必须以正确的顺序闭合。

注意空字符串可被认为是有效字符串。

**示例1：**
>输入: "()"  
 输出: true
 
**示例2：**
>输入: "()[]{}"  
输出: true

**示例3：**
>输入: "(]"  
 输出: false
 
**示例4：**
>输入: "([)]"  
 输出: false
 
**示例5：**
>输入: "{[]}"  
 输出: true
 
简单，使用栈就好了

```java
class Solution {

    private static final Map<Character, Character> pairs = new HashMap<>();

    static {
        pairs.put(')', '(');
        pairs.put('}', '{');
        pairs.put(']', '[');
    }

    public boolean isValid(String s) {

        Deque<Character> characterDeque = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (s.charAt(i)) {
                case ')':
                case '}':
                case ']':
                    if (characterDeque.pollLast() != pairs.get(c)) {
                        return false;
                    }
                    break;
                default:
                    characterDeque.add(c);
            }
        }
        
        return characterDeque.isEmpty();
    }
}
```