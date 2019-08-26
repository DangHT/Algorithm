package com.dang.leetcode.array;

import java.util.Arrays;

/**
 * 第三大的数(https://leetcode-cn.com/problems/third-maximum-number/)
 * @author dht
 * @date 25/08/2019
 */
public class Q_414 {

    public static void main(String[] args) {
        int[] nums = {1, 2, Integer.MIN_VALUE};
        System.out.println(thirdMax_02(nums));
    }

    public static int thirdMax_01(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        Arrays.sort(nums);
        int count = 1, tmp = nums[nums.length - 1];
        int pre = tmp;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] != tmp) {
                count++;
                pre = tmp;
                tmp = nums[i];
            }
            if (count == 3) break;
        }
        return count == 3 ? tmp : pre;
    }

    public static int thirdMax_02(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        long[] maxs = {Long.MIN_VALUE, Long.MIN_VALUE, Long.MIN_VALUE};
        for (int i : nums) {
            if (i == maxs[0] || i == maxs[1] || i == maxs[2]) continue;
            if (i > maxs[0]) {
                maxs[2] = maxs[1];
                maxs[1] = maxs[0];
                maxs[0] = i;
            } else if (i > maxs[1]) {
                maxs[2] = maxs[1];
                maxs[1] = i;
            } else if (i > maxs[2]) {
                maxs[2] = i;
            }
        }
        return (int) (maxs[2] == Long.MIN_VALUE ? maxs[0] : maxs[2]);
    }

}
