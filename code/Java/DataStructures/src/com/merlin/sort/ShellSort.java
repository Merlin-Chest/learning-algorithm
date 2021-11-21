package com.merlin.sort;

public class ShellSort {
    public static void main(String[] args) {

    }

    public static void shellSort(int[] arr) {
        int temp = 0;
        //gap:步长，组数
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                //遍历各组所有元素（共gap组，每组有 arr.length / gap 个元素），步长为gap
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
}
