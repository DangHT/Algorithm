package com.dang.leetcode.array;

/**
 * 寻找数组的中心索引(https://leetcode-cn.com/problems/find-pivot-index/)
 * @author dht
 * @date 26/11/2019
 */
public class Q_724 {

    public int pivotIndex(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int[] sums = new int[nums.length];
        sums[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            sums[i] += sums[i - 1] + nums[i - 1];
        }
        int maxSum = sums[sums.length - 1] + nums[nums.length - 1];
        for (int i = 0; i < nums.length; i++) {
            if (sums[i] == maxSum - sums[i] - nums[i]) return i;
        }
        return -1;
    }

}
