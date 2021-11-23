package com.merlin.sort;

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {53, 3, 542, 748, 14, 214};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //基数排序法
    public static void radixSort(int[] arr) {

        //计算数组中最大数的位数
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        //得到最大数是几位数
        int maxLength = (max + "").length();
        int[][] bucket = new int[10][arr.length];

        //为了记录每个桶，存储每个桶的数量
        int[] bucketElementCounts = new int[10];

        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {

            for (int j = 0; j < arr.length; j++) {
                //取出每个元素的对应位的值
                int digitOfElement = arr[j] / n % 10;
                //放进对应的桶，然后对应 数量++
                bucket[digitOfElement][bucketElementCounts[digitOfElement]++] = arr[j];
            }

            int index = 0;
            for (int k = 0; k < bucketElementCounts.length; k++) {
                if (bucketElementCounts[k] > 0) {
                    //如果桶中有数据，才放入原数组
                    for (int t = 0; t < bucketElementCounts[k]; t++) {
                        //取元素放入arr
                        arr[index++] = bucket[k][t];
                    }
                }
                //第i+1轮处理完之后，需要清0
                bucketElementCounts[k] = 0;
            }
        }
    }

}
