package com.ac.p1;

import java.util.Arrays;

/**
 * 简单排序：选择排序
 */
public class Code01_SelectionSort {

    public static void selectionSort(int arr[]) {
        if (arr == null || arr.length < 2)
            return;
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;   //最小值下标
            for (int j = i; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr, i, minIndex);
        }
    }

    public static void swap(int arr[], int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    //测试代码
    public static void main(String[] args) {
        int[] arr = {2, 3, 6, 0, 2, 1, 0, 32, 32, 999,1};
        System.out.println(Arrays.toString(arr));
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
