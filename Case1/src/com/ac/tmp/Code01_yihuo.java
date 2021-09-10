package com.ac.tmp;

import org.junit.Test;

public class Code01_yihuo {

    /**
     * 问题1：在一个数组中，一种树出现了奇数次，其他数出现了偶数次，求这个出现了奇数次的数
     */
    public static void printOddTimesNum1(int arr[]) {
        int eor = 0;
        for (int cur : arr) {
            eor ^= cur;
        }
        System.out.println(eor);
    }

    @Test
    public void test_f1() {
        int[] arr = {2, 1, 3, 1, 3, 1, 3, 2, 1};
        printOddTimesNum1(arr);
    }

    /**
     * 问题2：两种数出现了奇数次，其他数出现了偶数次
     */
    public static void printOddTimesNum2(int arr[]) {
        //设两种奇数次的数为 a 和 b
        int eor = 0;
        for (int cur : arr) {
            eor ^= cur;
        }//eor=a^b

        //取eor最右侧为1的数（固定套路）
        int rightOne = eor & (~eor + 1);

        int onlyOne = 0;  //eor'
        for (int cur : arr) {
            /*
            此处判断可以是：等于rightOne（筛出第i位为1的） ，等于0（筛出第i位为0的），
            大于等于1（筛出第i位为1的）。就是不能等于1
            */
            if ((cur & rightOne) == 0) {
                onlyOne ^= cur;
            }
        }//onlyOne = a 或者 b

        System.out.println(onlyOne + "，" + (eor ^ onlyOne));    //eor^onlyOne 就可以得到另一个数
    }

    @Test
    public void test_printOddTimesNum2() {
        int[] arr = {2, 1, 3, 1, 3, 1, 3, 2, 1, 1};
        printOddTimesNum2(arr);
    }
}


