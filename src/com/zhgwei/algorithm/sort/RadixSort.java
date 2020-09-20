package com.zhgwei.algorithm.sort;

import java.util.Arrays;

/**
 * 基数排序, 时间复杂度: O(k*n), k 为最大数的位数, 如: [123, 234, 3456, 97, 736, 13795], 最大数 13795, 位数 5
 * 所以 k=5; 空间复杂度 O(n); 属于稳定排序
 * 分低位优先和高位优先
 *
 * @author zhgwei
 * @date 2020-09-18
 */
public class RadixSort {

    public static void sort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }

        int[] newArr = new int[arr.length];
        int[] countArr = new int[10];

        int k = digitCount(arr);
        for (int i = 0; i < k; i++) {
            int divisor = (int) Math.pow(10, i);
            // 类似计数排序进行排序
            for (int value : arr) {
                countArr[value / divisor % 10]++;
            }
            for (int j = 1; j < countArr.length; j++) {
                countArr[j] += countArr[j-1];
            }
            for (int j = arr.length-1; j >= 0; j--) {
                int index = --countArr[arr[j]/divisor % 10];
                newArr[index] = arr[j];
            }
            System.arraycopy(newArr, 0, arr, 0, arr.length);
            Arrays.fill(countArr, 0);
        }
    }

    private static int digitCount(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int count = 0;
        while (max > 0) {
            max /= 10;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] test = SortUtils.genIntRandomArray(10, 200000);
        SortUtils.printArr(test);
        sort(test);
        SortUtils.printArr(test);

        System.out.println(SortUtils.dataChecker(RadixSort::sort, 100_000));
    }
}
