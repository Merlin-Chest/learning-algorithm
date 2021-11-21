package com.merlin.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BubbleSort {
    public static void main(String[] args) {
//        int[] arr = {3, 9, -1, 10, 20};
//        bubbleSort(arr);
//        System.out.println(Arrays.toString(arr));

        int[] arr = new int[80000];

        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 800000);
        }

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat1.format(date1);
        System.out.println("排序前时间：" + date1Str);

        bubbleSort(arr);

        Date date2 = new Date();
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date2Str = simpleDateFormat1.format(date2);
        System.out.println("排序后时间：" + date2Str);
    }

    public static void bubbleSort(int[] arr) {
        int temp = 0; //临时变量
        boolean flag = false; //标识变量，表示是否进行过排序
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            //优化点
            if (!flag) {
                //在一趟排序中。一次交换也没有发生，说明已经有序
                break;
            } else {
                //重置flag，进行下次判断
                flag = false;
            }
        }
    }
}
