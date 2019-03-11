package com.dang.binarysearch;

/**
 * 给定一个有序数组 arr, 其中不含有重复元素, 请找到
 * 满足 arr[i]==i 条件的最左的位置, 如果所有位置上
 * 的数都不满足条件, 返回 -1
 * @author dht925nerd@126.com
 * @date 2019/03/11
 */
public class Puzzle4 {

    private static int solution(int[] arr){
        if (arr == null || arr.length == 0) return -1;
        if (arr[0] > arr.length - 1 || arr[arr.length - 1] < 0) return -1;
        int res = -1, start = 0, end = arr.length - 1, mid;
        while (start <= end){
            mid = (end + start) / 2;
            if (arr[mid] > mid){
                start = mid + 1;
            } else if (arr[mid] < mid){
                end = mid - 1;
            } else if (arr[mid] == mid){
                res = mid;
                end = mid - 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 4, 5, 5, 6};
        System.out.println(solution(arr));
    }

}
