package com.dang;

/**
 * 排序算法
 * @author dht925nerd@126.com
 * @date 2019/02/25
 */
public class Sort {

    /**
     * 使用快速排序的最低阈值
     */
    private static final int QUICKSORT_THRESHOLD = 10;

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

    /**
     * 归并排序(递归)
     * @param array 待排数组
     */
    public static void mergeSort(int[] array){
        if (array == null || array.length ==0){ return; }
        int[] tempArray = new int[array.length];
        mergeSort(array, tempArray, 0, array.length - 1);
    }

    /**
     * 将有序子列归并
     * @param array 原始数组
     * @param tempArray 归并缓存数组
     * @param lFrom 左子列起始位置
     * @param rFrom 右子列起始位置
     * @param rTo 右子列终点位置
     */
    private static void merge(int[] array, int[] tempArray, int lFrom, int rFrom, int rTo){
        //左子列终点位置, 假设左右两列紧挨
        int lTo = rFrom - 1;
        //缓存数组存储的起始位置
        int temp = lFrom;
        //归并元素总数
        int sum = rTo - lFrom + 1;
        while (lFrom <= lTo && rFrom <= rTo){
            if (array[lFrom] <= array[rFrom]) tempArray[temp++] = array[lFrom++];
            else tempArray[temp++] = array[rFrom++];
        }
        while (lFrom <= lTo) tempArray[temp++] = array[lFrom++];
        while (rFrom <= rTo) tempArray[temp++] = array[rFrom++];
        for (int i = 0; i < sum; i++, rTo--){
            array[rTo] = tempArray[rTo];
        }
    }

    /**
     * 归并排序递归实现体
     * @param array 待排数组
     * @param tempArray 归并缓存数组
     * @param from 排序起始位置
     * @param to 排序终点位置
     */
    private static void mergeSort(int[] array, int[] tempArray, int from, int to){
        if (from < to){
            int center = (from + to) / 2;
            mergeSort(array, tempArray, from, center);
            mergeSort(array, tempArray, center + 1, to);
            merge(array, tempArray, from, center + 1, to);
        }
    }

    /**
     * 快速排序
     * @param array 待排数组
     */
    public static void quickSort(int[] array){
        quickSort(array, 0, array.length - 1);
    }

    /**
     * 快速排序实现体
     * 因为快速排序的不稳定性, 利用阈值保证效率,
     * 低于阈值执行插入排序{@link Sort#insertionSort(int[])}
     * @param array 待排数组
     * @param left 排序起始位置
     * @param right 排序终点位置
     */
    private static void quickSort(int[] array, int left, int right){
        if (array == null || array.length ==0){ return; }
        if (right - left >= QUICKSORT_THRESHOLD){
            int pivot = median3(array, left, right);
            int i = left, j = right - 1, temp;
            for (;;){
                while (array[++i] < pivot){}
                while (array[--j] > pivot){}
                if (i < j){
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                } else break;
            }
            temp = array[i];
            array[i] = array[right - 1];
            array[right - 1] = temp;
            quickSort(array, left, i - 1);
            quickSort(array, i + 1, right);
        } else {
            insertionSort(array);
        }
    }

    /**
     * 选取数组头, 中, 尾三者的中位数
     * @param array 原始数组
     * @param left 头
     * @param right 尾
     * @return 中位数
     */
    private static int median3(int[] array, int left, int right){
        int center = (left + right) / 2;
        int temp;
        if (array[left] > array[center]){
            temp = array[left];
            array[left] = array[center];
            array[center] = temp;
        }
        if (array[left] > array[right]){
            temp = array[left];
            array[left] = array[right];
            array[right] = temp;
        }
        if (array[center] > array[right]){
            temp = array[center];
            array[center] = array[right];
            array[right] = temp;
        }
        /* 前三步执行完毕后, 取值情况一定为: array[left] <= array[center] <= array[right] */
        temp = array[center];
        array[center] = array[right - 1];
        array[right - 1] = temp;
        /* 将array[center](主元)放在right - 1位置上,
           后续子集划分仅需考虑array[left + 1]~array[right - 2]即可 */
        return array[right - 1];
    }

}
