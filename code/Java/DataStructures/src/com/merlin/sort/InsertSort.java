package com.merlin.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

public class InsertSort {
    public static void main(String[] args) {
//        int[] arr = {3, 9, -1, 10, 20};
//        selectSort(arr);
//        System.out.println(Arrays.toString(arr));
        int[] arr = new int[80000];

        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 800000);
        }

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat1.format(date1);
        System.out.println("排序前时间：" + date1Str);

        insertSort(arr);

        Date date2 = new Date();
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date2Str = simpleDateFormat1.format(date2);
        System.out.println("排序后时间：" + date2Str);
    }

    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int insertVal = arr[i]; //存储要插入的值
            int index = i - 1; //待插入的数的前一个数的下标，该数之前的数组已经有序
            while (index >= 0 && arr[index] > insertVal) {
                //将该位置的数后移
                arr[index + 1] = arr[index];
                //继续向前查找
                index--;
            }
            //判断是否需要插入
            if (index + 1 != i) {
                //当退出循环时，说明插入位置已经找到
                arr[index + 1] = insertVal;
            }
        }
    }
}
