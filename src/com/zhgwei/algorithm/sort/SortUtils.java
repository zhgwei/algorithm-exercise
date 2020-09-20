package com.zhgwei.algorithm.sort;

import java.util.Arrays;
import java.util.Random;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * 排序工具类
 * @author zhgwei
 * @date 2020-09-14
 */
public class SortUtils {
    /**
     * 数组交换两个值
     * @param arr
     * @param a
     * @param b
     */
    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    /**
     * 将数组转化为 {@link String}, 默认分隔符为 ","
     * @param arr
     * @return
     */
    public static String toString(int[] arr) {
        return toString(arr, ",");
    }

    /**
     * 将数组转化为 {@link String}
     * @param arr
     * @param delimiter 分隔符
     * @return
     */
    public static String toString(int[] arr, String delimiter) {
        return Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining(delimiter));
    }

    /**
     * 打印数组, 分割符为逗号
     * @param arr
     */
    public static void printArr(int[] arr) {
        System.out.println(toString(arr));
    }

    /**
     * 生成随机数组, 数组最大长度 1000, 数值最大 1000
     * @return 随机数组
     */
    public static int[] genIntRandomArray() {
        return genIntRandomArray(1000, 1000);
    }

    /**
     * 生成随机数组, 可以指定数组最大长度, 数值最大值
     * @param maxLength 数组最大长度
     * @param maxNum 数值最大值
     * @return 随机数组
     */
    public static int[] genIntRandomArray(int maxLength, int maxNum) {
        Random r = new Random();

        int[] arr = new int[r.nextInt(maxLength)];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(maxNum);
        }
        return arr;
    }

    /**
     * 校验数组相等
     * @param a
     * @param b
     * @return
     */
    public static boolean checkSame(int[] a, int[] b) {
        if (a.length != b.length) {
            return false;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean dataChecker(Sorter sorter, int num) {
        boolean flag = true;
        for (int i = 0; i< num && flag; i++) {
            int[] arr = SortUtils.genIntRandomArray(1000, 1000);
            int[] arrTest = Arrays.copyOf(arr, arr.length);

            Arrays.sort(arr);
            sorter.sort(arrTest);

            flag = SortUtils.checkSame(arr, arrTest);
        }
        return true;
    }

    /**
     * 排序算法 lambda 接口
     */
    @FunctionalInterface
    public interface Sorter {
        void sort(int[] arr);
    }
}
