package com.dang.leetcode.array;

import java.util.Arrays;

/**
 * 数组拆分 I(https://leetcode-cn.com/problems/array-partition-i/)
 * @author dht
 * @date 25/09/2019
 */
public class Q_561 {

    public static void main(String[] args) {
        int[] nums = {1, 4, 3, 2};
        Q_561 q_561 = new Q_561();
        System.out.println(q_561.arrayPairSum(nums));
    }

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length - 1; i += 2) {
            sum += Math.min(nums[i], nums[i + 1]);
        }
        return sum;
    }

}
