package com.merlin.stack;

public class Calculator {
    public static void main(String[] args) {
        String expression = "30+2*50-4";
        CalculatorStack numStack = new CalculatorStack(10);
        CalculatorStack operaStack = new CalculatorStack(10);
        int index = 0; //扫描
        int num1 = 0;
        int num2 = 0;
        int operator = ' ';
        int res = 0;
        char ch = ' '; //每次扫描的结果
        String keepNum = "";
        //扫描表达式
        while (true) {
            ch = expression.substring(index, index + 1).charAt(0);
            if (operaStack.isOperator(ch)) {
                if (!operaStack.isEmpty()) {
                    if (operaStack.priority(operaStack.getTop()) >= operaStack.priority(ch)) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        operator = operaStack.pop();
                        res = operaStack.cal(num1, num2, (char) operator);
                        numStack.push(res);
                    }
                    operaStack.push(ch);
                } else {
                    operaStack.push(ch);
                }
            } else {

                keepNum += ch;

                if (index == expression.length() - 1) {
                    numStack.push(ch - 48);
                } else {
                    if (operaStack.isOperator(expression.substring(index + 1, index + 2).charAt(0))) {
                        numStack.push(Integer.parseInt(keepNum));
                        keepNum = "";
                    }
                }
            }
            index++;
            if (index >= expression.length()) {
                break;
            }
        }

        //计算表达式
        while (true) {
            if (operaStack.isEmpty()) {
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            operator = operaStack.pop();
            res = operaStack.cal(num1, num2, (char) operator);
            numStack.push(res);
        }
        System.out.printf(expression + " = " + numStack.pop());
    }
}


class CalculatorStack {
    private final int maxSize; //栈的大小
    private final int[] stack; //存储数据
    private int top = -1; //栈顶

    public CalculatorStack(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new int[maxSize];
    }

    public int priority(char operator) {
        if (operator == '*' || operator == '/') {
            return 1;
        } else if (operator == '+' || operator == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    //是否是操作符
    public boolean isOperator(int val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    //计算方法
    public int cal(int num1, int num2, char operator) {
        int res = 0;
        switch (operator) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1; //注意数据
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;//注意顺序
                break;
            default:
                break;
        }
        return res;
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

    public char getTop() {
        return (char) stack[top];
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
