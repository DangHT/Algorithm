package com.dang.binarysearch;

/**
 * 给定一个无无序数组 arr, 已知任意相邻的两个元素值都不重复,
 * 请返回任意一个局部最小的位置
 * 所谓局部最小的位置是指, 如果 arr[0] < arr[1], 那么位置0
 * 就是一个局部最小位置, 如果 arr[N-1](也就是 arr 最右的数)
 * 小于 arr[N-2], 那么位置 N-1 也是局部最小的位置, 如果位置i
 * 既不是最左位置也不是最右位置, 那么只需要满足 arr[i] 同时小于
 * 它左右两侧的值即(arr[i-1]和arr[i+1]), 那么位置 i 也是一个
 * 局部最小位置
 * @author dht925nerd@126.com
 * @date 2019/03/08
 */
public class Puzzle1 {

    private static int solution(int[] arr){
        if (arr == null || arr.length == 0) return -1;
        if (arr[0] < arr[1]) return 0;
        if (arr[arr.length - 1] < arr[arr.length - 2]) return arr.length - 1;
        return findMin(arr, 0, arr.length - 1);
    }

    private static int findMin(int[] arr, int start, int end){
        if (end - start <= 1) return -1;
        int mid = (end + start) / 2;
        if (arr[mid] < arr[mid - 1] && arr[mid] < arr[mid + 1]) return mid;
        if (arr[mid] >= arr[mid - 1]){
            int temp = findMin(arr, start, mid);
            if (temp >= 0) return temp;
        }
        if (arr[mid] >= arr[mid + 1]){
            int temp = findMin(arr, mid, end);
            if (temp >= 0) return temp;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2};
        System.out.println(solution(arr));
    }

}
