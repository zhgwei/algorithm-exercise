package com.zhgwei.algorithm.sort;

import java.util.Arrays;

/**
 * TODO
 * @author zhgwei
 * @date 2020-09-17
 */
public class QuickSort {

    public static void sort(int[] arr) {
        sort(arr, 0, arr.length);
    }

    private static void sort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = axisSort(arr, start, end);
        sort(arr, start, pivot);
        sort(arr, pivot+1, end);
    }

    private static int axisSort(int[] arr, int start, int end) {
        int pivot = end-1;
        int left = start;
        int right = pivot-1;

        boolean leftStop = false;
        boolean rightStop = false;
        while (right >= left) {
            if (arr[left] <= arr[pivot]) {
                left++;
            } else {
                leftStop = true;
            }
            if (arr[right] >= arr[pivot]) {
                right--;
            } else {
                rightStop = true;
            }
            if (leftStop && rightStop) {
                SortUtils.swap(arr, left, right);
                left++;
                right--;
                leftStop = false;
                rightStop = false;
            }
        }
        if (leftStop) {
            SortUtils.swap(arr, left, pivot);
            return left;
        }
        if (rightStop) {
            SortUtils.swap(arr, ++right, pivot);
            return right;
        }
        SortUtils.swap(arr, ++right, pivot);
        return right;
    }

    public static void main(String[] args) {
        System.out.println(SortUtils.dataChecker(QuickSort::sort, 100_000));
    }
}
