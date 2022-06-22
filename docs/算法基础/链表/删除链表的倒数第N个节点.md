# 删除链表的倒数第N个节点

[力扣题目链接](https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/)

给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。

进阶：你能尝试使用一趟扫描实现吗？

示例 1：

![19.删除链表的倒数第N个节点](https://img-blog.csdnimg.cn/20210510085957392.png)

输入：head = [1,2,3,4,5], n = 2 输出：[1,2,3,5] 示例 2：

输入：head = [1], n = 1 输出：[] 示例 3：

输入：head = [1,2], n = 1 输出：[1]

```js
var removeNthFromEnd = function(head, n) {
    // 创建虚拟结点
    head = new ListNode(0,head);
    let node = head;
    // 先走n步
    while(n--){
        node = node.next;
    }
    // 新增一个指针，走到尾，会中len - n步
    let pre = head;
    // 走到最后一个就应该停下来，要是pre停在删除结点的前一个结点
    while(node.next){
        node = node.next;
        pre = pre.next;
    }
    // 删除结点
    pre.next = pre.next.next;
    return head.next;
};
```