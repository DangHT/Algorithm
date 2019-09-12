package com.dang.leetcode.array;

/**
 * 最大连续1的个数(https://leetcode-cn.com/problems/max-consecutive-ones/)
 * @author dht
 * @date 11/09/2019
 */
public class Q_485 {

    public static void main(String[] args) {
        int[] nums = {0};
        System.out.println(findMaxConsecutiveOnes(nums));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int max = 0, temp = 0;
        for (int i : nums) {
            if (i == 0) {
                max = Math.max(max, temp);
                temp = 0;
            } else {
                temp++;
            }
        }
        max = Math.max(max, temp);
        return max;
    }

}
