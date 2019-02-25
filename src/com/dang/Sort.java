package com.dang;

/**
 * 排序算法
 * @author dht925nerd@126.com
 * @date 2019/02/25
 */
public class Sort {

    /**
     * 选择排序
     * @param array 待排数组
     */
    public static void selectionSort(int[] array){
        if (array == null || array.length == 0){ return; }
        for (int i = 0; i < array.length; i++){
            int min = Integer.MAX_VALUE;
            int minPos = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < min) {
                    min = array[j];
                    minPos = j;
                }
            }
            array[minPos] = array[i];
            array[i] = min;
        }
    }

    /**
     * 冒泡排序
     * @param array 待排数组
     */
    public static void bubbleSort(int[] array){
        if (array == null || array.length == 0){ return; }
        for (int i = array.length - 1; i >= 0; i--){
            boolean flag = true;
            for (int j = 0; j < i; j++){
                if (array[j] > array[j + 1]){
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    flag = false;
                }
            }
            if (flag) return;
        }
    }

    /**
     * 插入排序
     * @param array 待排数组
     */
    public static void insertionSort(int[] array){
        if (array == null || array.length ==0){ return; }
        for (int i = 1; i < array.length; i++){
            for (int j = i; j > 0; j--){
                if (array[j] < array[j - 1]){
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                } else {
                    break;
                }
            }
        }
    }

    /**
     * 希尔排序
     * @param array 待排数组
     */
    public static void shellSort(int[] array){
        if (array == null || array.length ==0){ return; }
        for (int dis = array.length / 2; dis > 0; dis /= 2){
            for (int pos = dis; pos < array.length; pos++){
                for (int i = pos; i >= dis && array[i] < array[i - dis]; i -= dis){
                    int temp = array[i];
                    array[i] = array[i - dis];
                    array[i - dis] = temp;
                }
            }
        }
    }

    /**
     * 堆排序
     * @param array 待排数组
     */
    public static void heapSort(int[] array){
        if (array == null || array.length ==0){ return; }
        buildHeap(array);
        for (int i = array.length - 1; i >= 0; i--){
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;
            int j = 0;
            downAdjust(array, j, i);
        }
    }

    /**
     * 建立最大堆
     * @param array 待调数组
     */
    private static void buildHeap(int[] array){
        if (array == null || array.length ==0){ return; }
        for (int i = array.length / 2 - 1; i >= 0; i--){
            downAdjust(array, i, array.length);
        }
    }

    /**
     * 最大堆向下过滤调整
     * @param array 待调数组
     * @param j 堆顶
     * @param height 调整高度
     */
    private static void downAdjust(int[] array, int j, int height) {
        while (j * 2 < height) {
            if (j * 2 + 2 < height && array[j * 2 + 2] > array[j] && array[j * 2 + 2] > array[j * 2 + 1]){
                int temp = array[j * 2 + 2];
                array[j * 2 + 2] = array[j];
                array[j] = temp;
                j = j * 2 + 2;
            } else if (j * 2 + 1 < height && array[j * 2 + 1] > array[j]){
                int temp = array[j * 2 + 1];
                array[j * 2 + 1] = array[j];
                array[j] = temp;
                j = j * 2 + 1;
            } else break;
        }
    }
}
