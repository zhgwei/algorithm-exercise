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
