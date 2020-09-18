package com.zhgwei.algorithm.sort;

import java.util.Arrays;

public class InsertSort {
    public static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j-1]) {
                    SortUtils.swap(arr, j, j-1);
                } else {
                    break;
                }
            }
        }
    }

    public static void sortOpt(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            for (int j = i, flag = 1; j >= 0 && flag != 0; j--) {
                if (j == 0 || temp >= arr[j-1]) {
                    arr[j] = temp;
                    flag = 0;
                } else {
                    arr[j] = arr[j-1];
                }
            }
        }
    }
    public static void main(String[] args) {
        boolean flag = true;
        for (int i = 0; i< 50000; i++) {
            int[] arr = SortUtils.genIntRandomArray();
            int[] arrTest = Arrays.copyOf(arr, arr.length);

            Arrays.sort(arr);
            sortOpt(arrTest);

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
