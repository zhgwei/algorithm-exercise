package com.zhgwei.algorithm.sort;

import java.util.Arrays;

/**
 * TODO
 * @author zhgwei
 * @date 2020-09-14
 */
public class BubbleSort {
    public static void sort(int[] arr) {
        for (int i = arr.length; i > 1; i--) {
            boolean flag = true;
            for (int j = 1; j < i; j++) {
                if (arr[j-1] > arr[j]) {
                    SortUtils.swap(arr, j-1, j);
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        boolean flag = true;
        for (int i = 0; i< 50000; i++) {
            int[] arr = SortUtils.genIntRandomArray();
            int[] arrTest = Arrays.copyOf(arr, arr.length);

            Arrays.sort(arr);
            sort(arrTest);

            flag = SortUtils.checkSame(arr, arrTest);
            if (!flag) {
                System.out.println("failed");
                break;
            }
        }
        if (flag) {
            System.out.println("success");
        }
    }
}
