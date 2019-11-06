package com.dang.leetcode.array;

/**
 * 子数组最大平均数 I(https://leetcode-cn.com/problems/maximum-average-subarray-i/)
 * @author dht
 * @date 02/11/2019
 */
public class Q_643 {

    public static void main(String[] args) {
        Q_643 q_643 = new Q_643();

        int[] nums = {1,12,-5,-6,50,3};
        System.out.println(q_643.findMaxAverage(nums, 4));
    }

    public double findMaxAverage(int[] nums, int k) {
        long sum = 0, max;
        if (nums.length <= k) {
            for (int i : nums) {
                sum += i;
            }
            return (double) sum / nums.length;
        }
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        max = sum;
        for (int i = 0; i < nums.length - k; i++) {
            sum -= nums[i];
            sum += nums[i + k];
            if (max < sum) {
                max = sum;
            }
        }
        return (double) max / k;
    }

}
