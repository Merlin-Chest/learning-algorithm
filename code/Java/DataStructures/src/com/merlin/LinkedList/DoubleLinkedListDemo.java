package com.merlin.LinkedList;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(new DoubleNode(1));
        doubleLinkedList.add(new DoubleNode(3));
        doubleLinkedList.add(new DoubleNode(5));
        doubleLinkedList.add(new DoubleNode(7));

        doubleLinkedList.addByOrder(new DoubleNode(4));

        doubleLinkedList.showList();
    }
}

class DoubleLinkedList {
    private static DoubleNode head = new DoubleNode(0);

    public static DoubleNode getHead() {
        return head;
    }

    public static void setHead(DoubleNode newhead) {
        head = newhead;
    }

    public static boolean isEmpty() {
        return head.next == null;
    }

    //显示链表
    public void showList() {
        //先判断链表是否为空
        if (isEmpty()) {
            System.out.println("链表为空");
            return;
        }
        DoubleNode temp = head.next;
        while (true) {
            //判断是否到链表最后
            if (temp == null) {
                break;
            }
            System.out.printf("%d\t", temp.value);
            temp = temp.next;
        }
    }

    //添加结点
    public void add(DoubleNode node) {
        DoubleNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = node;
        node.pre = temp;
    }

    //插入结点,假使链表的值是顺序的
    public void addByOrder(DoubleNode node) {
        if (isEmpty()) {
            head.next = node;
            node.pre = head;
        }
        DoubleNode temp = head.next;
        while (temp.next != null) {
            if (node.value < temp.next.value) {
                break;
            }
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next.pre = node;
            node.next = temp.next;
        }
        temp.next = node;
        node.pre = temp;
    }

    //删除某个结点
    public void delete(int value) {
        if (isEmpty()) {
            System.out.println("链表为空，无法删除");
        }
        DoubleNode temp = head.next;
        while (true) {
            if (temp == null) {
                System.out.println("找不到结点");
                return;
            }
            if (temp.value == value) {
                break;
            }
            temp = temp.next;
        }
        temp.pre.next = temp.next;
        if (temp.next != null) {
            temp.next.pre = temp.pre;
        }
    }

    //更新第n个结点的值
    public void update(int num, int value) {
        DoubleNode temp = head;
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
class DoubleNode {
    public int value;
    public DoubleNode next;
    public DoubleNode pre;

    public DoubleNode(int val) {
        value = val;
    }
}