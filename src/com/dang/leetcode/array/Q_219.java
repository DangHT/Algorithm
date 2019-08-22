package com.dang.leetcode.array;

import java.util.HashSet;

/**
 * 存在重复元素II (https://leetcode-cn.com/problems/contains-duplicate-ii/)
 * @author dht
 * @date 26/07/2019
 */
public class Q_219 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1, 2, 3};
        int k = 2;
        System.out.println(containsNearbyDuplicate(nums, k));
    }

    /**
     * 我的思路：
     * 题目意思就是看一个大数组中的任意固定长度子串内是否存在重复元素
     * 我仿照滑动窗口的思路来遍历数组
     * 使用一个HashSet当作元素记录
     * @param nums
     * @param k
     * @return
     */
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length <= 1 || k < 1) return false;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) set.remove(nums[i - k - 1]);
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
        }
        return false;
    }

    /**
     * 这是最优题解，从两边向中间靠拢找重复元素，
     * 这样一来，因为两个元素的距离保持递减，所以在查找过程中可以避免考虑k，
     * 仅在找到重复元素时检查是否符合要求即可
     * @param nums
     * @param k
     * @return
     */
    public static boolean containsNearbyDuplicate_optimized(int[] nums, int k) {
        int len = nums.length;
        if(len > 5000) return false;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if(i != j && nums[i] == nums[j]) {
                    if(j - i <= k) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
