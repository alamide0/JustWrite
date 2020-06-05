### [两数相加](../../src/main/java/club/justwrite/java/algorithm/LeetCode0002.java)
给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

*示例：*
> 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)\
> 输出：7 -> 0 -> 8\
> 原因：342 + 465 = 807

*思路：*
就直接相加就好了，好久没接触算法题，脑子有点不灵活了，，，

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode result = new ListNode(0);

            ListNode head = result;
            int extra = 0;
            while (true) {

                if (l1 == null) {
                    result.val = l2.val + extra;
                    l2 = l2.next;
                } else if (l2 == null) {
                    result.val = l1.val + extra;
                    l1 = l1.next;
                } else {
                    result.val = l1.val + l2.val + extra;
                    l1 = l1.next;
                    l2 = l2.next;
                }

                if (result.val >= 10) {
                    extra = 1;
                    result.val -= 10;
                } else {
                    extra = 0;
                }

                if (l1 == null && l2 == null) {
                    if (extra > 0) {
                        result.next = new ListNode(extra);
                    }
                    break;
                }

                result.next = new ListNode(0);
                result = result.next;
            }

            return head;
        }
}
```