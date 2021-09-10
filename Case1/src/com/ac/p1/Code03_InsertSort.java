package com.ac.p1;

import com.ac.util.GA;
import org.junit.Test;

import java.util.Arrays;

/**
 * 简单排序：直接插入排序
 * O(n^2)
 */
public class Code03_InsertSort {

    public static void InsertSort1(int arr[]) {
        if (arr == null || arr.length < 2)
            return;
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > arr[j + 1]) { //逆序交换
                    swap(arr, j, j + 1);
                } else { //不出现逆序，结束
                    break;
                }
            }
        }
    }

    public static void InsertSort2(int arr[]) {
        if (arr == null || arr.length < 2)
            return;
        for (int i = 1; i < arr.length; i++) {  //0~i做到有序
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                //两种结束情况：（1）j >= 0 到达边界；（2）arr[j] > arr[j + 1] 如果出现正序就结束
                swap(arr, j, j + 1);
            }
        }
    }

    public static void swap(int arr[], int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    @Test
    public void test_InsertSort() {
//        int[] arr = {1, 3, 2, 0, 2, 1, 0, 32, 32, 999, 1};
//        System.out.println(Arrays.toString(arr));
//        InsertSort2(arr);
//        System.out.println(Arrays.toString(arr));

        //使用对数器
        GA ga = new GA(100000, 100000);
        int[] arr1 = ga.generateRandomIntegerArray();
        int[] arr2 = ga.copy(arr1);
        //多线程测试
        Thread t1 = new Thread(() -> {
            InsertSort2(arr1);
        }, "t1");
        t1.start();
        Thread t2 = new Thread(() -> {
            Arrays.sort(arr2);
        }, "t2");
        t2.start();
        Thread t3 = new Thread(() -> {
            try {
                t1.join();
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(ga.resultAnalysis(arr1, arr2) ? "AC" : "ERROR");
        }, "t3");
        t3.start();
        try {
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
