package com.zhgwei.algorithm.sort;

import java.util.Arrays;

public class InsertSort {
    public static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j] < arr[j-1]; j--) {
                SortUtils.swap(arr, j, j-1);
            }
        }
    }

    /**
     * 取消 swap 的改进方法
     * @param arr
     */
    public static void sortOpt(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            int temp = arr[j];
            while (j > 0 && temp < arr[j-1]) {
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = temp;
        }
    }
    public static void main(String[] args) {
        System.out.println(SortUtils.dataChecker(InsertSort::sort, 100_000));
    }
}
