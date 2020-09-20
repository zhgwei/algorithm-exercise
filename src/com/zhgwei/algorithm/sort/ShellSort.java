package com.zhgwei.algorithm.sort;

import java.util.Arrays;

/**
 * @author zhgwei
 * @date 2020-09-15
 */
public class ShellSort {

    public static void sort(int[] arr) {
        int h = 1;
        while (h <= arr.length) {
            h = h*3+1;
        }
        for (int i = 4; i > 0; i >>= 1) {
            insertSort(arr, i);
        }
    }

    private static void insertSort(int[] arr, int gape) {
        for (int i = gape; i < arr.length; i ++) {
            for (int j = i; j > gape-1; j -= gape) {
                if (arr[j] < arr[j-gape]) {
                    SortUtils.swap(arr, j, j-gape);
                } else {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(SortUtils.dataChecker(ShellSort::sort, 100_000));
    }
}
