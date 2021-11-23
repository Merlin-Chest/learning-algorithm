package com.merlin.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ShellSort {
    public static void main(String[] args) {
        int[] arr = new int[80000];

        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 800000);
        }

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat1.format(date1);
        System.out.println("排序前时间：" + date1Str);

        shellSort2(arr);

        Date date2 = new Date();
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date2Str = simpleDateFormat1.format(date2);
        System.out.println("排序后时间：" + date2Str);
    }

    //交换法
    public static void shellSort(int[] arr) {
        int temp = 0;
        //获取gap:步长，组数
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //gap初始位置为第一个组的第二个元素，gap每加1，切换一个组
            for (int i = gap; i < arr.length; i++) {
                //向前比较，比较范围不断扩大，直到整个组
                for (int j = i - gap; j >= 0; j -= gap) {
                    //如果当前元素大于加上步长后的那个元素，说明交换
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
        }
    }

    //插入法
    public static void shellSort2(int[] arr) {
        //获取步长
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //从第gap个元素，逐个对齐所在的组进行直接插入排序
            for (int i = gap; i < arr.length; i++) {
                //当前要插入元素的下标和值
                int index = i;
                int value = arr[index];
                if (arr[index] < arr[index - gap]) {
                    while (index - gap >= 0 && arr[index] < arr[index - gap]) {
                        arr[index] = arr[index - gap];
                        index -= gap;
                    }
                    //找到位置，跳出循环,赋值
                    arr[index] = value;
                }
            }
        }
    }
}
