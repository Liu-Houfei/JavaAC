package com.ac.util;

import java.util.Arrays;

/**
 * 对数器：
 * 随机产生数组
 * 检查结果正确性
 */
public class GA {
    private long testTime;
    private long maxSize;
    private long maxValue;

    public GA(long maxSize, long maxValue) {
        this.maxSize = maxSize;
        this.maxValue = maxValue;
    }

    public int[] generateRandomIntegerArray() {
        int[] arr = new int[(int) ((this.maxSize + 1) * Math.random())];    //长度随机
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) ((maxValue) * Math.random());
        }
        return arr;
    }

    public boolean resultAnalysis(int arr1[], int arr2[]) {
        if (arr1.length != arr2.length)
            return false;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr1[i])
                return false;
        }
        return true;
    }

    public int[] copy(int arr[]) {
        if (arr == null)
            return null;
        int[] tmp = Arrays.copyOf(arr, arr.length);
        return tmp;
    }
}
