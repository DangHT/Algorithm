package com.dang.leetcode.array;

/**
 * 至少是其他数字两倍的最大数(https://leetcode-cn.com/problems/largest-number-at-least-twice-of-others/)
 * @author dht
 * @date 02/12/2019
 */
public class Q_747 {
    public int dominantIndex(int[] nums) {
        if (nums.length < 2) return 0;
        int max, maxIndex, sec;
        if (nums[0] > nums[1]) {
            max = nums[0];
            maxIndex = 0;
            sec = nums[1];
        } else {
            max = nums[1];
            maxIndex = 1;
            sec = nums[0];
        }
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] > max) {
                sec = max;
                max = nums[i];
                maxIndex = i;
            } else if (nums[i] > sec) {
                sec = nums[i];
            }
        }
        return max >= sec * 2 ? maxIndex : -1;
    }
}
