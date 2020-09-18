package com.zhgwei.algorithm.sort;

import java.util.Arrays;

/**
 * 选择排序 O(n^2)
 * @author zhgwei
 * @date 2020-09-14
 */
public class SelectionSort {

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int mini = i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[j] < arr[mini]) {
                    mini = j;
                }
            }
            SortUtils.swap(arr, i, mini);
        }
    }

    public static void sortOpt(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len/2; i++) {
            int mini = i;
            int maxi = i;
            for (int j = i + 1; j < len-i; j++) {
                if (arr[j] < arr[mini]) {
                    mini = j;
                }
                if (arr[j] > arr[maxi]) {
                    maxi = j;
                }
            }
            SortUtils.swap(arr, i, mini);
            if (maxi == i) {
                maxi = mini;
            }
            SortUtils.swap(arr, len -1 - i, maxi);
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
