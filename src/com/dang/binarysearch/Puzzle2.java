package com.dang.binarysearch;

/**
 * 给定一个有序数组 arr, 再给定一个整数 num,
 * 请在 arr 中找到 num 这个数出现的最左边的位置
 * @author dht925nerd@126.com
 * @date 2019/03/08
 */
public class Puzzle2 {

    private static int solution(int[] arr, int num){
        if (arr == null || arr.length == 0) return -1;
        //res:最后一次找到 num 的位置
        int res = -1, start = 0, end = arr.length - 1, mid;
        while (start <= end){
            mid = (end + start) / 2;
            if (end == start){
                if (arr[end] == num)
                    res = end;
                break;
            }
            if (arr[mid] == num){
                res = mid;
                end = mid - 1;
            }
            if (arr[mid] < num){
                start = mid + 1;
            }
            if (arr[mid] > num){
                end = mid - 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4};
        System.out.println(solution(arr, 4));
    }

}
