package com.zhgwei.algorithm.sort;

import java.util.Arrays;

/**
 * TODO
 * @author zhgwei
 * @date 2020-09-16
 */
public class MergeSort {
    public static void sort(int[] arr) {
        sort(arr, 0, arr.length-1);
    }

    private static void sort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        if ((end-start) == 1) {
            if (arr[start] > arr[end]) {
                SortUtils.swap(arr, start, end);
            }
            return;
        }
        int mid = start + (end - start) /2;
        sort(arr, start, mid);
        sort(arr, mid+1, end);
        mergeSorted(arr, start, end, mid+1);
    }

    private static void mergeSorted(int[] arr, int start, int end, int mid) {
        int[] temp = new int[end-start+1];
        int left = start;
        int right = mid;
        int tempi = 0;

        while (left < mid && right <= end) {
            temp[tempi++] = arr[left] <= arr[right] ? arr[left++] : arr[right++];
        }
        while (left < mid) {
            temp[tempi++] = arr[left++];
        }
        while (right <= end) {
            temp[tempi++] = arr[right++];
        }
        System.arraycopy(temp, 0, arr, start + 0, temp.length);
    }

    public static void main(String[] args) {
        boolean flag = true;
        for (int i = 0; i< 50000; i++) {
            int[] arr = SortUtils.genIntRandomArray(100, 50);
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
