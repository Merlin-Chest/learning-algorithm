package com.merlin.LinkedList;

import java.util.Stack;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        SingleLinkedList singleLinkedList1 = new SingleLinkedList();
        SingleLinkedList singleLinkedList2 = new SingleLinkedList();
        singleLinkedList1.add(new Node(1));
        singleLinkedList1.add(new Node(3));
        singleLinkedList1.add(new Node(5));
        singleLinkedList1.add(new Node(7));
        singleLinkedList2.add(new Node(3));
        singleLinkedList2.add(new Node(4));
        singleLinkedList2.add(new Node(6));
        singleLinkedList2.add(new Node(8));

        Node merge = mergeList(singleLinkedList1.getHead(), singleLinkedList2.getHead());

        SingleLinkedList singleLinkedList3 = new SingleLinkedList();
        singleLinkedList3.setHead(merge);
        singleLinkedList3.showList();
    }

    //获取到单链表的结点个数（如果是带头结点的链表，不统计头结点）
    public static int getLength(Node head) {
        if (head.next == null) {
            return 0;
        }
        int length = 0;
        Node cur = head.next;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        return length;
    }

    //查找倒数第k个结点
    public static Node findLastIndexNode(Node head, int index) {
        //判断如果链表为空，返回null
        if (head.next == null) {
            return null;
        }
        int length = getLength(head);
        //对length进行较验
        if (index <= 0 || index > length) {
            return null;
        }
        //定义辅助变量，for循环定位到倒数的index
        Node cur = head.next;
        for (int i = 0; i < length - index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    //反转单链表
    public static void reverseList(Node head) {
        if (head.next == null || head.next.next == null) {
            return;
        }

        Node cur = head.next;
        //指向当前结点【cur】的下一个结点
        Node next = null;
        Node reverseHead = new Node(1);
        //从头遍历原来的链表，每经过一个结点，就将其取出，放到reverseHead的最前端
        while (cur != null) {
            next = cur.next; //暂时保存当前结点的下一个结点，后续使用
            cur.next = reverseHead.next; //将cur的下一个结点指向reverseHead的最前端
            reverseHead.next = cur; //将cur连接到reverseHead上
            cur = next; //让cur后移
        }
        //将head的next连接reverseHead.next
        head.next = reverseHead.next;
    }

    //反向打印单链表，不破环原结构
    public static void reversePrint(Node head) {
        if (head.next == null) {
            return;
        }
        Stack<Node> stack = new Stack<Node>();
        Node cur = head.next;
        //将所有结点压入栈
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (stack.size() > 0) {
            System.out.printf("%d\t", stack.pop());
        }
    }

    //合并两个有序链表，合并后依然有序
    public static Node mergeList(Node head1, Node head2) {
        Node cur1 = head1.next;
        Node cur2 = head2.next;
        Node head = new Node(0);
        Node cur = head;
        while (cur1 != null & cur2 != null) {
            if (cur1.value <= cur2.value) {
                cur.next = cur1; //将结点连接到新链表
                cur = cur.next; //cur后移一位
                cur1 = cur1.next; //cur1后移一位
            } else {
                cur.next = cur2; //将结点连接到新链表
                cur = cur.next; //cur后移一位
                cur2 = cur2.next; //cur2后移一位
            }
        }
        if (cur1 != null) {
            cur.next = cur1;
        } else if (cur2 != null) {
            cur.next = cur2;
        }
        return head;
    }
}

//定义SingleLinkedList
class SingleLinkedList {
    //先初始化一个头结点,不存放数据
    private Node head = new Node(0);

    //获取头结点
    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    //显示链表
    public void showList() {
        //先判断链表是否为空
        if (isEmpty()) {
            System.out.println("链表为空");
            return;
        }
        Node temp = head.next;
        while (true) {
            //判断是否到链表最后
            if (temp == null) {
                break;
            }
            System.out.printf("%d\t", temp.value);
            temp = temp.next;
        }
    }

    public boolean isEmpty() {
        return head.next == null;
    }

    //添加结点
    //思路：找到最后结点，把最后结点的next指向node
    public void add(Node node) {
        Node temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = node;
    }

    //插入结点,假使链表的值是顺序的
    public void addByOrder(Node node) {
        //因为是单链表，所以需要找到插入位置的前一个位置
        Node temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (node.value >= temp.next.value) {
                break;
            }
            temp = temp.next;
        }
        //先把temp的next赋给node，然后把temp.next指向node
        node.next = temp.next;
        temp.next = node;
    }

    //删除某个结点
    public void delete(int value) {
        Node temp = head;
        while (true) {
            if (temp.next == null) {
                System.out.println("找不到结点");
                return;
            }
            if (temp.next.value == value) {
                break;
            }
            temp = temp.next;
        }
        temp.next = temp.next.next;
    }

    //更新第n个结点的值
    public void update(int num, int value) {
        Node temp = head;
        int count = 0;
        while (true) {
            count++;
            if (count == num) {
                break;
            }
            temp = temp.next;
        }
        temp.value = value;
    }

}

//定义Node
class Node {
    public int value;
    public Node next;

    public Node(int val) {
        value = val;
    }
}