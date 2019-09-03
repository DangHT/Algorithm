package com.dang.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 找到所有数组中消失的数字(https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/)
 * @author dht
 * @date 02/09/2019
 */
public class Q_448 {

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> list = findDisappearedNumbers_02(nums);
        for (int i : list) {
            System.out.print(i + " ");
        }
    }

    /**
     * 改变视角，关注数组下标
     * 1. 对每个数组元素对应的下标的位置的元素加 n
     * 2. 遍历数组，值 <= n 的数组元素对应的下标就是消失的数字
     * @param nums
     * @return
     */
    public static List<Integer> findDisappearedNumbers_01(int[] nums) {
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = (nums[i] - 1) % nums.length;
            nums[index] += nums.length;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= nums.length) {
                results.add(i + 1);
            }
        }
        return results;
    }

    /**
     * 对数组排序，使用异或运算交换两个变量的值
     * @param nums
     * @return
     */
    public static List<Integer> findDisappearedNumbers_02(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                res.add(i + 1);
            }
        }
        return res;
    }

    private static void swap(int[] nums, int index1, int index2) {
        if (index1 == index2) {
            return;
        }
        nums[index1] = nums[index1] ^ nums[index2];
        nums[index2] = nums[index1] ^ nums[index2];
        nums[index1] = nums[index1] ^ nums[index2];
    }

}
