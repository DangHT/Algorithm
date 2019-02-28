package com.dang.nwpu.y2017;

import com.dang.Sort;

/**
 * 编写程序实现折半查找, 冒泡排序或者快速排序算法
 * @author dht925nerd@126.com
 * @date 2019/02/27
 */
public class Solution1 {

    /**
     * 二分查找
     * @param array 有序数组
     * @param target 目标
     * @return 目标下标(若不存在返回-1)
     */
    private static int binarySearch(int[] array, int target){
        if (array == null || array.length == 0) return -1;
        int start = 0, end = array.length - 1, center = (start + end) / 2;
        while (start < end){
            if (target == array[center]) return center;
            if (target < array[center]) end = center;
            if (target > array[center]) start = center;
            center = start + end / 2;
        }
        return -1;
    }


    private static void bubbleSort(int[] array){
        if (array == null || array.length == 0) return;
        int temp;
        boolean flag;
        for (int i = 0; i < array.length; i++){
            flag = true;
            for (int j = 1; j < array.length - i; j++){
                if (array[j - 1] > array[j]){
                    temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                    flag = false;
                }
            }
            if (flag) return;
        }
    }

    /**
     * 快速排序
     * {@link Sort#quickSort(int[])}
     * @param array 待排数组
     */
    private static void quickSort(int[] array){
        Sort.quickSort(array);
    }

    public static void main(String[] args) {
        int[] array = {6, 7, 8, 1, 2, 3, 4, 5, 8, 2, 9, 10, 11, 23, 4, 54, 6, 77, 34, 45, 89, 67};
        bubbleSort(array);
        for (int i : array){
            System.out.print(i + " ");
        }
    }

}
