package com.merlin.stack;

public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(5);
        arrayStack.push(1);
        arrayStack.push(4);
        arrayStack.push(5);
        arrayStack.push(2);
        arrayStack.push(3);
        arrayStack.list();
        arrayStack.pop();
        arrayStack.pop();
        arrayStack.pop();
        arrayStack.list();
    }
}

class ArrayStack {
    private final int maxSize; //栈的大小
    private final int[] stack; //存储数据
    private int top = -1; //栈顶

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new int[maxSize];
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(int val) {
        if (isFull()) {
            System.out.println("栈满");
            return;
        }
        stack[++top] = val;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        }
        return stack[top--];
    }

    public void list() {
        if (isEmpty()) {
            System.out.println("栈空");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("%d\t", stack[i]);
        }
        System.out.println();
    }
}
