package com.zhgwei.algorithm.sort;

import java.util.Arrays;

/**
 * 冒泡排序, 时间复杂度 O(n^2), 最好 O(n), 空间复杂度 O(1)
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
        System.out.println(SortUtils.dataChecker(BubbleSort::sort, 100_000));
    }
}
