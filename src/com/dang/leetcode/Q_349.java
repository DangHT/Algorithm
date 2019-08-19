package com.dang.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 两个数组中的交集(https://leetcode-cn.com/problems/intersection-of-two-arrays/)
 * @author dht
 * @date 19/08/2019
 */
public class Q_349 {

    public static void main(String[] args) {
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        int[] nums = intersection(nums1, nums2);
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        if (null == nums1 || null == nums2) return null;
        HashSet<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for (int i : nums1) {
            set.add(i);
        }
        for (int i : nums2) {
            if (set.contains(i)) {
                list.add(i);
                set.remove(i);
            }
        }
        int[] nums = new int[list.size()];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = list.get(i);
        }
        return nums;
    }

}
