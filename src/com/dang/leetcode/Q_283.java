package com.dang.leetcode;

/**
 * 移动零(https://leetcode-cn.com/problems/move-zeroes/)
 * @author dht
 * @date 16/08/2019
 */
public class Q_283 {

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
        for (int i : nums) {
            System.out.print(i + ", ");
        }
    }

    /**
     * 记录下出现0的位置，再记录0后面连续的不为零的数，逐个向前补位
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int count = 0, tmp = 0;
        for (int i = 0; i < nums.length && nums[i] != 0; i++)
            tmp++;
        for (int i = tmp; i < nums.length; i++) {
            if (nums[i] != 0) {
                for (int j = i; j < nums.length && nums[j] != 0; j++)
                    count++;
                for (int j = 0; j < count; j++) {
                    nums[tmp + j] = nums[i + j];
                    nums[i + j] = 0;
                }
                i += count;
                tmp += count;
                count = 0;
            }
        }
    }

}
