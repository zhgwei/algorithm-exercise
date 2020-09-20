package com.zhgwei.algorithm.sort;

import java.util.Arrays;

/**
 * TODO add javadoc for com.zhgwei.algorithm.sort.CountSort
 *
 * @author zhw
 * @date 2020-09-18
 */
public class CountSort {

    /**
     * 计数排序, 不稳定版本
     * @param arr 待排序数组
     */
    public static void sort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }
        int[] range = findRange(arr);
        int[] countArr = new int[range[1]-range[0]+1];

        for (int k : arr) {
            countArr[k - range[0]]++;
        }
        int arri = 0;
        for (int i = 0; i < countArr.length; i++) {
            for (int j = 0; j < countArr[i]; j++) {
                arr[arri] = i+range[0];
                arri++;
            }
        }
    }

    /**
     * 计数排序, 稳定版
     * @param arr 待排序数组
     */
    private static void stableSort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }
        int[] range = findRange(arr);
        int[] arrSorted = new int[arr.length];
        int[] countArr = new int[range[1]-range[0]+1];
        for (int j : arr) {
            countArr[j - range[0]]++;
        }
        for (int i = 1; i < countArr.length; i++) {
            countArr[i] += countArr[i-1];
        }
        for (int i = arr.length-1; i >= 0; i--) {
            int index = countArr[arr[i]-range[0]]-1;
            arrSorted[index] = arr[i];
            countArr[arr[i]-range[0]]--;
        }
        System.arraycopy(arrSorted, 0, arr, 0, arr.length);
    }

    private static int[] findRange(int[] arr) {
        int[] range = {arr[0], arr[0]};

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > range[1]) {
                range[1] = arr[i];
            }
            if (arr[i] < range[0]) {
                range[0] = arr[i];
            }
        }
        return range;
    }

    public static void main(String[] args) {
        int[] test = SortUtils.genIntRandomArray(10, 10);
        System.out.println(SortUtils.toString(test));
        stableSort(test);
        System.out.println(SortUtils.toString(test));

        System.out.println(SortUtils.dataChecker(CountSort::sort, 100_000));
    }
}
