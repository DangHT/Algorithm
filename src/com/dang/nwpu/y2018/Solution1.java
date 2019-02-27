package com.dang.nwpu.y2018;

/**
 * 编写程序实现插入排序或者选择排序算法
 * @author dht925nerd@126.com
 * @date 2019/02/26
 */
public class Solution1 {

    private static void insertionSort(int[] array){
        if (array == null || array.length == 0) return;
        int temp;
        for (int i = 1; i < array.length; i++){
            for (int j = i - 1, k = i; j >= 0 && array[k] < array[j]; j--, k--){
                temp = array[k];
                array[k] = array[j];
                array[j] = temp;
            }
        }
    }

    private static void selectionSort(int[] array){
        if (array == null || array.length == 0) return;
        int min, minPos = 0, temp;
        for (int i = 0; i < array.length; i++){
            min = Integer.MAX_VALUE;
            for (int j = i; j < array.length; j++){
                if (min > array[j]){
                    min = array[j];
                    minPos = j;
                }
            }
            temp = array[i];
            array[i] = array[minPos];
            array[minPos] = temp;
        }
    }

    private static void printArray(int[] array){
        for (int i : array){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = {8, 5, 6, 2, 1, 3, 4, 7, 0, 9};
        selectionSort(array);
        printArray(array);
    }

}
