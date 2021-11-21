package com.merlin.recursion;

public class Queue8 {

    //定义一个max表示一共有多少个皇后
    int max = 8;
    //下标表示第几行（第几个皇后），值表示第几列
    int[] array = new int[max];
    int count = 0;
    int judgeCount = 0;

    public static void main(String[] args) {
        Queue8 queue8 = new Queue8();
        queue8.check(0);
        System.out.printf("一共有%d种解法\n", queue8.count);
        System.out.printf("判断冲突有%d次", queue8.judgeCount);
    }

    private void check(int n) {
        if (n == max) {
            print();
            return;
        }
        //依次放入皇后，判断是否冲突
        for (int i = 0; i < max; i++) {
            //先把当前这个皇后n，放到该行的第一列
            array[n] = i;
            if (judge(n)) {
                check(n + 1);
            }
            //如果冲突，没有关系，就继续执行array[n] = i,即把皇后n后移一位
        }
    }

    //查看当我们放置第n个皇后，就去检测该皇后是否和前面已经摆放的皇后冲突
    //n表示第n个皇后
    private boolean judge(int n) {
        judgeCount++;
        for (int i = 0; i < n; i++) {
            //同一列 || 同一斜线（行列差值是否一样）
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }

    //将皇后摆法打印出来
    private void print() {
        count++;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "");
        }
        System.out.println();
    }
}
