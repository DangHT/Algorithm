package com.dang.leetcode.array;

import java.util.Arrays;

/**
 * 数组中的K-diff数对(https://leetcode-cn.com/problems/k-diff-pairs-in-an-array/)
 * @author dht
 * @date 22/09/2019
 */
public class Q_532 {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        System.out.println(findPairs(nums, 0));
    }

    public static int findPairs(int[] nums, int k) {
        if (nums == null || nums.length < 2 || k < 0) return 0;
        Arrays.sort(nums);
        int i = 0, j = 1, cur, count = 0;
        if (k == 0) {
            for (int n = 0; n < nums.length - 1; n++) {
                if (nums[n] == nums[n + 1]) count++;
                while (n < nums.length - 1 && nums[n] == nums[n + 1]) n++;
            }
            return count;
        }
        while (i < nums.length && j < nums.length) {
            if (k == nums[j] - nums[i]) {
                count++;
                cur = nums[j];
                while (j < nums.length && cur == nums[j]) j++;
                cur = nums[i];
                while (i < nums.length && cur == nums[i]) i++;
            }
            else if (k < nums[j] - nums[i]) {
                cur = nums[i];
                while (i < nums.length && cur == nums[i]) i++;
            }
            else {
                cur = nums[j];
                while (j < nums.length && cur == nums[j]) j++;
            }
        }
        return count;
    }

}
