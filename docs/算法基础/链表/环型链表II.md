# 环型链表II

[力扣题目链接](https://leetcode.cn/problems/linked-list-cycle-ii/)

题意： 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。

为了表示给定链表中的环，使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。

**说明**：不允许修改给定的链表。

![循环链表](https://img-blog.csdnimg.cn/20200816110112704.png)

## 思路

- 判断是否有环
	- 快慢指针,如果有环，会相遇
- 如何找到入口
	- **从头结点出发一个指针，从相遇节点 也出发一个指针，这两个指针每次只走一个节点， 那么当这两个指针相遇的时候就是 环形入口的节点**。
	- 公式推导？？

```js
var detectCycle = function(head) {
    if(!head || !head.next) return null;
    let slow = head.next, fast = head.next.next;
    while(fast && fast.next && fast != slow){
        fast = fast.next.next;
        slow = slow.next;
    }
    if(!fast || !fast.next) return null;
    slow = head;
    while(slow != fast){
        slow = slow.next;
        fast = fast.next;
    }
    return fast;
};
```
