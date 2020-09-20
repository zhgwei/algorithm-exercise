package com.zhgwei.algorithm.sort;

import java.util.Arrays;

/**
 * TODO add javadoc for com.zhgwei.algorithm.sort.HeapSort
 *
 * @author zhgwei
 * @date 2020-09-19
 */
public class HeapSort {

    public static void sort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }
        // 构建原始大堆
        for (int i = arr.length/2 -1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }

        // 交换堆顶到堆尾, 堆大小减一, 调整堆
        for (int i = arr.length-1; i >= 0; i--) {
            SortUtils.swap(arr, 0, i);
            adjustHeap(arr, 0, i);
        }
    }

    /**
     * TODO
     * @param arr 数组
     * @param node 节点下标, 不小于 0
     * @param len 堆的大小
     */
    private static void adjustHeap(int[] arr, int node, int len) {
        int temp = arr[node];
        for (int i = node*2+1; i < len; i = i*2+1) {
            // 找出子节点中最大的那个
            if ((i+1) < len && arr[i+1] > arr[i]) {
                i++;
            }
            // 若子节点大, 子节点直接赋值父节点, 父节点节点下标修改为子节点下标, 否则不做修改结束循环
            // 由于父子节点交换后, 原子节点的数值变化, 需要以变化的子节点为父节点, 再次调整
            if (arr[i] > temp) {
                arr[node] = arr[i];
                node = i;
            } else {
                break;
            }
        }
        arr[node] = temp;
    }

    public static void main(String[] args) {
        System.out.println(SortUtils.dataChecker(HeapSort::sort, 100_000));
    }
}
