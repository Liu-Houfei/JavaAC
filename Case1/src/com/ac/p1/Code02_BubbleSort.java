package com.ac.p1;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class Code02_BubbleSort {
    public static void bubbleSort(int arr[]) {
        if (arr == null || arr.length < 2)
            return;
/*
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = false;   //判断某一次是否发生交换，如果没有交换则结束排序
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    flag = true;
                }
            }
            if (!flag)
                return;
        }
*/
        //倒着写会更好理解
        for (int e = arr.length - 1; e > 0; e--) {
            boolean flag = false;
            for (int j = 0; j < e; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    flag = true;
                }
            }
            if (!flag)
                return;
        }

    }

    public static void swap(int arr[], int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    //测试代码
    public static void main(String[] args) {
        int[] arr = {2, 3, 6, 0, 2, 1, 0, 32, 2, 1, 999};
        System.out.println(Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
