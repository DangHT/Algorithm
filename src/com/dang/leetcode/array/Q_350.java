package com.dang.leetcode.array;

import java.util.*;

/**
 * 两个数组中的交集II(https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/)
 * @author dht
 * @date 20/08/2019
 */
public class Q_350 {

    public static void main(String[] args) {
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        int[] nums = intersect_02(nums1, nums2);
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }

    public static int[] intersect_01(int[] nums1, int[] nums2) {
        if (null == nums1 || null == nums2) return null;
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i : nums1) {
            if (!map.containsKey(i)) {
                map.put(i, 1);
            } else {
                map.replace(i, map.get(i) + 1);
            }
        }
        for (int i : nums2) {
            if (map.containsKey(i) && map.get(i) != 0) {
                list.add(i);
                map.replace(i, map.get(i) - 1);
            }
        }
        int[] num = new int[list.size()];
        for (int i = 0; i < num.length; i++) {
            num[i] = list.get(i);
        }
        return num;
    }

    public static int[] intersect_02(int[] nums1, int[] nums2) {
        if (null == nums1 || null == nums2) return null;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<>();
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                list.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]){
                i++;
            } else {
                j++;
            }
        }
        int[] num = new int[list.size()];
        for (int n = 0; n < num.length; n++) {
            num[n] = list.get(n);
        }
        return num;
    }

}
