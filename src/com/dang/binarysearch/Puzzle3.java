package com.dang.binarysearch;

/**
 * 给定一个有序循环数组 arr, 返回 arr 中的最小值
 * 有序循环数组是指, 有序数组左边任意长度的部分放到
 * 右边去, 右边的部分拿到左边来, 比如数组[1,2,3,3,4]
 * 是有序数组, [4,1,2,3,3]也是
 * @author dht925nerd@126.com
 * @date 2019/03/10
 */
public class Puzzle3 {

    private static int solution(int[] arr){
        if (arr == null || arr.length == 0) return Integer.MAX_VALUE;
        int left = 0, right = arr.length - 1, mid, min = Integer.MAX_VALUE;
        if (arr[left] < arr[right]) return arr[left];
        while (left < right){
            mid = (right + left) / 2;
            if (arr[left] > arr[mid]){
                right = mid - 1;
            } else if (arr[mid] > arr[right]){
                left = mid + 1;
            } else {
                for (int i = left; i <= right; i++){
                    if (min > arr[i]) min = arr[i];
                }
                break;
            }
        }
        if (min == Integer.MAX_VALUE) min = arr[left];
        return min;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 3, 4, 1};
        System.out.println(solution(arr));
    }

}
