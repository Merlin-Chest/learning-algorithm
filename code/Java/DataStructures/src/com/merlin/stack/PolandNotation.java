package com.merlin.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {
    public static void main(String[] args) {
        List<String> InfixExpressList = toInfixExpression("1+((2+5)*6+1)*4");
        System.out.println(InfixExpressList);
        List<String> parseSuffixExpression = parseSuffixExpressList(InfixExpressList);
        System.out.println(parseSuffixExpression);
        System.out.println(calculator(parseSuffixExpression));
    }

    public static List<String> toInfixExpression(String s) {
        List<String> list = new ArrayList<>();
        int i = 0; // 指针
        String str; //对多位数拼接
        char c;
        do {
            //不是数字
            if (!isNumber(c = s.charAt(i))) {
                list.add(c + "");
                i++;
            } else {
                //数字
                str = "";
                while (i < s.length() && isNumber(c = s.charAt(i))) {
                    str += c;
                    i++;
                }
                list.add(str);
            }
        } while (i < s.length());
        return list;
    }

    public static boolean isNumber(char ch) {
        return ch >= 48 && ch <= 57;
    }

    public static List<String> getListString(String suffixExpression) {
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<>();
        for (String ele : split) {
            list.add(ele);
        }
        return list;
    }

    public static int calculator(List<String> list) {
        Stack<String> stack = new Stack<>();
        for (String e : list) {
            if (e.matches("\\d+")) {
                //匹配多位数
                stack.push(e);
            } else {
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if (e.equals("+")) {
                    res = num1 + num2;
                } else if (e.equals("-")) {
                    res = num1 - num2;
                } else if (e.equals("*")) {
                    res = num1 * num2;
                } else if (e.equals("/")) {
                    res = num1 / num2;
                } else {
                    throw new RuntimeException("运算符有误");
                }
                stack.push("" + res);
            }
        }
        return Integer.parseInt(stack.pop());
    }

    public static int priority(char operator) {
        if (operator == '*' || operator == '/') {
            return 1;
        } else if (operator == '+' || operator == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    public static List<String> parseSuffixExpressList(List<String> list) {
        Stack<String> stack1 = new Stack<>();
        //因为整个过程中 s2没有pop操作，而且后续需要对其逆序输出，所以我们不用stack,直接使用list
        List<String> stack2 = new ArrayList<>();
        char c;
        for (String e : list) {
            if (e.matches("\\d+")) {
                //数字
                stack2.add(e);
            } else if (e.equals("(")) {
                //左括号
                stack1.push(e);
            } else if (e.equals(")")) {
                //右括号
                while (!stack1.peek().equals("(")) {
                    stack2.add(stack1.pop());
                }
                stack1.pop(); //消除“（”
            } else {
                //普通符号
                while (stack1.size() != 0 && priority(e.charAt(0)) <= priority(stack1.peek().charAt(0))) {
                    stack2.add(stack1.pop());
                }
                stack1.push(e);
            }
        }
        //将s1剩余的符号依次弹出压入s2
        while (stack1.size() != 0) {
            stack2.add(stack1.pop());
        }
        return stack2;
    }
}
