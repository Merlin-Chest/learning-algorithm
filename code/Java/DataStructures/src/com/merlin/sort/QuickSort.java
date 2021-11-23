package com.merlin.sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {5, 3, 6, 1, 9, 10, 2, 6, 8, 3};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    // 快速排序
    public static void quickSort(int[] arr, int left, int rigth) {
        int l = left;// 左下标
        int r = rigth;// 右下标

        // pivot 中轴 的值
        int pivot = arr[(rigth + left) / 2];
        int temp = 0;// temp 临时变量为交换时 引用

        // while目的：
        // 1、让其比 pivot 小的值 放左边
        // 2、让其比 pivot 大的值 放右边
        while (l < r) {// 前提： 左边始终小于右边的值
            // 在pivot 的左边一直找，找到大于等于 pivot值，才退出
            while (arr[l] < pivot) {
                l += 1;// 或l++，不过 后自增似乎效率低，因为最终还是 l=l+1 既 l+=1
            }
            // 在pivot 的右边一直找，找到小于等于pivot值，才退出
            while (arr[r] > pivot) {
                r -= 1;
            }

            // 若 l >= r 则说明 pivot 两边的值已经按照 规则 ：
            // 左边全部小于等于pivot,右边全部大于等于pivot 排列好了(最终结果)
            if (l >= r) {
                break;
            }

            // 交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            // 若交换后发现：arr[l] = arr[pivot] 值相等， 则前移 r--
            if (arr[l] == pivot) {
                r -= 1;
            }
            // 若交换后发现：arr[r] = arr[pivot] 值相等， 则后移 l++
            if (arr[r] == pivot) {
                l += 1;
            }
        }

        // 若 l==r ,则必须 l++，r-- 否则陷入死循环，导致栈溢出
        if (l == r) {
            l += 1;
            r -= 1;
        }

        // 向左递归
        if (left < r)
            quickSort(arr, left, r);
        // 向右递归
        if (rigth > l)
            quickSort(arr, l, rigth);
    }
}