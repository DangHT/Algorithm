package com.dang.stackandqueue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 有一个整型数组 arr 和一个大小为 w 的窗口从数组最左边滑到最右边,
 * 窗口每次向右边滑动一个位置, 返回一个长度为 n-w+1 的数组 res,
 * res[i]表示每一种窗口状态下的最大值,
 * 以数组[4,3,5,4,3,3,6,7], w=3 为例, 因为第一个窗口[4,3,5]的最大值为5,
 * 第二个窗口[3,5,4]的最大值为5, 第三个窗口[5,4,3]的最大值为5, 第四个窗口
 * [4,3,3]的最大值为4, 第五个窗口[3,3,6]的最大值为6, 第六个窗口[3,6,7]的
 * 最大值为7, 所以最终返回[5,5,5,4,6,7]
 * @author dht925nerd@126.com
 * @date 2019/03/04
 */
public class Puzzle5 {

    /**
     * 时间复杂度O(N*W)
     * @param arr arr
     * @param w w
     * @return answer
     */
    private static int[] solution1(int[] arr, int w){
        if (arr == null || w <= 0 || w > arr.length) return null;
        int[] result = new int[arr.length - w + 1];
        for (int i = 0; i < result.length; i++){
            result[i] = max(arr, i, w);
        }
        return result;
    }

    private static int max(int[] arr, int i, int range){
        if (arr == null || i < 0 || i > arr.length - range) return -1;
        int max = Integer.MIN_VALUE;
        for (int j = 0; j < range; j++){
            if (arr[i + j] > max) max = arr[i + j];
        }
        return max;
    }

    /**
     * 最优解: 时间复杂度O(N)
     * 双端队列 qmax={}, 双端队列存放着数组中的下标值
     * 假设当前数为 arr[i], 放入规则如下:
     * 1. 如果 qmax 为空, 直接把下标 i 放入 qmax 中
     * 2. 如果 qmax 非空, 取出当前 qmax 队尾存放的下标 j,
     *    如果 arr[j] > arr[i], 直接把下标 i 放进 qmax 队尾
     * 3. 如果 arr[j] <= arr[i], 则一直从 qmax 的队尾弹出下标,
     *    直到某个下标在 qmax 中对应的值大于 arr[i], 把 i 放入
     *    qmax 队尾
     * 假设当前数为 arr[i], 弹出规则如下:
     * 如果 qmax 队头下标等于 i-w, 弹出 qmax 当前队头下标
     * @param arr arr
     * @param w w
     * @return answer
     */
    private static int[] solution2(int[] arr, int w){
        if (arr == null || w <= 0 || w > arr.length) return null;
        int[] result = new int[arr.length - w + 1];
        Deque<Integer> qmax = new ArrayDeque<>();
        int i, j, k = 0;
        for (i = 0; i < arr.length; i++){
            if (!qmax.isEmpty()){
                j = qmax.getLast();
                if (arr[j] <= arr[i]){
                    while (!qmax.isEmpty()){
                        if (arr[qmax.getLast()] > arr[i])
                            break;
                        else qmax.pollLast();
                    }
                }
            }
            qmax.add(i);
            if (!qmax.isEmpty() && qmax.getFirst() == i - w) qmax.pollFirst();
            if (i >= w - 1) result[k++] = arr[qmax.getFirst()];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {4,3,5,4,3,3,6,7};
        for (int i : solution2(arr, 3)){
            System.out.print(i + " ");
        }
    }

}
