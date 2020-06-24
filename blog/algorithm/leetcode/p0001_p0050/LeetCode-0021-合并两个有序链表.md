# 0021 合并两个有序链表
将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。

**示例：**
>输入：1->2->4, 1->3->4  
 输出：1->1->2->3->4->4
 
```java
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode res = new ListNode();

        ListNode header = res;
        while (true) {

            if (l1.val < l2.val) {
                res.val = l1.val;
                l1 = l1.next;
            } else {
                res.val = l2.val;
                l2 = l2.next;
            }

            if (l1 == null) {
                res.next = l2;
                break;
            }

            if (l2 == null) {
                res.next = l1;
                break;
            }

            res.next = new ListNode();
            res = res.next;
        }

        return header;
    }
}


public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode listNode(int... ints) {
        ListNode listNode = new ListNode();
        ListNode header = listNode;

        for (int i = 0; i < ints.length; i++) {
            listNode.val = ints[i];
            if (i != ints.length - 1) {
                listNode.next = new ListNode();
                listNode = listNode.next;
            }
        }

        return header;
    }

}
```