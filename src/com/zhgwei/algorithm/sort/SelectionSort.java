package com.zhgwei.algorithm.sort;

import java.util.Arrays;
import java.util.function.Consumer;

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

    /**
     * 选择排序优化版本, 同时记录最大值和最小值, 最小值与第一个数交换, 最大值与最后一个数交换
     * @param arr
     */
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
            // 注意在最大值交换前有可能已经被最小值交换
            if (maxi == i) {
                maxi = mini;
            }
            SortUtils.swap(arr, len-1 - i, maxi);
        }
    }

    public static void main(String[] args) {
        System.out.println(SortUtils.dataChecker(SelectionSort::sort, 5000));
    }
}
