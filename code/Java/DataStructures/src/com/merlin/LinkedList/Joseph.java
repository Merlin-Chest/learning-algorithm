package com.merlin.LinkedList;

public class Joseph {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();

        circleSingleLinkedList.addNodes(5);

        circleSingleLinkedList.countPrint(1, 2, 5);
    }
}

class CircleSingleLinkedList {
    private JNode first = null;

    //给定一个数量，创建一个环形链表
    public void addNodes(int nums) {
        if (nums < 1) {
            System.out.println("nums值不正确");
            return;
        }
        JNode cur = null;
        for (int i = 1; i <= nums; i++) {
            JNode jNode = new JNode(i);
            if (i == 1) {
                first = jNode;
                first.setNext(jNode); //构成环
                cur = first; //cur指向第一个结点
            } else {
                cur.setNext(jNode);
                jNode.setNext(first);
                cur = jNode;
            }
        }
    }

    public boolean isEmpty() {
        return first == null;
    }

    //遍历环形链表
    public void showList() {
        if (isEmpty()) {
            System.out.println("链表为空");
        }
        JNode cur = first;
        while (true) {
            System.out.printf("%d\t", cur.getValue());
            if (cur.getNext() == first) {
                break;
            }
            cur = cur.getNext();
        }
    }

    //根据用户的输入，计算出输出次序
    public void countPrint(int start, int countNum, int nums) {
        if (isEmpty() || start < 1 || start > nums) {
            System.out.println("参数有误");
        }
        //辅助指针
        JNode helper = first;
        //helper最初应指向最后一个结点
        while (true) {
            if (helper.getNext() == first) {
                break;
            }
            helper = helper.getNext();
        }

        //使first和helper移动到开始结点的前一个结点
        for (int i = 0; i < start - 1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }

        //将first和helper同时移动m-1次，除去输出结点，直到剩下一个结点
        while (true) {
            if (helper == first) {
                //最后将最后一个结点输出
                System.out.printf("%d\t", first.getValue());
                break;
            }
            for (int j = 0; j < countNum - 1; j++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            //这时，first结点指向要输出的结点
            System.out.printf("%d\t", first.getValue());
            first = first.getNext();
            helper.setNext(first);
        }

    }
}

class JNode {
    private int value;
    private JNode next;

    public JNode(int val) {
        value = val;
    }

    public JNode getNext() {
        return next;
    }

    public void setNext(JNode next) {
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int val) {
        this.value = val;
    }
}